package com.forstudy.adminboard.controller;

import com.forstudy.adminboard.dto.response.AdminAccountResponse;
import com.forstudy.adminboard.service.AdminAccountService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class AdminAccountController {

    private final AdminAccountService adminAccountService;

    @GetMapping("/admin/members")
    public String members(Model model, HttpServletRequest request) {
        model.addAttribute("request", request);

        return "admin/members";
    }

    @ResponseBody
    @GetMapping("/api/admin/members")
    public List<AdminAccountResponse> getMembers() {

        return adminAccountService.users().stream()
                .map(AdminAccountResponse::from)
                .toList();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ResponseBody
    @DeleteMapping("/api/admin/members/{userId}")
    public void delete(@PathVariable String userId) {
        adminAccountService.deleteUser(userId);

    }

}