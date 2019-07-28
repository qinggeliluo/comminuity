package com.zh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author xmr
 * @date 2019/7/26 17:41
 * @description
 */
@Controller
public class IndexController {
    @GetMapping("/")
    public String index( Model model)
    {
        String name ="ssss";
        model.addAttribute("name",name);
        return "index";
    }
}
