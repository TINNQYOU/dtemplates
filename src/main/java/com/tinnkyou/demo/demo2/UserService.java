package com.tinnkyou.demo.demo2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author wb-cq355812
 * @create 2019/02/18
 */
public class UserService {
     public int insert(Connection connection,User user) throws SQLException{
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("");
            return ps.executeUpdate();
        }finally {
            connection.close();
        }
    };
}
