package cn.edu.nju.agiledevblog.controller;

import cn.edu.nju.agiledevblog.queryvo.BlogQuery;
import cn.edu.nju.agiledevblog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @ClassName: ArchiveShowController
 * @Description: 时间轴页面显示控制器
 * @Author: PANPAN
 */
@Controller
public class ArchiveShowController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/archives")
    public String archive(Model model){
        List<BlogQuery> blogs = blogService.getAllBlog();
        model.addAttribute("blogs", blogs);
        return "archives";
    }

}
