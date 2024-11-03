package com.selisegroup.repository;


import com.selisegroup.entity.JwtTokenInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface JwtTokenRepository extends JpaRepository<JwtTokenInfoEntity, UUID> {
	JwtTokenInfoEntity findByUsername(String username);
	Integer countJwtTokenInfoEntityByUsername(String username);
}
