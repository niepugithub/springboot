package com.sgcc.user.service;

import com.sgcc.user.dao.UserDao;
import com.sgcc.user.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Transactional
@Service("userService")
public class UserServiceImpl implements UserService {

    /**
     * 因为没有在spring的文件中显式的声明userService实现类，直接通过getBean得到 userService 会找不到
     *  需要显式配置 @Service ("userService")，指定bean的名称
     *  相当与<bean id="userService" class="com.jxust.ssm.service.impl.UserServiceImpl"></bean>
     */
//    @Resource
    @Autowired
    private UserDao userDao;

    public User getUserById(Integer userid) {   
        return this.userDao.selectByPrimaryKey(userid);
    }

    public int insert(User user) {
        return this.userDao.insert(user);
    }

    public List<User> getAllUser(){
        return userDao.getAllUser();
    }

}