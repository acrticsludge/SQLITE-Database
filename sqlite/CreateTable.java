package sqlite;

import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.SQLException;  
import java.sql.Statement;  
   
public class CreateTable {  
   
    public static void createNewTable() throws ClassNotFoundException {  
        // SQLite connection string  
        String url = "jdbc:sqlite:C://sqlite/SSSIT.db";  
          
        // SQL statement for creating a new table  
        String sql = "CREATE TABLE IF NOT EXISTS employees (\n"  
                + " id integer PRIMARY KEY,\n"  
                + " name text NOT NULL,\n"  
                + " capacity real\n"  
                + ");";  
          
        try{  
        	Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection(url);  
            Statement stmt = conn.createStatement();  
            stmt.execute(sql);  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
    }  
   
    /** 
     * @param args the command line arguments 
     * @throws ClassNotFoundException 
     */  
    public static void main(String[] args) throws ClassNotFoundException {  
        createNewTable();  
    }  
   
}  