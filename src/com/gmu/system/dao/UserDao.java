package com.gmu.system.dao;

import com.gmu.system.entity.User;
import com.gmu.system.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private static Connection conn = null;
    private static PreparedStatement ps = null;
    private static ResultSet rs = null;

    private UserDao(){}

    public static List<User> select(){
        User user = null;
        List<User> users = new ArrayList<>();
        String sql = "select username,password,lvl from t_user where lvl = '用户'";
        try {
            conn =  DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                user = new User(rs.getString("username"),rs.getString("password"),rs.getString("lvl"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn,ps,rs);
        }
        return users;
    }

    public static int add(User user){
        String sql = "insert into t_user values(?,?,?)";
        int result = 0;
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,user.getUsername());
            ps.setString(2,user.getPassword());
            ps.setString(3,user.getLevel());
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn,ps,null);
        }
        return result;
    }

    public static int delete(String username){
        String sql = "delete from t_user where username = ?";
        int result = 0;
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,username);
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn,ps,null);
        }
        return result;
    }

    public static int update(User user){
        String sql = "update t_user set password = ?,lvl = ? where username = "+user.getUsername();
        int result = 0;
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,user.getPassword());
            ps.setString(2,user.getLevel());
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn,ps,null);
        }
        return result;
    }
}
