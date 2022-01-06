package com.gmu.system.dao;

import com.gmu.system.entity.User;
import com.gmu.system.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {
    private static Connection conn = null;
    private static PreparedStatement ps = null;
    private static ResultSet rs = null;

    private LoginDao(){}

    public static int register(String username,String password){
        String lvl = "用户";
        String sql = "insert into t_user(username,password,lvl) values(?,?,?)";
        int result = 0;
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,password);
            ps.setString(3,lvl);
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn,ps,null);
        }
        return result;
    }

    public static User login(String username, String password){
        String sql = "select lvl from t_user where username = ? and password = ?";
        User user = null;
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,password);
            rs = ps.executeQuery();
            if (rs.next()) user = new User(username,password,rs.getString("lvl"));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn,ps,rs);
        }
        return user;
    }
}
