package com.hhplus.task.domain.point.infrastructure;

import com.hhplus.task.domain.point.models.UserPointEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPointJpaRepository extends JpaRepository<UserPointEntity, Long> {

}
