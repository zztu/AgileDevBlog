package cn.edu.nju.agiledevblog.service;

import cn.edu.nju.agiledevblog.entity.Picture;

import java.util.List;

/**
 * @InterfaceName: PictureService
 * @Description: 相册管理业务层接口
 */
public interface PictureService {

    //查询照片
    List<Picture> listPicture();

    //添加图片
    int savePicture(Picture picture);

    //根据id查询照片
    Picture getPicture(Long id);

    //编辑修改相册
    int updatePicture(Picture picture);

    //删除照片
    void deletePicture(Long id);

}
