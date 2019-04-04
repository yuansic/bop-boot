package com.boot.service.business.impl;


import com.boot.entity.SysDict;
import com.boot.service.atom.interfaces.ISysDictAtomSV;
import com.boot.service.business.interfaces.ISysDictSV;
import com.boot.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author yuansc
 * @date 2019/3/28 0028 上午 10:27
 */
@Service
@Transactional
public class SysDictSVImpl implements ISysDictSV {

    @Autowired
    private ISysDictAtomSV iSysDictAtomSV;


    public List<SysDict> getSysDictByType(String type) {
        if (StringUtils.isBlank(type)) {
            return null;
        }
        return iSysDictAtomSV.selectSysDict(type, null);
    }

    public List<SysDict> getSysDictByAll() {
        return iSysDictAtomSV.selectSysDict(null, null);
    }


}
