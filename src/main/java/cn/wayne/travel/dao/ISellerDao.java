package cn.wayne.travel.dao;

import cn.wayne.travel.domain.Seller;


public interface ISellerDao {
    Seller findBySid(int sid);
}
