package com.threebee.gooslegoosle.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.threebee.gooslegoosle.entity.MenuEntity;

public interface IMenuRepository extends JpaRepository<MenuEntity, Integer>{

}
