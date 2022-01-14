package sqlite;

import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.SQLException;  
   
public class InsertRecords {  
   
    private Connection connect() {  
        // SQLite connection string  
        String url = "jdbc:sqlite:C://sqlite/SSSIT.db";  
        Connection conn = null;  
        try {  
            conn = DriverManager.getConnection(url);  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
        return conn;  
    }  
   
  
    public void insert(String name, double capacity) throws ClassNotFoundException {  
        String sql = "INSERT INTO employees(name, capacity) VALUES(?,?)";  
   
        try{
        	Class.forName("org.sqlite.JDBC");
            Connection conn = this.connect();  
            PreparedStatement pstmt = conn.prepareStatement(sql);  
            pstmt.setString(1, name);  
            pstmt.setDouble(2, capacity);  
            pstmt.executeUpdate();  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
    }  
   
    public static void main(String[] args) throws ClassNotFoundException {  
   
        InsertRecords app = new InsertRecords();  
        // insert three new rows  
        app.insert("Aryan", 30000);  
        app.insert("Robert", 40000);  
        app.insert("Jerry", 50000);  
    }  
   
}  
