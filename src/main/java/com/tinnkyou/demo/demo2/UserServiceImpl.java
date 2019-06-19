package com.tinnkyou.demo.demo2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author wb-cq355812
 * @create 2019/02/18
 */
public class UserServiceImpl {
    public void insert(User user) {
        UserService service = new UserService();
        Connection conn = null;
        try {
            Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/chapter3","root","123456");
            conn.setAutoCommit(false);
            service.insert(conn,user);
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
