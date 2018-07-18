package com.wen;

import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by szty on 2018/7/18.
 */
public class ApiBeanUtils {
    public static <S,T> T copyProperties(S source ,Class<T> targetClass){
        try {
            T target =targetClass.newInstance();
            BeanUtils.copyProperties(source,target);
            return target;
        }catch (Exception ex){
            return null;
        }
    }

    public static <T,R> List<R> toList(List<T> data, Function<T, R> mapFunc) {
        return data.stream().map(mapFunc).collect(Collectors.toList());
    }
}
