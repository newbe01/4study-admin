package com.forstudy.adminboard.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/management/articles")
@Controller
public class ArticleManagementController {

    @GetMapping
    public String articles(
            @PageableDefault(size = 10, sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable,
            HttpServletRequest request, //TODO : request 를 제거할 방법 찾아보기
            Model model
    ) {
        model.addAttribute("request", request);
        return "management/articles";
    }

}
