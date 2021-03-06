package com.wm.spring.boot.Demo;

import com.alibaba.fastjson.JSONObject;
import com.wm.spring.boot.entity.User;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;

public class Demo {
    @Test
    public void test1(){
        User.Builder builder = new User.Builder();
        User user = builder.setId((long) 1).setNote("wm").setUsername("wm").builder();
        System.out.println(user.toString());

    }
    @Test
    public void test2(){
        HashMap<String, Object> hm = new HashMap<>();
        hm.put("userId",1);
        hm.put("productId",1);
        hm.put("quantity",1);
        JSONObject jsonObject = new JSONObject(hm);
        String url = "http://localhost:8080/buy";
        for (int i = 0; i < 10; i++) {
            String s = sendPost(url, jsonObject);
            System.out.println(s);
        }
    }

    @Test
    public void test3(){
        Multithreading m1 = new Multithreading();
//        Multithreading m2 = new Multithreading();
        Thread t1 = new Thread(m1);
//        Thread t2 = new Thread(m2);
        t1.start();
//        t2.start();
    }

    @Test
    public void test4(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("userId", 1);
        jsonObject.put("productId", 1);
        jsonObject.put("quantity", 1);
        System.out.println(jsonObject);
    }

    public static String sendPost(String url, JSONObject param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("Content-Type","application/json");
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输出流、输入流
        finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }
    @Test
    public void test5(){
        HttpURLConnectionDemo hu = new HttpURLConnectionDemo();
        Thread thread = new Thread(hu);
        thread.start();
    }
}
