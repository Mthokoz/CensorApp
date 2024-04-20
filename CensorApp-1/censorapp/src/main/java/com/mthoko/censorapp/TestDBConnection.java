package com.mthoko.censorapp;

import com.mthoko.censorapp.util.DBConnectionUtil;
import java.sql.Connection;
import java.sql.SQLException;

public class TestDBConnection {
    public static void main(String[] args) throws ClassNotFoundException{
        try{
            Connection connection = DBConnectionUtil.getConnection();

            if (connection != null){
                System.out.println("Connected to Database");
            }else{
                System.out.println("Connection Failed");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
