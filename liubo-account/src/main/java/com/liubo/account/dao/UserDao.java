package com.liubo.account.dao;

import com.liubo.account.model.UserDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by hzlbo on 2017/2/16 0016.
 */
@Mapper
public interface UserDao {

    boolean insertUser(UserDO userDO);

    UserDO getUserByPhone(String phone);

    String getPwdByPhone(String phone);

    int existPhone(String phone);

    List<UserDO> selectUsers();
}
