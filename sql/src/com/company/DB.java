package com.company;

import java.sql.*;

/**
 * Created by hackeru on 4/5/2017.
 */
public class DB {
    public static final String HOST = "10.0.11.49";
    private static boolean flag=true;
    public static Connection getConnection() throws SQLException {
        if(flag){
            try {
                Class.forName("oracle.jdbc.OracleDriver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            flag=false;
        }
            Connection connection= DriverManager.getConnection("jdbc:oracle:thin:@"+ HOST +":1521/XE","SYSTEM","12345");
        return connection;
    }

    public static abstract class SqlConnection implements Connection{
        private Connection connection;

        public void setConnection(Connection connection) {
            this.connection = connection;
        }

        @Override
        public void close() throws SQLException {
            connection.close();
            System.out.println("in close");
        }
    }
}
