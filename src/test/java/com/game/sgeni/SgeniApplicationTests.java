package com.game.sgeni;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SgeniApplicationTests {

	@Test
	void dbConnecTest() {
		Connection dbconn = null;
	    String dbUrl = "jdbc:postgresql://ep-dark-boat-a4da7k40.us-east-1.pg.koyeb.app/koyebdb";
	    String dbUser = "game";
	    String dbPassword = "B7aLPlKt2YgW"; 
	    
		Connection connection = null;
        
        try 
        {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(
            		dbUrl, 
            		dbUser, 
            		dbPassword);
            dbconn = connection;
            
            System.out.println("DB Connection [성공]");
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        } 
        catch (ClassNotFoundException e) 
        {
            e.printStackTrace();
        }
	    
	}

}
