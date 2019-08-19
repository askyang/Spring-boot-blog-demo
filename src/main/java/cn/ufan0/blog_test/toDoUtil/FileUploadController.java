package cn.ufan0.blog_test.toDoUtil;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class FileUploadController {
    public String upload(@RequestParam MultipartFile file) throws IllegalStateException, IOException {
        // 判断是否为空文件
        if (file.isEmpty()) {
            return "上传文件不能为空";
        }
        // 文件类型
        String contentType = file.getContentType();
        // springmvc处理后的文件名
        String fileName = file.getName();
        // 原文件名即上传的文件名
        String origFileName = file.getOriginalFilename();
        // 文件大小
        Long fileSize = file.getSize();

        // 保存文件
        // 可以使用二进制流直接保存
        // 这里直接使用transferTo
        assert origFileName != null;
        file.transferTo(new File("C:\\Users\\Darksails\\Desktop\\Temp Code\\blog_test\\src\\main\\resources\\" + origFileName));

        return String.format(file.getClass().getName() + "方式文件上传成功！\n文件名:%s,文件类型:%s,文件大小:%s", origFileName, contentType, fileSize);
    }

}
