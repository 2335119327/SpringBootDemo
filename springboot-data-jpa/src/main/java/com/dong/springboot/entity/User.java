package com.dong.springboot.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author dong
 * @date 2020/8/25 22:17
 */
//使用JPA注解配置映射关系
@Entity(name = "tbl_user")  //告诉JPA这是一个实体类（和数据表映射的类）name来指定和哪个表对应
@JsonIgnoreProperties(value = {"hibernateLazyInitializer","handler"})
public class User {

    @Id  //声明为主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) //设置为自增主键
    private Integer id;

    @Column
    private String name;

    @Column //省略默认列名就是属性名
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
