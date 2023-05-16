package com.forstudy.adminboard.controller;

import com.forstudy.adminboard.dto.response.ArticleCommentResponse;
import com.forstudy.adminboard.service.ArticleCommentManagementService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/management/article-comments")
@Controller
public class ArticleCommentManagementController {

    private final ArticleCommentManagementService articleCommentManagementService;

    @GetMapping
    public String articleComment(
            HttpServletRequest request,
            Model model
    ) {
        model.addAttribute("request", request);
        model.addAttribute(
                "comments",
                articleCommentManagementService.getArticleComments().stream().map(ArticleCommentResponse::of).toList()
        );

        return "management/article-comments";
    }

    @ResponseBody
    @GetMapping("/{articleCommentId}")
    public ArticleCommentResponse articleComment(@PathVariable Long articleCommentId) {
        return ArticleCommentResponse.of(articleCommentManagementService.getArticleComment(articleCommentId));
    }

    @PostMapping("/{articleCommentId}")
    public String deleteArticleComment(@PathVariable Long articleCommentId) {
        articleCommentManagementService.deleteArticleComment(articleCommentId);

        return "redirect:/management/article-comments";
    }

}
