package com.boot.service.atom.impl;


import com.boot.dao.SysDictMapper;
import com.boot.entity.SysDict;
import com.boot.entity.SysDictExample;
import com.boot.service.atom.interfaces.ISysDictAtomSV;
import com.boot.util.DelFlagEnum;
import com.boot.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;

/**
 * @author yuansc
 * @date 2019/3/28 0028 上午 10:26
 */
@Component
public class SysDictAtomSVImpl implements ISysDictAtomSV {

    @Autowired
    private SysDictMapper sysDictMapper;

    public List<SysDict> selectSysDict(String type, String value){
        SysDictExample example = new SysDictExample();
        SysDictExample.Criteria criteria = example.createCriteria();

        if(StringUtils.isNotBlank(type)){
            criteria.andTypeEqualTo(type);
        }
        if(StringUtils.isNotBlank(value)){
            criteria.andValueEqualTo(value);
        }
        criteria.andDelFlagEqualTo(String.valueOf(DelFlagEnum.NORMAL.getValue()));
        return sysDictMapper.selectByExample(example);
    }


}
