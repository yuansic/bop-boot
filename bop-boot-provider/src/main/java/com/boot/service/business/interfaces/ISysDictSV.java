package com.boot.service.business.interfaces;


import com.boot.entity.SysDict;

import java.util.List;

public interface ISysDictSV {

    List<SysDict> getSysDictByType(String type);

    List<SysDict> getSysDictByAll();

}
