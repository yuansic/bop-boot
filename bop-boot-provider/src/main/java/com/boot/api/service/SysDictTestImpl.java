package com.boot.api.service;


import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.boot.entity.SysDict;
import com.boot.api.ISysDictTest;
import com.boot.response.SysDictResponse;
import com.boot.service.business.interfaces.ISysDictSV;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuansc
 * @date 2019/3/28 0028 上午 10:35
 */
@Slf4j
@Component
@Service(interfaceClass = ISysDictTest.class, retries = -1, version = "0.0.1")
public class SysDictTestImpl implements ISysDictTest {

    @Autowired
    private ISysDictSV iSysDictSV;

    @Override
    public List<SysDictResponse> getSysDictByType(String type) {
        log.info("SysDictImpl.getSysDictByType:" + JSON.toJSONString(type));
        List<SysDict> sysDictByType = iSysDictSV.getSysDictByType(type);

        if (sysDictByType == null || sysDictByType.isEmpty()) {
            return null;
        }
        List<SysDictResponse> list = new ArrayList<>();
        for (SysDict sysDict : sysDictByType) {
            SysDictResponse sysDictResponse = new SysDictResponse();
            BeanUtils.copyProperties(sysDictResponse, sysDict);
            list.add(sysDictResponse);
        }
        return list;
    }

    @Override
    public List<SysDictResponse> getSysDictByAll() {
        log.info("SysDictImpl.getSysDictByAll");

        List<SysDict> sysDictByAll = iSysDictSV.getSysDictByAll();
        if (sysDictByAll == null || sysDictByAll.isEmpty()) {
            return null;
        }
        List<SysDictResponse> list = new ArrayList<>();
        for (SysDict sysDict : sysDictByAll) {
            SysDictResponse sysDictResponse = new SysDictResponse();
            BeanUtils.copyProperties(sysDict,sysDictResponse);
            list.add(sysDictResponse);
        }
        return list;
    }

}
