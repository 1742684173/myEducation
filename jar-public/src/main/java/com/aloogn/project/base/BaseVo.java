package com.aloogn.project.base;

import lombok.Data;

import java.util.List;

/**
 * Created by zouXiaoLong on 2021/1/21 21:38
 */
@Data
public class BaseVo {
    private Integer total;
    private Integer totalPage;
    private Integer currentPage;
    private Integer page;
    private List list;

    public static BaseVo getPageInfo(Integer page,Integer currentPage, Integer totalPage, List list){
        BaseVo pageVo = new BaseVo();
        pageVo.setCurrentPage(currentPage);
        pageVo.setTotalPage(totalPage);
        pageVo.setPage(page);
        pageVo.setTotal(list.size());
        pageVo.setList(list);
        return pageVo;
    }
}
