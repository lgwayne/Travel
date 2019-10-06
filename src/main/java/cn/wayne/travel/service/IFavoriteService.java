package cn.wayne.travel.service;


public interface IFavoriteService {
    boolean isFavorite(String rid, int uid);

    void add(String rid, int uid);
}
