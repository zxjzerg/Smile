package com.zxjdev.smile.domain.common.base;

import java.util.ArrayList;
import java.util.List;

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
