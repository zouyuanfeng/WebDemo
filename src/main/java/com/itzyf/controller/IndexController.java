package com.itzyf.controller;

import com.itzyf.bean.ResultTest;
import com.itzyf.bean.Version;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author 依风听雨
 * @version 创建时间：2017/6/1 9:37
 */
@Controller
public class IndexController {

    Logger logger = Logger.getLogger(IndexController.class.getSimpleName());

    @RequestMapping("/")
    public ModelAndView index() {
        Map<String, Object> map = new HashMap<>();
        map.put("END", "我是测试的");
        return new ModelAndView("index", map);
    }

    @RequestMapping(value = "/fileUpload", method = RequestMethod.POST)
    public ModelAndView uploadFile(@RequestParam("file") MultipartFile file) {
        logger.info("上传文件:" + file.getOriginalFilename());
        String home = System.getProperty("catalina.home") + "/temp-img/";//临时上传的目录

        File uploadPath = new File(home);
        //如果目录不存在
        if (!uploadPath.exists()) {
            //创建目录
            uploadPath.mkdirs();
        }
        Map<String, Object> map = new HashMap<>();

        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        try {
            String path = saveBit(file.getInputStream(), home, suffix);
            map.put("END", "上传成功:" + path);
        } catch (IOException e) {
            e.printStackTrace();
            map.put("END", "上传失败:" + e.getMessage());
        }
        return new ModelAndView("index", map);
    }

    private String saveBit(InputStream inStream, String path, String suffix) throws IOException {
//        String guid = Guid.getRandomGUID();

        String name = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()) + "" + (new Random().nextInt(89) + 10);

        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        //创建一个Buffer字符串
        byte[] buffer = new byte[1024];
        //每次读取的字符串长度，如果为-1，代表全部读取完毕
        int len = 0;
        //使用一个输入流从buffer里把数据读取出来
        while ((len = inStream.read(buffer)) != -1) {
            //用输出流往buffer里写入数据，中间参数代表从哪个位置开始读，len代表读取的长度
            outStream.write(buffer, 0, len);
        }
        //关闭输入流
        inStream.close();
        //把outStream里的数据写入内存

        //得到图片的二进制数据，以二进制封装得到数据，具有通用性
        byte[] data = outStream.toByteArray();
        //new一个文件对象用来保存图片，默认保存当前工程根目录
        File imageFile = new File(path + name + suffix);
        //创建输出流
        FileOutputStream fileOutStream = new FileOutputStream(imageFile);
        //写入数据
        fileOutStream.write(data);
        return name + suffix;
    }

    @ResponseBody
    @RequestMapping("/version")
    public Version getVersion() {
        Version version = new Version();
        version.setDesc("这是新版本");
        version.setVersion("1.0.0");
        version.setUrl("http://61.144.207.154:8081/131d1464-4bf7-46d8-8237-2e7fa8440a24/2005/f3/26/f3263c4a-f8b4-4e01-b17b-c989309e7872/kfid/7613760/A481F57EC636781A2FDC0F68B19E22AB.apk?fsname=com.snda.wifilocating_4.2.01_3120.apk&csr=1bbd");
        return version;
    }

    @ResponseBody
    @RequestMapping("/login")
    public ResultTest onLogin() {
        ResultTest test = new ResultTest();
        test.setCode("LOGIN_001");
        test.setMessage("登录失败");
        return test;
    }



}
