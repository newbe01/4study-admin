package com.forstudy.adminboard.controller;

import com.forstudy.adminboard.dto.response.ArticleResponse;
import com.forstudy.adminboard.service.ArticleManagementService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/management/articles")
@Controller
public class ArticleManagementController {

    private final ArticleManagementService articleManagementService;

    @GetMapping
    public String articles(
            @PageableDefault(size = 10, sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable,
            HttpServletRequest request, //TODO : request 를 제거할 방법 찾아보기
            Model model
    ) {
        model.addAttribute("request", request);
        model.addAttribute("articles",
                articleManagementService.getArticles().stream().map(ArticleResponse::withoutContent).toList());

        return "management/articles";
    }


    @ResponseBody
    @GetMapping("/{articleId}")
    public ArticleResponse article(@PathVariable Long articleId) {
        return ArticleResponse.withContent(articleManagementService.getArticle(articleId));
    }

    @PostMapping("/{articleId}")
    public String deleteArticle(@PathVariable Long articleId) {
        articleManagementService.deleteArticle(articleId);

        return "redirect:/management/articles";
    }

}
