package cn.edu.nju.agiledevblog.dao;


import cn.edu.nju.agiledevblog.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @InterfaceName: UserDao
 * @Description: 用户持久层接口
 */
@Mapper
@Repository
public interface UserDao {

    User findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

}
