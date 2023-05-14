package com.forstudy.adminboard.service;

import com.forstudy.adminboard.domain.constant.RoleType;
import com.forstudy.adminboard.dto.AdminAccountDto;
import com.forstudy.adminboard.repository.AdminAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class AdminAccountService {

    private final AdminAccountRepository adminAccountRepository;

    public Optional<AdminAccountDto> searchUser(String username) {
        return Optional.empty();
    }

    public AdminAccountDto saveUser(String username, String password, Set<RoleType> roleTypeSet, String email, String nickname, String memo) {
        return null;
    }

    public List<AdminAccountDto> users() {
        return List.of();
    }

    public void deleteUser(String username) {

    }

}
