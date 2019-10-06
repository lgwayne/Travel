package cn.wayne.travel.service;

import cn.wayne.travel.domain.PageBean;
import cn.wayne.travel.domain.Route;


public interface IRouteService {
    PageBean<Route> pageQuery(int cid, int currentPage, int pageSize, String rname);

    Route findOne(String rid);
}