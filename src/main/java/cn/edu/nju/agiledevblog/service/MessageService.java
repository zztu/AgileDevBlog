package cn.edu.nju.agiledevblog.service;

import cn.edu.nju.agiledevblog.entity.Message;

import java.util.List;

/**
 * @InterfaceName: MessageService
 * @Description: 留言业务层接口
 * @Author: PANPAN
 */
public interface MessageService {

    //查询留言列表
    List<Message> listMessage();

    //保存留言
    int saveMessage(Message message);

    //删除留言
    void deleteMessage(Long id);

}
