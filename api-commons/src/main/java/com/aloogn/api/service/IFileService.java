//package com.aloogn.api.service;
//
//import com.aloogn.api.common.PublicParam;
//
//import java.util.List;
//
///**
// * Created by zouXiaoLong on 2020/12/26 10:51
// */
//public interface IFileService {
//    void open(PublicParam pubcom);
//
//    void open(String fileName);
//
//    void write(String msg);
//
//    void write(List<Object> list);
//
//    void close();
//
//    <T> List<T> readFile(Class<T> clazz, String fileName);
//
//    <T> List<T> readFile(Class<T> clazz, String fileName, String split, String end);
//
//    void checkClose(PublicParam pubcom);
//
//    boolean checkFile(String name);
//
//    <T> List<T> transferObjectIgnoreCase(Class<T> clazz, String fileName, String split, String end);
//
//    <T> List<T> transferObjectIgnoreCase(Class<T> clazz, String fileName);
//}
