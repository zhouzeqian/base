package com.llc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.llc.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
