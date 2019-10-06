package cn.wayne.travel.dao;

import cn.wayne.travel.domain.RouteImg;

import java.util.List;


public interface IRouteImgDao {
    List<RouteImg> findByRid(int rid);
}
