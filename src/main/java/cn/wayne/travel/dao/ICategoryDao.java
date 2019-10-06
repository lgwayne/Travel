package cn.wayne.travel.dao;

import cn.wayne.travel.domain.Category;

import java.util.List;


public interface ICategoryDao {
    List<Category> findAll();
}
