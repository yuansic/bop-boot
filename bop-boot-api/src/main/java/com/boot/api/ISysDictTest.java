package com.boot.api;

import com.boot.response.SysDictResponse;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface ISysDictTest {

    /**
     * 根据类型查询该类型下的字典值
     *
     * @param type 类型
     * @return 为空返回null
     */
    List<SysDictResponse> getSysDictByType(@NotNull String type);

    /**
     * 查询字典所有值
     * @return
     */
    List<SysDictResponse> getSysDictByAll();

}
