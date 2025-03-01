package com.su.shopping_manager_api.controller;

import com.su.shopping_common.result.BaseResult;
import com.su.shopping_common.service.FileService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/file")
public class FileController {
    @DubboReference
    private FileService fileService;

    /**
     * 上传文件
     * @param file
     * @return
     * @throws IOException
     */
    @PostMapping("/uploadImage")
    public BaseResult<String> uploadImage(MultipartFile file) throws IOException {
        //multipartFile没有实现序列化，不能在服务间传递
        byte[] bytes = file.getBytes();
        String imageUrl = fileService.uploadImage(bytes, file.getOriginalFilename());
        return BaseResult.ok(imageUrl);
    }

    /**
     * 删除文件
     * @param filePath
     * @return
     */
    @DeleteMapping("/delete")
    public BaseResult delete(String filePath){
        fileService.delete(filePath);
        return BaseResult.ok();
    }
}
