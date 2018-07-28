package com.luo.demo.boot.dao;

import com.luo.demo.boot.entity.UserEntity;
import org.apache.ibatis.annotations.Param;

/**
 * @author xiangnan
 * date 2018/7/28 0:42
 */
public interface UserDao {

    UserEntity selectById(@Param("id") int id);

}
