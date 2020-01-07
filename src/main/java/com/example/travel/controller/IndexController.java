package com.example.travel.controller;

import com.example.travel.dto.QuestionDTO;
import com.example.travel.mapper.QuestionMapper;
import com.example.travel.mapper.UserMapper;
import com.example.travel.model.Question;
import com.example.travel.model.User;
import com.example.travel.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    UserMapper userMapper;

    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String index(HttpServletRequest request,
                        HttpServletResponse response,
                        Model model) {
        Cookie[] cookies = request.getCookies();
        if(cookies == null)
            return "index";
        for (Cookie cookie : cookies) {
            if(cookie.getName().equals("token"))
            {
                String token = cookie.getValue();
                User user = userMapper.findByToken(token);
                if(user!=null)
                {
                    request.getSession().setAttribute("user",user);
                }
                break;
            }
        }

        List<QuestionDTO> questionDTOList = questionService.list();
        model.addAttribute("questions",questionDTOList);
        return "index";
    }

}
