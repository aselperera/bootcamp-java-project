package com.team.model.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.team.entity.LoginDTO;

public interface LoginDTODao extends JpaRepository<LoginDTO, String> {

}
