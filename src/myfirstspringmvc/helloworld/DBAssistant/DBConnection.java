package myfirstspringmvc.helloworld.DBAssistant;
import java.sql.*;

public class DBConnection {

    static
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (Exception e)
        {

            e.printStackTrace();
        }
    }

    private static Connection SingletonClassInstance() {
        try {
            String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
            String DB_URL = "jdbc:mysql://localhost:3306/testDataBase?useSSL=false&serverTimezone=UTC&characterEncoding=UTF-8";
            String USER = "root";
            String PASS = "xueyinsong";
            try {
                Class.forName(JDBC_DRIVER);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                return null;
            }
            long start =System.currentTimeMillis();
            // 建立连接
            Connection conn = DriverManager.getConnection(DB_URL,
                    USER, PASS);
            long end = System.currentTimeMillis();
            System.out.println(conn);
            System.out.println("建立连接耗时： " + (end - start) + "ms 毫秒");
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static Connection conn = null;

    public static Connection shareInstance() {
        if (conn != null) {
            return conn;
        } else  {
            conn = DBConnection.SingletonClassInstance();
            return  conn;
        }
    }
}