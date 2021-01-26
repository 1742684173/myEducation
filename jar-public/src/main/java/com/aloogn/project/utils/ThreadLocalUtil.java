package com.aloogn.project.utils;

import java.util.HashMap;
import java.util.Map;

public class ThreadLocalUtil {
    private static ThreadLocal<Map<String, Object>> threadLocal = new ThreadLocal<>();

    public static void set(String key, Object value){
        if(threadLocal.get() == null){
            threadLocal.set(new HashMap<>());
        }
        threadLocal.get().put(key,value);
    }

    public static Object get(String key){
        if(threadLocal.get() == null){
            return null;
        }
        return threadLocal.get().get(key);
    }

    public static void remove(String key){
        if(threadLocal.get() != null){
            threadLocal.get().remove(key);
            if(threadLocal.get().isEmpty()){
                threadLocal.remove();
            }
        }
    }

    public static void removeAll() {
        threadLocal.remove();
    }
}
