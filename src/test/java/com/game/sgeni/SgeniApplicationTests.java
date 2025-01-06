package com.game.sgeni;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.game.sgeni.entity.Count;
import com.game.sgeni.repository.CountRepository;

@SpringBootTest
class SgeniApplicationTests {
	
	@Autowired
	private CountRepository countRepository;
	
	@Test
	void test() {
		
		System.out.println("asd");
		
	}
	
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

	@Test
	void insertJpa() {
		
		Count count = new Count();
		
		count.setWord1("테스트중");
		count.setWord1("testing");
		
		this.countRepository.save(count);
		
	}

	@Test
	void slectJpa() {
		
		List<Count> countList = this.countRepository.findAll();
		
		System.out.println(countList);
		
	}
	
	
	
}
