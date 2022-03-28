package cn.edu.nju.agiledevblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ClassName: MusicShowController
 * @Description: 音乐盒页面显示控制器
 * @Author: PANPAN
 */
@Controller
public class MusicShowController {

    @GetMapping("/music")
    public String about() {
        return "music";
    }

}
