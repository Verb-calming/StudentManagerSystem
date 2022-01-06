package com.gmu.system.util;

import java.sql.*;
import java.util.ResourceBundle;

public class DBUtil {
    private static ResourceBundle bundle = ResourceBundle.getBundle("com/gmu/system/properties/jdbc");
    static {
        try {
            Class.forName(bundle.getString("driver"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(bundle.getString("url"),bundle.getString("user"),bundle.getString("password"));
    }
    public static void close(Connection conn, Statement ps , ResultSet rs){
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
