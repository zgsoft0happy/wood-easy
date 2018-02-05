package cn.ideacs.application.woodeasy.controller;

import cn.ideacs.application.woodeasy.entity.Test1;
import cn.ideacs.application.woodeasy.service.Test1Service;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author yang
 * @date 17-12-19
 */
@Controller
@RequestMapping(value = "/home")
public class HomeController {

    @Autowired
    private Test1Service test1Service;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home() {
        return "home/home";
    }

    @RequestMapping(value = "/param", method = RequestMethod.POST)
    public @ResponseBody JSONObject param(@RequestBody JSONObject param) {
        param.put("inner", "这是在函数内插入的信息！");
        return param;
    }

    @RequestMapping(value = "/service", method = RequestMethod.GET)
    public @ResponseBody List<Test1> list() {
        List<Test1> list = test1Service.list();
        return list;
    }

}
