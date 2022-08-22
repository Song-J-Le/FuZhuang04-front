package com.cn.wanxi.util;

import java.sql.*;

/**
 * 1.加载驱动
 * 2.链接数据库
 * 3.编译sql
 * 4.执行sql
 * 5.返回结果集
 * 6.关闭连接
 * 在连接数据库查询或者更新操作时，最费时间的就是连接数据库和关闭连接
 * 如果要更新：1连接数据库   2.执行sql  3.关闭连接
 */
public class JDBC {

    private static Connection connection = null;
    private static PreparedStatement preparedStatement = null;
    private static ResultSet resultSet = null;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    private static Connection getConnection() {

//        有些同学包 zone，或者包乱码
        String url = "jdbc:mysql://127.0.0.1:3306/clothes?serverTimezone=UTC&characterEncoding=UTF-8";
        String user = "root";
        String password = "9909";

        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * 增加，修改，删除 都是用update
     *
     * @param sql
     * @return
     */
    public static int update(String sql) {
        try {
//            编辑sql
            preparedStatement = getConnection().prepareStatement(sql);
//            执行sql
            //            返回结果
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static ResultSet query(String sql) {
        try {
//            编辑sql
            PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
//            执行sql
            //            返回结果
            resultSet = preparedStatement.executeQuery();
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static int getCount(String sql) {
        ResultSet resultSet = JDBC.query(sql);
        try {
            while (resultSet.next()) {
                return resultSet.getInt("count");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public static void close() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(preparedStatement!=null){
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(resultSet!=null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
    }
}
