package com.forstudy.adminboard.repository;
import com.forstudy.adminboard.domain.AdminAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminAccountRepository extends JpaRepository<AdminAccount, String> {

}
