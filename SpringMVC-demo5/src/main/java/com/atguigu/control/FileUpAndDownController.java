package com.atguigu.control;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@Controller
public class FileUpAndDownController {
    @RequestMapping("/testDown")
    public ResponseEntity<byte[]> testResponseEntity(HttpSession session) throws IOException {
        //获取ServletContext对象
        ServletContext servletContext = session.getServletContext();
        //获取服务器中文件的真实路径 把括号里面的字符串去掉就是获取当前服务器的真实路径
        String realPath = servletContext.getRealPath("/static/img/1.jpg");
        //创建输入流
        InputStream is = new FileInputStream(realPath);
        //创建字节数组  is.available() 文件输入流读取到的所有字节的长度
        byte[] bytes = new byte[is.available()];
        //将流读到字节数组中
        is.read(bytes);
        //创建HttpHeaders对象设置响应头信息
        MultiValueMap<String, String> headers = new HttpHeaders();
        //设置要下载方式以及下载文件的名字
        headers.add("Content-Disposition", "attachment;filename=1.jpg");
        //设置响应状态码
        HttpStatus statusCode = HttpStatus.OK;
        //创建ResponseEntity对象
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes, headers, statusCode);
        //关闭输入流
        is.close();
        return responseEntity;
    }
    @RequestMapping("/testUp")
    public String testUp(MultipartFile photo,HttpSession session) throws IOException {
        //获取文件名
        String originalFilename = photo.getOriginalFilename();
        ServletContext servletContext = session.getServletContext();
        //解决重复名字的问题 UUID+上传的文件名后缀=最后保存的文件名
        //IndexOf 是获取第一次出现的位置  lastIndexOf是获取最后一次出现的位置
        String suffixName=originalFilename.substring(originalFilename.lastIndexOf("."));
        String uuidName= UUID.randomUUID().toString();
        originalFilename=uuidName+suffixName;

        //获取photo所在的服务器的真实路径并且包括它自己
        String photoPath = servletContext.getRealPath("photo");
        //判断当前的文件夹是否存在
        File file = new File(photoPath);
        if (!file.exists()){
            file.mkdir();
        }
        //File.separator这个叫路径分隔符，专业的
        String finalPath=photoPath+File.separator+originalFilename;
        photo.transferTo(new File(finalPath));
        return "success";
    }
}
