package com.mysite.sbb.user;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<SiteUser, Long>{ //SiteUser의 PK는 Long타입
    Optional<SiteUser> findByusername(String username);
}