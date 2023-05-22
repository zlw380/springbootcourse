package com.example.controller;

import com.example.model.SysUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/tpl")
public class ThymeleafController {

    //第一个标准变量表达式
    @GetMapping("/expression1")
    public String expression1(Model model) {
        //添加数据到Model
        model.addAttribute("site", "www.fairingstudio.top");
        model.addAttribute("myuser",
                new SysUser(1001, "lisi", "male", 20));
        //指定视图
        return "expression1";
    }

    //选择变量表达式
    @GetMapping("/expression2")
    public String expression2(Model model) {
        //添加数据到Model
        model.addAttribute("site", "www.fairingstudio2.top");
        model.addAttribute("myuser",
                new SysUser(1002, "zhangsan", "male", 22));
        //指定视图
        return "expression2";
    }

    //链接表达式
    @GetMapping("/link")
    public String link(Model model) {
        //添加数据到Model
        model.addAttribute("userId", "7878");
        model.addAttribute("userAge", "7777");
        //指定视图
        return "link";
    }

    //测试链接表达式没有参数的地址，或传统方式传一个参数
    @GetMapping("/queryAccount")
    @ResponseBody
    public String queryAccountNon(Integer id, Integer age) {
        return "queryAccount,无参数，或者传统get方式传参，参数是id=" + id + " age=" + age;
    }

    //测试链接表达式有一个参数的地址,Restful
    @GetMapping("/queryAccount/{id}")
    @ResponseBody
    public String queryAccount(@PathVariable("id") Integer id) {
        return "queryAccount,参数id" + id;
    }

    //有两个参数的地址,Restful
    @GetMapping("/queryAccount/{id}/{age}")
    @ResponseBody
    public String queryUser(@PathVariable("id") Integer id, @PathVariable("age") Integer age) {
        return "queryUser,有两个参数id和age：" + id + " " + age;
    }

    //使用模板的属性
    @GetMapping("/property")
    public String useProperty(Model model) {
        model.addAttribute("methodAttr", "post");
        model.addAttribute("id", "2342");
        model.addAttribute("paramname", "name");
        model.addAttribute("username", "marisa");
        model.addAttribute("textcolor", "color:blue");
        return "html-property";
    }

    @PostMapping("/loginServlet")
    @ResponseBody
    public String loginServlet(String name) {
        return "提交了/loginServlet请求,传入的参数name为" + name;
    }

    @GetMapping("/eachList")
    public String eachList(Model model) {
        List<SysUser> sysList = new ArrayList<>();
        sysList.add(new SysUser(1001, "marisa", "female", 22));
        sysList.add(new SysUser(1002, "alice", "female", 18));
        sysList.add(new SysUser(1003, "灵梦", "female", 23));
        sysList.add(new SysUser(1004, "铃仙", "female", 21));
        sysList.add(new SysUser(1005, "咲夜", "female", 21));
        model.addAttribute("myusers", sysList);
        return "eachList";
    }

    @GetMapping("/eachArray")
    public String eachArray(Model model) {
        SysUser[] userArray = new SysUser[5];
        userArray[0] = new SysUser(1001, "marisa", "female", 22);
        userArray[1] = new SysUser(1002, "恋恋", "female", 22);
        userArray[2] = new SysUser(1003, "天子", "female", 22);
        userArray[3] = new SysUser(1004, "早苗", "female", 22);
        userArray[4] = new SysUser(1005, "橙", "female", 22);
        model.addAttribute("myUserArray", userArray);
        return "eachArray";
    }

    @GetMapping("/eachMap")
    public String eachMap(Model model) {
        Map<String, SysUser> userMap = new HashMap<>();
        userMap.put("user1", new SysUser(1001, "琪露诺", "female", 22));
        userMap.put("user2", new SysUser(1002, "大妖精", "female", 22));
        userMap.put("user3", new SysUser(1003, "蕾蒂", "female", 22));
        userMap.put("user4", new SysUser(1004, "河童", "female", 22));
        userMap.put("user5", new SysUser(1005, "天狗", "female", 22));
        model.addAttribute("myUserMap", userMap);

        List<Map<String, SysUser>> listMap = new ArrayList<>();

        Map<String, SysUser> map = new HashMap<>();
        map.put("user101", new SysUser(1010, "姆Q", "female", 20));
        map.put("user102", new SysUser(1011, "文文", "female", 20));
        listMap.add(map);

        map = new HashMap<>();
        map.put("user103", new SysUser(1012, "转转", "female", 20));
        map.put("user104", new SysUser(1013, "诹访子", "female", 20));
        listMap.add(map);

        model.addAttribute("listMap", listMap);
        return "eachMap";
    }

    //内联
    @GetMapping("/inline")
    public String inline(Model model) {
        model.addAttribute("sex", "m");
        model.addAttribute("age", 20);
        model.addAttribute("name", "marisa");
        model.addAttribute("myuser", new SysUser(1005, "ALICE", "FEMALE", 20));
        return "inline";
    }

    //运算符的使用
    @GetMapping("/sym")
    public String sym(Model model) {
        model.addAttribute("sex", "m");
        model.addAttribute("age", 20);
        model.addAttribute("name", "marisa");
        model.addAttribute("city", "沈阳");
        model.addAttribute("isLogin", true);
        model.addAttribute("myuser", null);
        return "sym";
    }

    //模板内置对象
    @GetMapping("/baseObject")
    public String baseObject(Model model, HttpServletRequest request,
                             HttpSession session) {
        model.addAttribute("myname", "李四");
        request.setAttribute("requestData", "request作用域中的数据");
        request.getSession().setAttribute("sessionData", "session作用域中的数据");
        //直接使用session
        session.setAttribute("loginname", "张三");

        return "baseObject";
    }
}
