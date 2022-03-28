package cn.edu.nju.agiledevblog.service;

import cn.edu.nju.agiledevblog.entity.Comment;

import java.util.List;

/**
 * @InterfaceName: CommentService
 * @Description: 评论业务层接口
 * @Author: PANPAN
 */
public interface CommentService {

    //根据博客id查询评论信息
    List<Comment> listCommentByBlogId(Long blogId);

    //添加保存评论
    int saveComment(Comment comment);

    //删除评论
    void deleteComment(Comment comment,Long id);

}
