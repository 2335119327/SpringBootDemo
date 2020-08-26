package com.dong.springboot.repository;

import com.dong.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author dong
 * @date 2020/8/25 22:24
 */
//继承JpaRepository来完成对数据库的操作
public interface UserRepository extends JpaRepository<User,Integer> {
}
