package com.systec.control;

import org.springframework.boot.json.BasicJsonParser;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by wh on 7/6/2017.
 */

@RestController
public class UploadController {

    @ResponseBody
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public Map upload(@RequestParam("file") MultipartFile file, HttpServletRequest request, HttpServletResponse response) {
        BasicJsonParser json = new BasicJsonParser();
        response.addHeader("Access-Control-Allow-Origin", "*");
        if (file.isEmpty()) {
            return json.parseMap("{\"result\":\"400\",\"data\":\"文件为空\"}");
        }

        // 获取文件名
        String fileName = file.getOriginalFilename();
        System.out.println("上传的文件名为：" + fileName);

        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        System.out.println("上传的后缀名为：" + suffixName);

        // 文件上传路径
//        String filePath = "d://test//";

        String filePath = request.getSession().getServletContext().getRealPath("/") + "upload/";

        // 解决中文问题，liunx下中文路径，图片显示问题
        // fileName = UUID.randomUUID() + suffixName;

        File dest = new File(filePath + fileName);

        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }

        try {
            file.transferTo(dest);
            return json.parseMap("{\"result\":\"200\",\"data\":\"上传成功\"}");
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json.parseMap("{\"result\":\"200\",\"data\":\"上传失败\"}");
    }

    /***
     * 读取上传文件中得所有文件并返回
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/fileList", method = RequestMethod.GET)
    public List list(HttpServletRequest request) {
        String filePath = request.getSession().getServletContext().getRealPath("/") + "upload/";
        File uploadLest = new File(filePath);
        String[] fileNames = uploadLest.list();
        for (int i = 0; i < fileNames.length; i++) {
            //打印出文件名
            System.out.println(fileNames[i]);
        }
        return Arrays.asList(fileNames);
    }

}
