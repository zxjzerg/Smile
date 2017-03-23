package com.zxjdev.smile.domain.base;

import java.util.ArrayList;
import java.util.List;

/**
 * 各种Mapper类的基类
 *
 * @param <T> 目标数据类型
 * @param <O> 源数据类型
 */
public abstract class BaseMapper<T, O> {

  public abstract T transform(O data);

  public List<T> transform(List<O> dataList) {
    List<T> output = new ArrayList<>();
    if (dataList != null) {
      for (O data : dataList) {
        output.add(transform(data));
      }
    }
    return output;
  }
}
