package com.zxjdev.smile.domain.base;

import java.util.ArrayList;
import java.util.List;

/**
 * 各种Mapper类的基类
 *
 * @param <T> 目标类型
 * @param <V> 数据类型
 */
public abstract class BaseMapper<T, V> {

    public abstract T transform(V data);

    public List<T> transform(List<V> dataList) {
        List<T> output = new ArrayList<>();
        if (dataList != null) {
            for (V data : dataList) {
                output.add(transform(data));
            }
        }
        return output;
    }
}
