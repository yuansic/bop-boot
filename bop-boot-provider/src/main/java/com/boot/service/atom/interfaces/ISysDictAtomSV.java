package com.boot.service.atom.interfaces;


import com.boot.entity.SysDict;

import java.util.List;

public interface ISysDictAtomSV {

    List<SysDict> selectSysDict(String type, String value);

}
