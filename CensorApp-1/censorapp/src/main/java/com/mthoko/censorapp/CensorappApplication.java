package com.mthoko.censorapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



import com.mthoko.censorapp.util.DBConnectionUtil;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootApplication
public class CensorappApplication {

	public static void main(String[] args) throws ClassNotFoundException {
		SpringApplication.run(CensorappApplication.class, args);
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
