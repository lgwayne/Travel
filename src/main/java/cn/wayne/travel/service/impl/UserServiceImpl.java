package cn.wayne.travel.service.impl;

import cn.wayne.travel.dao.IUserDao;
import cn.wayne.travel.dao.impl.UserDaoImpl;
import cn.wayne.travel.domain.User;
import cn.wayne.travel.service.IUserService;
import cn.wayne.travel.util.MailUtils;
import cn.wayne.travel.util.UuidUtil;


public class UserServiceImpl implements IUserService {
    IUserDao dao = new UserDaoImpl();

    @Override
    public boolean regist(User user) {
        //1.根据用户名查询用户对象
        User u = dao.findByUsername(user.getUsername());
        //判断u是否为null
        if (u != null) {
            //用户名存在，注册失败
            return false;
        }

        //2.保存用户信息
        //2.1设置激活码，唯一字符串
        user.setCode(UuidUtil.getUuid());
        //2.2设置激活状态
        user.setStatus("N");
        dao.save(user);
        //3.激活邮件发送，邮件正文？
        String content = "<a href='http://localhost:8080/travel/user/activeUserServlet?code=" + user.getCode() + "'>点击激活黑马旅游网</a>";

        MailUtils.sendMail(user.getEmail(), content, "激活邮件");

        return true;
    }

    @Override
    public boolean active(String code) {
        //1.根据激活码查询用户对象
        User user = dao.findByCode(code);

        if (user != null) {
            // 激活成功
            dao.updateStatus(user);
            return true;
        } else {
            // 激活失败
            return false;
        }
    }

    @Override
    public User login(User user) {
        return dao.findByUsernameAndPassword(user.getUsername(), user.getPassword());
    }
}
