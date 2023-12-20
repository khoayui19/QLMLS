package controller;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet(name="LoginServlet", urlPatterns={"/Login"})
public class LoginadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException {
        String u = req.getParameter("txtU");
        String p = req.getParameter("txtP");
        PrintWriter out = res.getWriter();
        if (u.equalsIgnoreCase("Khoa") && p.equalsIgnoreCase("123456789")){
            out.print("<body align=\"center\">");
            out.print("<h1> Xin chao "+u+"</h1>");
            out.print("<menu>");              
            String view1 = "<a href=\"http://localhost:9999/QLMLS/view.jsp\">them va chinh sua </a>";
            out.print( "<li><button>"+ view1+ " </button></li>");     
            out.print("</menu>");
            out.print("</body>");
    }else{
            
            String link = "<form action=\"http://localhost:9999/QLMLS/Login.html\">\n" +"<button type=\"submit\">Login</button>" +"</form>";
            out.print("<h1>Enter wrong, login again"+link+ "</h1>");     
        }
        
    }
    }

