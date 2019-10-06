package cn.wayne.travel.service.impl;

import cn.wayne.travel.dao.IFavoriteDao;
import cn.wayne.travel.dao.impl.FavoriteDaoImpl;
import cn.wayne.travel.domain.Favorite;
import cn.wayne.travel.service.IFavoriteService;

/**
 * @Author: 杨朝阳
 * @Version: V1.0
 * @Date: 2019/3/12 9:42
 * @Description: TODO
 **/
public class FavoriteServiceImpl implements IFavoriteService {
    private IFavoriteDao favoriteDao = new FavoriteDaoImpl();

    @Override
    public boolean isFavorite(String rid, int uid) {
        Favorite favorite = favoriteDao.findByRidAndUid(Integer.parseInt(rid), uid);

        return favorite != null;
    }

    @Override
    public void add(String rid, int uid) {
        favoriteDao.add(Integer.parseInt(rid), uid);
    }
}
