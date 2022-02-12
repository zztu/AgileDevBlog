package cn.edu.nju.agiledevblog.service;


import cn.edu.nju.agiledevblog.entity.User;

/**
 * @InterfaceName: UserService
 * @Description: 用户业务层接口
 */
public interface UserService {

    //核对用户名和密码
    User checkUser(String username, String password);

}
