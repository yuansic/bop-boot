package com.boot.controller;

import com.alibaba.fastjson.JSON;
import com.boot.api.ISysDictTest;
import com.boot.response.SysDictResponse;
import com.boot.vo.SysDictByRespone;
import com.boot.util.Result;
import com.boot.util.ResultCode;
import com.boot.util.StringUtils;
import com.boot.vo.SysDictList;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yuansc
 * @date 2019/4/2 0002 下午 6:36
 */
@RestController
@RequestMapping("sysDict")
@Api(value = "字典管理")
@Slf4j
public class SysDictController {

    @Autowired
    private ISysDictTest iSysDict;


    @PostMapping(value = "selectSysDict")
    @ApiOperation(value = "查询字典列表",notes = "查询字典")
    public Result<List<SysDictList>> selectSysDict(@Validated @ModelAttribute SysDictByRespone respone){
        log.info("SysDictController.selectSysDict：" + JSON.toJSONString(respone));
        return this.getSysDictByType(respone.getKey());
    }

    @GetMapping("getSysDictByType")
    @ApiOperation(value = "根据类型查询该类型下的字典值", notes = "根据类型查询该类型下的字典值")
    public Result<List<SysDictList>> getSysDictByType(@RequestParam(required = true) @ApiParam(value = "类型") String key) {
        log.info("SysDictController.getSysDictByType：" + JSON.toJSONString(key));

        if (StringUtils.isBlank(key)) {
            return new Result<>(ResultCode.PARAM.getCode(), "key为空。", null);
        }
        List<SysDictResponse> sysDictByType = iSysDict.getSysDictByType(key);
        List<SysDictList> list = new ArrayList<>();
        if (sysDictByType != null && !sysDictByType.isEmpty()) {
            for (SysDictResponse sysDictResponse : sysDictByType) {
                SysDictList bean = new SysDictList();
                BeanUtils.copyProperties(sysDictResponse ,bean);
                list.add(bean);
            }
        }
        return new Result<>(ResultCode.SUCCESS, list);
    }


    @GetMapping("getSysDictByAll")
    @ApiOperation(value = "查询字典所有值", notes = "查询字典所有值")
    public Result<Map<String,List<SysDictList>>> getSysDictByAll() {
        log.info("SysDictController.getSysDictByAll");
        List<SysDictResponse> sysDictByAll = iSysDict.getSysDictByAll();
        Map<String,List<SysDictList>> map = new HashMap<>();
        if (sysDictByAll != null && !sysDictByAll.isEmpty()) {
            for (SysDictResponse sysDictResponse : sysDictByAll) {
                List<SysDictList> list = map.get(sysDictResponse.getType());
                if(list == null || list.isEmpty()){
                    list = new ArrayList<>();
                }
                SysDictList bean = new SysDictList();
                BeanUtils.copyProperties(sysDictResponse,bean);
                list.add(bean);
                map.put(sysDictResponse.getType(),list);
            }
        }
        return new Result<>(ResultCode.SUCCESS, map);
    }

}
