package com.test.demo.boot;

import com.luo.demo.boot.BootApplication;
import com.luo.demo.boot.dao.UserDao;
import com.luo.demo.boot.entity.UserEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * 执行测试用例：
 *   mvn test -Dtest=com.test.demo.boot.UserDaoTest -Dspring.profiles.active=dev
 *   mvn test -Dtest=com.test.demo.boot.UserDaoTest#select
 *   mvn test -Dtest=com.test.demo.boot.UserDao*#select
 *   mvn test -Dtest=com.test.demo.boot.UserDao*#select*
 *
 * @author xiangnan
 * date 2018/7/28 0:46
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = BootApplication.class)
public class UserDaoTest {

    @Resource
    private UserDao userDao;

    @Test
    public void select() {
        Assert.assertTrue(userDao != null);

        UserEntity user = userDao.selectById(1);
        if (user != null) {
            Assert.assertTrue(user.getId() > 0);
            Assert.assertTrue(user.getName() != null);
            Assert.assertTrue(user.getAge() > 0);
        }
    }

}
