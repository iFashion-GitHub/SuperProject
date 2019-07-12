package com.avy.haobai;

import android.util.Log;
import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

public class HTTP {

    public static String sendPOST(final String url1, final String postdate){
        try {
            String msg = "";
            //初始化URL
            URL url = new URL(url1);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            //设置请求方式
            conn.setRequestMethod("POST");

            //设置超时信息
            conn.setReadTimeout(5000);
            conn.setConnectTimeout(5000);

            //设置允许输入
            conn.setDoInput(true);
            //设置允许输出
            conn.setDoOutput(true);

            //post方式不能设置缓存，需手动设置为false
            conn.setUseCaches(false);
            //我们请求的数据
            //獲取輸出流
            OutputStream out = conn.getOutputStream();

            out.write(postdate.getBytes());
            out.flush();
            out.close();
            conn.connect();
            Log.i("code", "run: " + conn.getResponseCode());
            if (conn.getResponseCode() == 200) {
                // 获取响应的输入流对象
                InputStream is = conn.getInputStream();
                // 创建字节输出流对象
                ByteArrayOutputStream message = new ByteArrayOutputStream();
                // 定义读取的长度
                int len = 0;
                // 定义缓冲区
                byte buffer[] = new byte[1024];
                // 按照缓冲区的大小，循环读取
                while ((len = is.read(buffer)) != -1) {
                    // 根据读取的长度写入到os对象中
                    message.write(buffer, 0, len);
                }
                // 释放资源
                is.close();
                message.close();
                // 返回字符串
                msg = new String(message.toByteArray());
                Log.i("msg", "run: " + msg);
                return msg;
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.d("","exit");
        return null;
    }

    /**
     * 使用get方式与服务器通信
     * @param content
     * @return
     */
    public static  List<GameInfo> SendGetRequestXML(String content){

        HttpURLConnection conn=null;
        try {

            URL url = new URL(content);
            conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            conn.setRequestMethod("GET");
            if(HttpURLConnection.HTTP_OK==conn.getResponseCode()){
                Log.i("PostGetUtil","get请求成功");
                InputStream in=conn.getInputStream();
//                String backcontent= IOUtils.readToString(in);
//                backcontent = URLDecoder.decode(backcontent,"UTF-8");
//                Log.i("PostGetUtil",backcontent);
                List<GameInfo> gameInfos = getPersons(in);
                in.close();
                return  gameInfos;
            }
            else {
                Log.i("PostGetUtil","get请求失败");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            conn.disconnect();
        }
        return null;
    }
    /**
     * 使用get方式与服务器通信
     * @param content
     * @return
     */
    public static  String SendGetRequest(String content){

        HttpURLConnection conn=null;
        try {

            URL url = new URL(content);
            conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            conn.setRequestMethod("GET");
            if(HttpURLConnection.HTTP_OK==conn.getResponseCode()){
                Log.i("PostGetUtil","get请求成功");
                InputStream in=conn.getInputStream();
                String backcontent= null;//IOUtils.readToString(in);
                backcontent = URLDecoder.decode(backcontent,"UTF-8");
                Log.i("PostGetUtil",backcontent);
//                List<GameInfo> gameInfos = getPersons(in);
                in.close();
                return  backcontent;
            }
            else {
                Log.i("PostGetUtil","get请求失败");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            conn.disconnect();
        }
        return null;
    }
    //  <GameInfo>
//        <gid>22</gid>
//        <name>ç±³ç®å¤§åé©</name>
//        <e_name></e_name>
//    <developer>Dreadlocks Mobile, Silicon Jelly</developer>
//    <publisher>Dreadlocks Mobile, Silicon Jelly, Dreadlocks Ltd.</publisher>
//        <release_date>2016-05-23T00:00:00 0800</release_date>
//        <issue_date>2019-05-08T00:00:00 0800</issue_date>
//        <cover>http://220.248.55.105:28092/game_cover/22.png</cover>
//        <categories>2Dåé©</categories>
//        <tags>ç¬ç«,å¯ç±,è§£å¯</tags>
//        <state>1</state>
//    </GameInfo>
    public static List<GameInfo> getPersons(InputStream inStream)
            throws Exception {
        GameInfo person = null;
        List<GameInfo> persons = null;
        XmlPullParser pullParser = Xml.newPullParser();
        pullParser.setInput(inStream, "UTF-8");
        int event = pullParser.getEventType();// 觸發第一個事件
        while (event != XmlPullParser.END_DOCUMENT) {
            switch (event) {
                case XmlPullParser.START_DOCUMENT:
                    persons = new ArrayList<>();
                    break;
                case XmlPullParser.START_TAG:
                    if("GameInfo".equals(pullParser.getName())){
                        person = new GameInfo();
                    }
                    if ("gid".equals(pullParser.getName())) {
                        int id = new Integer(pullParser.getAttributeValue(0));
                        person.setGid(id);
                    }
                    if (person != null) {
                        if ("name".equals(pullParser.getName())) {
                            person.setName(pullParser.nextText());
                        }
                        if ("e_name".equals(pullParser.getName())) {
                            person.setE_name(pullParser.nextText());
                        }
                        if ("developer".equals(pullParser.getName())) {
                            person.setDeveloper(pullParser.nextText());
                        }
                        if ("publisher".equals(pullParser.getName())) {
                            person.setPublisher(pullParser.nextText());
                        }
                        if ("release_date".equals(pullParser.getName())) {
                            person.setRelease_date(pullParser.nextText());
                        }
                        if ("issue_date".equals(pullParser.getName())) {
                            person.setIssue_date(pullParser.nextText());
                        }
                        if ("cover".equals(pullParser.getName())) {
                            person.setCover(pullParser.nextText());
                        }
                        if ("categories".equals(pullParser.getName())) {
                            person.setCategories(pullParser.nextText());
                        }
                        if ("tags".equals(pullParser.getName())) {
                            person.setTags(pullParser.nextText());
                        }
                        if ("state".equals(pullParser.getName())) {
                            person.setState(pullParser.nextText());
                        }
                    }
                    break;
                case XmlPullParser.END_TAG:
                    if ("person".equals(pullParser.getName())) {
                        persons.add(person);
                        person = null;
                    }
                    break;
            }
            event = pullParser.next();
        }
        return persons;
    }
}
