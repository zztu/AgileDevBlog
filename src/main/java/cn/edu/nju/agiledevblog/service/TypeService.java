package cn.edu.nju.agiledevblog.service;

import cn.edu.nju.agiledevblog.entity.Type;

import java.util.List;

/**
 * @InterfaceName: TypeService
 * @Description: 分类业务层接口
 */
public interface TypeService {

    //保存新增分类
    int saveType(Type type);

    //根据id查询分类
    Type getType(Long id);

    //查询所有分类
    List<Type> getAllType();

    //根据分类名查询分类
    Type getTypeByName(String name);

    //编辑修改分类
    int updateType(Type type);

    //删除分类
    void deleteType(Long id);

    //查询所有分类
    List<Type>getAllTypeAndBlog();

}
