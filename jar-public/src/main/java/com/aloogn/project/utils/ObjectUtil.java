package com.aloogn.project.utils;

import com.alibaba.fastjson.JSON;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zouXiaoLong on 2021/1/19 23:52
 */
public class ObjectUtil {
    public static String list2Str(List record) throws IllegalAccessException {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for(Object o:record) {
            builder.append(object2Map(o).toString());
            builder.append(",");
        }
        builder.append("]");
        return builder.toString();
    }

    //Object转Map
    public static Map<String, Object> object2Map(Object obj) throws IllegalAccessException {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        Class<?> clazz = obj.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            String fieldName = field.getName();
            Object value = field.get(obj);
            if (value == null){
                value = "";
            }
            map.put(fieldName, value);
        }
        return map;
    }

    //Map转Object
    public static Object map2Object(Map<Object, Object> map, Class<?> beanClass) throws Exception {
        if (map == null) return null;

        Object obj = beanClass.newInstance();
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            int mod = field.getModifiers();
            if (Modifier.isStatic(mod) || Modifier.isFinal(mod)) {
                continue;
            }
            field.setAccessible(true);
            if (map.containsKey(field.getName())) {
                field.set(obj, map.get(field.getName()));
            }
        }
        return obj;
    }

}
