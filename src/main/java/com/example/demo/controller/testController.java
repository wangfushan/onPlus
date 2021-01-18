package com.example.demo.controller;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.time.LocalDate;
@RestController
@ApiModel("testController接口返回")
@RequestMapping("/testController")
public class testController {

    @PostMapping(value = "/download")
    @ApiOperation(value="testName", notes="testBody", produces="application/json")
    public void download(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获取系统换行符
        String lineSeparator = System.getProperty("line.separator","\r\n");
        //准备数据
        String csvData = "1,2,3" + lineSeparator + "4,5,6" + lineSeparator;
        String fileName = "demo.csv";
        String encodedFileName;

        //支持IE内核，避免文件名中文乱码
        encodedFileName = URLEncoder.encode(fileName, "UTF-8");

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment;filename=" + encodedFileName);
        //避免csv文件内容中文乱码
        OutputStreamWriter osw = new OutputStreamWriter(response.getOutputStream(), "GBK");
        osw.write(csvData);
        osw.flush();
        osw.close();
    }

    @PostMapping(value = "/downloadv1")
    public void downloadv1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获取系统换行符
        String lineSeparator = System.getProperty("line.separator","\r\n");
        //准备数据
        String csvData = "1,2,3" + lineSeparator + "4,5,6" + lineSeparator;
        String fileName = "demo.csv";
        String encodedFileName;

        encodedFileName = new String(fileName.getBytes("UTF-8"),"ISO-8859-1");

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition","attachment;filename=" + encodedFileName);
        //避免csv文件内容中文乱码
        OutputStreamWriter osw = new OutputStreamWriter(response.getOutputStream(),"GBK");
        osw.write(csvData);
        osw.flush();
        osw.close();
    }

    public static void main(String[] args) {
/*        int b=1;
        int a = b / 10;
        int c = b % 10==0?(b/10):(b/10)+1;
        System.out.println(a + "，" + c);*/
  /*      int a1=10;
        int i = a1 % 2;
        int bb=0 % 2;
        int cc= -1 % 2;
        System.out.println(i);
        System.out.println(bb);
        System.out.println(cc);*/
        LocalDate localDate= LocalDate.now();

        System.out.println(localDate.getMonth());
        System.out.println(localDate.getMonthValue());
        System.out.println(localDate.getMonth());
        //System.out.println(localDate.);
    }
}
