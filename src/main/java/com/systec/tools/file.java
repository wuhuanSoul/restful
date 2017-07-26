package com.systec.tools;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

/**
 * Created by wh on 7/20/2017.
 */
@RestController
@RequestMapping(value = "file")
public class file {

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String fileUpLoad(MultipartFile file, HttpServletRequest request) {
        try {
            String fileName = "";
            if (!file.isEmpty()) {
                fileName = file.getOriginalFilename();
            }
            String filePath = request.getSession().getServletContext().getRealPath("/") + "uploads\\";
            File tempFile = new File(filePath);
            if (!tempFile.exists()) {
                tempFile.mkdirs();
            }
            BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(new File(filePath + fileName)));
            outputStream.write(file.getBytes());
            outputStream.flush();
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "找不到该文件，请重新上传！";
        } catch (IOException e) {
            e.printStackTrace();
            return "上传失败，请重新上传！";
        }
        return "上传成功！";
    }

    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public void fileDownLoad(HttpServletRequest request, HttpServletResponse response) {
        String tempFile = request.getSession().getServletContext().getRealPath("/") + "uploads\\";
        File file = new File(tempFile);
        File[] fileNames = file.listFiles();
        int num = fileNames.length;
        if (num > 0) {
            for (int i = 0;num > i; i++) {
                File f = fileNames[i];
                download(f, response);
            }
        }
    }

    public static void download(File file, HttpServletResponse response) {
        try {
            BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file));
            response.reset();
            response.setContentType("bin");
            response.addHeader("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"");
            OutputStream outputStream = response.getOutputStream();
            byte[] b = new byte[100];
            int len;
            while ((len = inputStream.read(b)) > 0) {
                outputStream.write(b, 0, len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
