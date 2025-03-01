package com.su.shopping_file_service.service;

import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.su.shopping_common.result.BusException;
import com.su.shopping_common.result.CodeEnum;
import com.su.shopping_common.service.FileService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;

import java.io.ByteArrayInputStream;

@DubboService
public class FileServiceImpl implements FileService {
    @Autowired
    private FastFileStorageClient fastFileStorageClient;
    @Value("${fdfs.fileUrl}")
    private String fileUrl;//nginx访问fastdfs中文件的路径
    @Override
    public String uploadImage(byte[] fileBytes, String fileName) {
        if(fileBytes.length != 0){
            try {
                //1.将文件字节数组转为输入流
                ByteArrayInputStream inputStream = new ByteArrayInputStream(fileBytes);
                //2.从文件名获取文件后缀名
                String fileSuffix = fileName.substring(fileName.lastIndexOf(".")+1);
                //3.上传文件
                StorePath storePath = fastFileStorageClient.uploadFile(inputStream, inputStream.available(), fileSuffix, null);
                //4.返回文件路径
                String imageUrl = fileUrl + "/" +storePath.getFullPath();
                return imageUrl;
            }catch (Exception e){
                throw new BusException(CodeEnum.UPLOAD_FILE_ERROR);
            }

        }else {
            throw new BusException(CodeEnum.UPLOAD_FILE_ERROR);
        }
    }

    @Override
    public void delete(String filePath) {
        fastFileStorageClient.deleteFile(filePath);
    }
}
