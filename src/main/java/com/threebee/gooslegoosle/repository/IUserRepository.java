package com.threebee.gooslegoosle.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.threebee.gooslegoosle.entity.UserEntity;

public interface IUserRepository extends JpaRepository<UserEntity, Integer>{ 

}
