//package com.testFastDfs;
//
//import com.taotao.common.utils.FastDFSClient;
//import org.csource.fastdfs.*;
//import org.junit.Test;
//
///**
// * @author LM_Code
// * @create 2019-04-20-18:12
// */
//public class FastDfsTest {
//    @Test
//    public void testUpload() throws Exception{
//        //创建配置文件(client.conf)，文件名任意：内容是tracker服务器的地址
//        //使用全局对象加载配置文件
//        ClientGlobal.init("D:\\IDEAworkspace\\taotao_parent\\taotao_web\\src\\main\\resources\\conf\\client.conf");
//        //创建一个TrackerClient对象
//        TrackerClient trackerClient = new TrackerClient();
//        //通过TrackerClient获得一个TrackerServer对象
//        TrackerServer trackerServer = trackerClient.getConnection();
//        //创建一个StorageServer引用，可以为null
//        StorageServer storageServer = null;
//        //创建一个StorageClient，参数需要TrackerServer和StorageServer
//        StorageClient storageClient = new StorageClient(trackerServer,storageServer);
//        //使用StorageClient上传文件
//        String[] strings = storageClient.upload_file("F:\\我的文件\\照片\\xian.jpg", "jpg", null);
//        for (String string : strings) {
//            System.out.println(string);
//        }
//    }
//    @Test
//    public void testFastDFSClient() throws Exception {
//        FastDFSClient fastDFSClient = new FastDFSClient("D:\\IDEAworkspace\\taotao_parent\\taotao_web\\src\\main\\resources\\conf\\client.conf");
//        String file = fastDFSClient.uploadFile("F:\\我的文件\\照片\\xian.jpg");
//        System.out.println(file);
//    }
//}
