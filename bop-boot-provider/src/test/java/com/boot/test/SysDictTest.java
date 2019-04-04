package com.boot.test;

import com.alibaba.fastjson.JSON;
import com.boot.BopBootApplication;
import com.boot.api.ISysDictTest;
import com.boot.response.SysDictResponse;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author yuansc
 * @date 2019/4/2 0002 下午 5:59
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BopBootApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
public class SysDictTest {
    @Autowired
    private ISysDictTest iSysDictTest;


    @Test
    public void sysDictTest() {

        List<SysDictResponse> sysDictByAll = iSysDictTest.getSysDictByAll();

        System.out.println("JSON---------->>>>" + JSON.toJSON(sysDictByAll));

    }



}
