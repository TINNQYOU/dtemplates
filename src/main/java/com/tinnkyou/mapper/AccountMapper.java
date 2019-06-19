package com.tinnkyou.mapper;

import com.tinnkyou.bean.UserAccount;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author wb-cq355812
 * @create 2019/05/14
 */
@Mapper
public interface AccountMapper {
    void save(UserAccount account);
}
