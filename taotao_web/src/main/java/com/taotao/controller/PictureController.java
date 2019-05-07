package com.taotao.controller;

import com.taotao.common.utils.FastDFSClient;
import com.taotao.common.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LM_Code
 * @create 2019-04-21-18:28
 */
@Controller
@RequestMapping("/pic")
public class PictureController {
    @Value("${IMAGE_SERVER_URL}")
    String IMAGE_SERVER_URL;
    @RequestMapping("/upload")
    @ResponseBody
    public String upLoadFile(MultipartFile uploadFile){
        try{
            //创建fastDFS的客户端
            FastDFSClient fastDFSClient = new FastDFSClient("classpath:conf/client.conf");
            //取文件扩展名
            String originalFilename = uploadFile.getOriginalFilename();
            String extName = originalFilename.substring(originalFilename.indexOf(".") + 1);
            //上传文件，并得到图片的地址和文件名
            String url = fastDFSClient.uploadFile(uploadFile.getBytes(), extName);
            //补充url
            url = IMAGE_SERVER_URL + url;
            //封装到对象里
            Map result = new HashMap();
            result.put("error", 0);
            result.put("url", url);
            return JsonUtils.objectToJson(result);
        }catch (Exception e){
            e.printStackTrace();
            Map result = new HashMap();
            result.put("error", 1);
            result.put("url", "图片上传失败");
            return JsonUtils.objectToJson(result);
        }
    }
}
