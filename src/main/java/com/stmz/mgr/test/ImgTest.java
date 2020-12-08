package com.stmz.mgr.test;

import org.apache.commons.io.FileUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

/**
 * @author LTJ
 * @version 1.0
 * @date 2020/12/7 17:38
 */
public class ImgTest {

    @Test
    public void test() throws IOException {
        InputStream in = this.getClass().getResourceAsStream("/static/img/logo.png");
        byte[] buffer = new byte[in.available()];
        in.read(buffer);
        in.close();


    }

    @Test
    public void test2(){
        // 1. 持有一个类似浏览器的客户端
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        // 2。创建Get请求，类似于浏览器输入地址
        HttpGet httpGet = new HttpGet("http://10.7.5.88:8080/gs-robot/data/map_png?map_name=1207");

        // 3. 创建响应容器
        CloseableHttpResponse response = null;

        try(httpClient) {
            // 4.发起请求，类似于浏览器回车
            response = httpClient.execute(httpGet);

            // 获取响应实体
            HttpEntity entity = response.getEntity();

            System.out.println("响应状态为:" + response.getStatusLine());

            if(entity!=null){
                System.out.println("响应内容长度为:" + entity.getContentLength());
                InputStream content = entity.getContent();

                File file1 = new File(this.getClass().getResource("").getPath()+File.separator+"img01.png");
                FileUtils.copyInputStreamToFile(content,file1);
//                String utf8String = EntityUtils.toString(entity, "utf-8");
//                System.out.println("响应内容为:" +utf8String);
//                byte[] bytes = utf8String.getBytes(("utf-8"));
//                File file2 = new File(this.getClass().getResource("").getPath()+File.separator+"img02.png");
//                FileUtils.writeByteArrayToFile(file2,bytes);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
