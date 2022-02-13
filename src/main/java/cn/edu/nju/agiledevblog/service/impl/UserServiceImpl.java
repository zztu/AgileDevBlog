package cn.edu.nju.agiledevblog.service.impl;

import cn.edu.nju.agiledevblog.dao.UserDao;
import cn.edu.nju.agiledevblog.entity.User;
import cn.edu.nju.agiledevblog.service.UserService;
import cn.edu.nju.agiledevblog.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName: UserServiceImpl
 * @Description: 用户业务层接口实现类
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User checkUser(String username, String password) {
        return userDao.findByUsernameAndPassword(username, MD5Utils.code(password));
    }

}
