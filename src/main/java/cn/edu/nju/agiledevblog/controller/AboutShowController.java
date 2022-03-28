package cn.edu.nju.agiledevblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ClassName: AboutShowController
 * @Description: 关于我界面显示控制器
 * @Author: PANPAN
 */
@Controller
public class AboutShowController {

    @GetMapping("/about")
    public String about() {
        return "about";
    }

}
