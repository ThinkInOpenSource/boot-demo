package com.luo.demo.boot.dao;

import com.luo.demo.boot.entity.UserEntity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author xiangnan
 * date 2018/7/28 0:42
 */
public interface UserDao {

    @Select("select * from person where id = #{id}")
    UserEntity selectById(@Param("id") int id);

}
