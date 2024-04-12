package com.hhplus.task.domain.token.infrastructure;

import com.hhplus.task.domain.token.models.TokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenJpaRepository extends JpaRepository<TokenEntity, String> {

}
