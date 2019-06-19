package com.tinnkyou.TransactionDemo;

import com.tinnkyou.bean.UserAccount;
import com.tinnkyou.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wb-cq355812
 * @create 2019/06/17
 */
@Service
public class UserAccountServiceImpl implements IUserAccountService {
    @Autowired
    private AccountMapper accountMapper;
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveAccount(UserAccount account) {
        accountMapper.save(account);
        System.out.println(1/0);
    }
}
