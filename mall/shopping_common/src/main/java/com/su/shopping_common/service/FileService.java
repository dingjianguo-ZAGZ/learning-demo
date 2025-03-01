package com.su.shopping_common.service;
//文件服务
public interface FileService {
    /**
     * 文件上传
     * @param fileBytes 图片文件转成的字节数组
     * @param fileName 上传文件名
     * @return 上传成功后的文件访问路径
     */
    String uploadImage(byte[] fileBytes,String fileName);

    /**
     * 删除文件
     * @param filePath 文件路径
     */
    void delete(String filePath);


}
