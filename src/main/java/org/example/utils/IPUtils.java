package org.example.utils;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

public class IPUtils {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try {
                Connection root = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/zqqd1?useUnicode=true&useSSL=false&characterEncoding=utf8&useSSL=true&serverTimezone=UTC", "root", "123456");
                        double d = 144646464644646467.33334654633334646333666;
                BigDecimal decimal =new BigDecimal(d);
                System.out.println(decimal);
                System.out.println(d);
//                while (elements.hasMoreElements()){
//                    Object o = elements.nextElement();
//                    System.out.println(o);
//                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
