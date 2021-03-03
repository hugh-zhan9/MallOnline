package com.hugh.mallonline.thirdparty;

import com.aliyun.oss.OSSClient;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

@SpringBootTest
class MallonlineThirdPartyApplicationTests {

    @Resource
    OSSClient ossClient;

    @Test
    public void contextLoads() throws FileNotFoundException {
        InputStream inputStream = new FileInputStream("C:\\Users\\hugh_\\Desktop\\1.png");
        ossClient.putObject("mallonline","haha.png",inputStream);
        ossClient.shutdown();
        System.out.println("上传完成");
    }

}
