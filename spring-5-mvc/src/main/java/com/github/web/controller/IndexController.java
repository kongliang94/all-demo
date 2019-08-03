package com.github.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @description: index
 * @author: KL
 * @create: 2019-08-02
 */
@Controller
public class IndexController {

    @RequestMapping(method = RequestMethod.GET, value = "/index.html")
    public String index() {
        return "index";
    }

}
