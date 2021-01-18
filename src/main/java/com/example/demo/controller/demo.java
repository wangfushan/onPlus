package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import netscape.javascript.JSObject;
import okhttp3.*;
import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.Cipher;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyFactory;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class demo {
    public static void main(String[] args) throws Exception {
        String privateKey = "MIICeAIBADANBgkqhkiG9w0BAQEFAASCAmIwggJeAgEAAoGBAKCNEZinTgJOQA1ZXrbmQ0T38md75zIwn6KkrTV4/UVGRfXFln5CzsvT4VEq8BzuC75nhgiCYz/jrqNKToIwB2sgpUreBtknrSo5Mlf56NjNkrShJK9WTDWbiv4JzlV5pBxh4ygaNGiJSTCkhR2B7jj8dgMNOrGqqASZkQH5kmMrAgMBAAECgYEAmRYqAx70OSqX1KK0tz1UQz0Q/C+ewbKvZIwVRHl7NkTNjI288+OL/7qmi5ifn1Y0CHf5y79YF6Fn8fd2aJiXWMBj+ozmqhVdfCjLyHBApZKhE+7yd0m4J3PIsStAe8QHcmD3DT74c7LPSJiEpTHkf+i+NjWm9BlQiSuFlwJOsrECQQDeQsL4nTu6Vv6bEESaGlMfKuVy23RGOSvc7pqfA/fzjCfKDauaDAGhWinfYGIWCSZdZkKyvs05sef0s29ahJTvAkEAuOw3MDyx97T+Vx82Dm88FW8IkykURl+sajHSfn0XDRCxypXr+HQIHMbKocreenrrx6rF6tIckHhiMEef8a0thQJBAM1sLv/Rcw66sP9ofb9gbUr1PrR1mHX/CUddUJN/+3+iHnRlRiFOz4Lt7p2CW6W6NzdD+Il0SAH3KEfGQDkNKQkCQGxrUhAeBdnNbDF4QyFDZl7KsqRVOWXpQhUhEODIRnOKjjLQo4EPxpHYm4UwhDAbUZHHNjLu7YBmlGrqE4SGnGECQQCixlZZIiQwJEuW4A6IhMedkx9SP2le7R2TxvaZ3HkVfT60BNp6iO127V/Ger/wnq6bVzNdgPvNxI8rjvqiXMvY";
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("appKey", "99167d615ead4fabaef2d4ee3738639f");
        jsonObject.put("appSecret", "5cf388e5740d4b22b634c1458ed7aa53");
        String bodyJson = jsonObject.toJSONString();
        //String tokenResult = httpClientUtils.sendPostByJson("http://open.libyuat.com/ability-open/appSecurity/getToken", bodyJson);
        //String token = JSON.parseObject(tokenResult).getJSONObject("data").getString("token");
        //token = decrypt(token, privateKey);
        String token = "afb63e9e974243a0b73818c8f45ffac9";
        System.out.println("解密后的token：" + token);
        Map<String, String> headMap = new HashMap<>();
        headMap.put("third-luban-token", token);
        headMap.put("third-luban-appkey", "99167d615ead4fabaef2d4ee3738639f");
        headMap.put("channel", "LabourContract");
        JSONObject jsonObject2 = new JSONObject();
        jsonObject2.put("code", "LWGS_YGM");
        jsonObject2.put("start_time", "2020-01-09 09:49:19");
        jsonObject2.put("end_time", "2020-12-11 09:49:19");
        jsonObject2.put("serialNumber", 1);
        String params = jsonObject2.toJSONString();
        try {
            String json = bodyPost("https://sales-dodo-test.liby.com.cn/sales-api/guideApi/getLaborContactEmployees", headMap, params);
            JSONObject jsonObject3 = new JSONObject();
            jsonObject3 = JSON.parseObject(json);
            //List<PersonInfo> list = JSON.parseArray(jsonObject3.getString("data"), PersonInfo.class);
        } catch (Exception e) {
            e.printStackTrace();
        }


        //OkHttp();

    }


    public static String OkHttp()
            throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\"code\":\"LWGS_YGM\" ,\r\n\"start_time\":\"2020-01-09 09:49:19\",\r\n\"end_time\":\"2020-12-11 09:49:19\", \r\n\"serialNumber\":1}");
        Request request = new Request.Builder()
                .url("https://sales-dodo-test.liby.com.cn/sales-api/guideApi/getLaborContactEmployees")
                .method("POST", body)
                .addHeader("third-luban-token", "fb857e99745a4d87a9a61fc4f5f1ee2d")
                .addHeader("third-luban-appkey", "99167d615ead4fabaef2d4ee3738639f")
                .addHeader("channel", "LabourContract")
                .addHeader("Content-Type", "application/json")
                .addHeader("Cookie", "br-resp-key=g:20121117225ef47453000096006c8e73d0")
                .build();
        Response response = client.newCall(request).execute();
        String result = response.body().string();
        return null;
    }

    public static String bodyPost(String actionUrl, Map<String, String> headMap, String params)
            throws IOException {
        String serverURL = actionUrl;
        StringBuffer sbf = new StringBuffer();
        String strRead = null;
        URL url = new URL(serverURL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");//请求post方式
        connection.setDoInput(true);
        connection.setDoOutput(true);
        //header内的的参数在这里set
        connection.setRequestProperty("Content-Type", "application/json");
        if (headMap != null && !headMap.isEmpty()) {
            for (String key : headMap.keySet()) {
                connection.setRequestProperty(key, headMap.get(key));
            }
        }
        connection.connect();
        OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
        //body参数放这里
        writer.write(params);
        writer.flush();
        InputStream is = connection.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
        while ((strRead = reader.readLine()) != null) {
            sbf.append(strRead);
            sbf.append("\r\n");
        }
        reader.close();
        connection.disconnect();
        String results = sbf.toString();
        return results;
    }

    public static String decrypt(String str, String privateKey) throws Exception {
        // 64位解码加密后的字符串
        byte[] inputByte = Base64.decodeBase64(str.getBytes("UTF-8"));
        // base64编码的私钥
        byte[] decoded = Base64.decodeBase64(privateKey);
        RSAPrivateKey priKey = (RSAPrivateKey) KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(decoded));
        // RSA解密
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, priKey);
        String outStr = new String(cipher.doFinal(inputByte));
        System.out.println(outStr);
        return outStr;
    }
}
