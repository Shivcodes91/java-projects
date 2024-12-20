package files;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class Conn {

	 Connection c = null;
     Statement s ;
	public Conn() {
		
	      try {
	    	  Class.forName("org.postgresql.Driver");
	         c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/university", "postgres", "Shiv@9140");
	      
         s=c.createStatement();
	        
	        
	      } catch ( Exception e ) {
	         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	         System.exit(0);
	      }
	     
	}
	
	public static void main(String[] args) {
		

	}

}
