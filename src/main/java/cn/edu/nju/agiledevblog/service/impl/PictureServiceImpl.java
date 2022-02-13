package cn.edu.nju.agiledevblog.service.impl;

import cn.edu.nju.agiledevblog.dao.PictureDao;
import cn.edu.nju.agiledevblog.entity.Picture;
import cn.edu.nju.agiledevblog.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: PictureServiceImpl
 * @Description: 相册管理业务层接口实现类
 */
@Service
public class PictureServiceImpl implements PictureService {

    @Autowired
    private PictureDao pictureDao;

    //查询照片
    @Override
    public List<Picture> listPicture() {
        return pictureDao.listPicture();
    }

    //添加图片
    @Override
    public int savePicture(Picture picture) {
        return pictureDao.savePicture(picture);
    }

    //根据id查询照片
    @Override
    public Picture getPicture(Long id) {
        return pictureDao.getPicture(id);
    }

    //编辑修改相册
    @Override
    public int updatePicture(Picture picture) {
        return pictureDao.updatePicture(picture);
    }

    //删除照片
    @Override
    public void deletePicture(Long id) {
        pictureDao.deletePicture(id);
    }

}
