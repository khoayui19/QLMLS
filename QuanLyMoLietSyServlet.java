package Action;
import jakarta.servlet.http.HttpServlet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author khoa0
 */

public class QuanLyMoLietSyServlet extends HttpServlet {
     private static final long serialVersionUID = 1L;
   
    public static Connection getView() {
      try 
        {  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mo", "root", "swordartonline1");  
            return con;
        }
      catch(ClassNotFoundException | SQLException e){
           Connection con = null;
          return con;
}
    }
    public static Connection getView() {
      try 
        {  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/mo", "root", "swordartonline1");  
            return con2;
        }
      catch(ClassNotFoundException | SQLException e){
           Connection con2 = null;
          return con2;
}
    }
}
