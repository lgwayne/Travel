package cn.wayne.travel.service.impl;

import cn.wayne.travel.dao.IFavoriteDao;
import cn.wayne.travel.dao.IRouteDao;
import cn.wayne.travel.dao.IRouteImgDao;
import cn.wayne.travel.dao.ISellerDao;
import cn.wayne.travel.dao.impl.FavoriteDaoImpl;
import cn.wayne.travel.dao.impl.RouteDaoImpl;
import cn.wayne.travel.dao.impl.RouteImgDaoImpl;
import cn.wayne.travel.dao.impl.SellerDaoImpl;
import cn.wayne.travel.domain.PageBean;
import cn.wayne.travel.domain.Route;
import cn.wayne.travel.domain.RouteImg;
import cn.wayne.travel.domain.Seller;
import cn.wayne.travel.service.IRouteService;

import java.util.List;


public class RouteServiceImpl implements IRouteService {
    private IRouteDao routeDao = new RouteDaoImpl();
    private IRouteImgDao routeImgDao = new RouteImgDaoImpl();
    private ISellerDao sellerDao = new SellerDaoImpl();
    private IFavoriteDao favoriteDao = new FavoriteDaoImpl();

    @Override
    public PageBean<Route> pageQuery(int cid, int currentPage, int pageSize, String rname) {
        PageBean<Route> pageBean = new PageBean<Route>();

        pageBean.setCurrentPage(currentPage);
        pageBean.setPageSize(pageSize);

        int totalCount = routeDao.findTotalCount(cid, rname);
        pageBean.setTotalCount(totalCount);

        int start = (currentPage - 1) * pageSize;
        List<Route> list = routeDao.findByPage(cid, start, pageSize, rname);
        pageBean.setList(list);

        int totalPage = totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
        pageBean.setTotalPage(totalPage);

        return pageBean;
    }

    @Override
    public Route findOne(String rid) {
        Route route = routeDao.findOne(Integer.parseInt(rid));

        List<RouteImg> routeImgList = routeImgDao.findByRid(route.getRid());
        route.setRouteImgList(routeImgList);

        Seller seller = sellerDao.findBySid(route.getSid());
        route.setSeller(seller);

        int count = favoriteDao.findCountByRid(route.getRid());
        route.setCount(count);

        return route;
    }


}
