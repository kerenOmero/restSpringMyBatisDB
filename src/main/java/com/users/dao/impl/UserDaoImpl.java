
package com.users.dao.impl;

import com.users.dao.UserDao;
import com.users.dao.UserMapper;
import com.users.domain.User;
import com.users.infra.infra.dao.BaseDaoImpl;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl extends BaseDaoImpl implements UserDao {

    public List<User> getAllUsers() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            List<User> allUsers = userMapper.getAllUsers();
            return allUsers;
        } finally {
            session.close();
        }
    }

    public User getUserById(String userId) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            User userWithId = userMapper.getUserById(Integer.parseInt(userId));
            return userWithId;
        } finally {
            session.close();
        }
    }

    public Boolean deleteUserById(String userId) {
        SqlSession session = sqlSessionFactory.openSession();
        boolean mangeToDelete = false;
        try {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            int count = userMapper.deleteUserById(Integer.parseInt(userId));
            if (count > 0) {
                mangeToDelete = true;
            }
            return mangeToDelete;
        } finally {
            session.commit();
            session.close();
        }
    }

    public int create(User user) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            int count = userMapper.createUser(user);
            return user.getId();
        } finally {
            session.commit();
            session.close();
        }
    }

    public Boolean updateUserById(String userId, User user) {
        SqlSession session = sqlSessionFactory.openSession();
        boolean mangeToUpdate = false;
        try {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            int count = userMapper.updateUserById(user);
            if(count > 0)
                mangeToUpdate = true;
            return mangeToUpdate;
        } finally {
            session.commit();
            session.close();
        }
    }
}

