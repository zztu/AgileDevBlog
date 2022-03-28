package cn.edu.nju.agiledevblog.controller;

import cn.edu.nju.agiledevblog.service.FriendLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ClassName: FriendLinkShowController
 * @Description: 友链显示控制器
 * @Author: PANPAN
 */
@Controller
public class FriendLinkShowController {

    @Autowired
    private FriendLinkService friendLinkService;

    @GetMapping("/friends")
    public String friends(Model model) {
        model.addAttribute("friendlinks",friendLinkService.listFriendLink());
        return "friends";
    }

}
