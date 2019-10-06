package cn.wayne.travel.service;

import cn.wayne.travel.domain.User;


public interface IUserService {
    boolean regist(User user);
    boolean active(String code);
    User login(User user);
}
