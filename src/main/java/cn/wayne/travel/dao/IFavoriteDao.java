package cn.wayne.travel.dao;

import cn.wayne.travel.domain.Favorite;


public interface IFavoriteDao {
    Favorite findByRidAndUid(int rid, int uid);

    int findCountByRid(int rid);

    void add(int rid, int uid);
}
