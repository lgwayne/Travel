package cn.wayne.travel.dao;

import cn.wayne.travel.domain.User;


public interface IUserDao {
    /**
     * 根据username查询用户信息
     * @param username
     * @return
     */
    User findByUsername(String username);

    /**
     * 保存用户信息到数据库
     * @param user
     */
    void save(User user);

    /**
     * 根据激活码查找用户
     * @param code
     * @return
     */
    User findByCode(String code);

    /**
     * 改变激活状态用户status
     * @param user
     */
    void updateStatus(User user);

    /**
     * 根据用户名及密码进行登录
     * @param username
     * @param password
     * @return
     */
    User findByUsernameAndPassword(String username, String password);
}
