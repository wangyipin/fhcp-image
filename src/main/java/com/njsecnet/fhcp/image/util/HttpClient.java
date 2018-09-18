package com.njsecnet.fhcp.image.util;

import com.njsecnet.fhcp.image.config.ApplicationProperties;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class HttpClient {


    @Autowired
    private static ApplicationProperties applicationProperties;

    public static String doHead(String httpurl) {
        HttpURLConnection connection = null;
        String result = null;// 返回结果字符串
        try {
            // 通过远程url连接对象打开连接
            connection =  HttpClient.openConnection(httpurl);

            connection.setRequestMethod("HEAD");

            HttpClient.setHttpCommonInfo(connection);
            // 发送请求
            connection.connect();

            result = connection.getResponseCode()+"";

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            connection.disconnect();// 关闭远程连接
        }
        return result;
    }


    public static Map doGet(String httpurl) {
        Map<String,Object> hashMap = null;
        HttpURLConnection connection = null;

        String result = null;// 返回结果字符串
        try {
            // 创建远程url连接对象
            URL url = new URL(httpurl);
            // 通过远程url连接对象打开连接
            connection =  HttpClient.openConnection(httpurl);

            // 设置连接请求方式
            connection.setRequestMethod("GET");

            HttpClient.setHttpCommonInfo(connection);

            // 设置鉴权信息
            HttpClient.setAuthorization(connection);

            // 发送请求
            connection.connect();
            // 通过connection连接，获取输入流
            if (connection.getResponseCode() == 200) {

                result = HttpClient.getHttpResponseData(connection);
            }

            hashMap = new HashMap();
            hashMap.put("responseCode",connection.getResponseCode());
            hashMap.put("responseData",result);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.disconnect();// 关闭远程连接
        }

        return hashMap;
    }



    public static Map doPost(String httpUrl, String param) {
        Map<String,Object> hashMap = null;
        HttpURLConnection connection = null;

        OutputStream os = null;

        String result = null;
        try {
            URL url = new URL(httpUrl);
            // 通过远程url连接对象打开连接
            connection =  HttpClient.openConnection(httpUrl);

            // 设置连接请求方式
            connection.setRequestMethod("POST");

            HttpClient.setHttpCommonInfo(connection);

            // 设置传入参数的格式:请求参数应该是 name1=value1&name2=value2 的形式。
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            // 设置鉴权信息
            HttpClient.setAuthorization(connection);

            // 通过连接对象获取一个输出流
            os = connection.getOutputStream();
            // 通过输出流对象将参数写出去/传输出去,它是通过字节数组写出的
            os.write(param.getBytes());
            // 通过连接对象获取一个输入流，向远程读取
            if (connection.getResponseCode() == 200) {
                result = HttpClient.getHttpResponseData(connection);
            }
            hashMap = new HashMap();
            hashMap.put("responseCode",connection.getResponseCode());
            hashMap.put("responseData",result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.disconnect();
        }
        return hashMap;
    }


    /**
     *
     */
    public static void setHttpCommonInfo(HttpURLConnection connection){

        try {

            // 设置连接主机服务器超时时间：15000毫秒
            connection.setConnectTimeout(15000);
            // 设置读取主机服务器返回数据超时时间：60000毫秒
            connection.setReadTimeout(60000);

            // 默认值为：false，当向远程服务器传送数据/写数据时，需要设置为true
            connection.setDoOutput(true);
            // 默认值为：true，当前向远程服务读取数据时，设置为true，该参数可有可无
            connection.setDoInput(true);

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    /**
     * 设置鉴权信息
     * @param  connection
     */
    public static void setAuthorization(HttpURLConnection connection){

        try {
            //设置用户名和密码
            String user = applicationProperties.getUserName();

            String pwd = applicationProperties.getPassword();

            String auth = user+":"+pwd;
            //对其进行加密
            byte[] rel = Base64.encodeBase64(auth.getBytes());
            String res = new String(rel);
            //设置认证属性
            connection.setRequestProperty("Authorization","Basic " + res);

            //connection.setRequestProperty("Authorization", "Basic  da3efcbf-0845-4fe3-8aba-ee040be542c0");

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    /**
     * 获取http响应数据
     * @param  connection
     */
    public static String getHttpResponseData(HttpURLConnection connection){

        String result = "";
        InputStream is = null;
        BufferedReader br = null;
        OutputStream os = null;
        try {

            is = connection.getInputStream();
            // 对输入流对象进行包装:charset根据工作项目组的要求来设置
            br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

            StringBuffer sbf = new StringBuffer();
            String temp = null;

            while ((temp = br.readLine()) != null) {
                sbf.append(temp);
                sbf.append("\r\n");
            }
            result = sbf.toString();

        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            // 关闭资源
            doCloseStream(is,os,br);
        }


        return result;
    }

    /***
     * 打开http连接
     * @param  httpUrl  url地址
     */
    public static HttpURLConnection  openConnection(String httpUrl){

        HttpURLConnection connection = null;
        try {
            URL url = new URL(httpUrl);
            // 通过远程url连接对象打开连接
            connection = (HttpURLConnection) url.openConnection();
        }catch (Exception e){
            e.printStackTrace();
        }finally {

        }
        return connection;
    }
    
    /**
     *  关闭数据流资源
     * @param  is
     * @param  os
     * @param  br
     */
    public static void doCloseStream(InputStream is,OutputStream os,BufferedReader br){
    	if (null != br) {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (null != os) {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (null != is) {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    
}