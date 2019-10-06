package cn.wayne.travel.service;

import cn.wayne.travel.domain.Category;

import java.util.List;


public interface ICategoryService {
    List<Category> findAll();
}
