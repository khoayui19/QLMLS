package Action;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;

@WebServlet(urlPatterns = "/de")
public class DeleteServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String sl = request.getParameter("de");

        try {
            Connection conn = Action.ConServlet.getView();
            if ("xoa".equals(sl)) {
                String s1 = request.getParameter("1");               
                String sql = "DELETE FROM mo WHERE ma_mo = ?";
                PreparedStatement st = conn.prepareStatement(sql);
                st.setString(1, s1);               
                PrintWriter out = response.getWriter();
                int check = st.executeUpdate();
                if (check > 0) {
                    response.sendRedirect("/QLMLS/view.jsp");
                } else {
                    out.print("delete error");
                }

            }
            if ("xoa".equals(sl)) {

                String s1 = request.getParameter("1");                
                String sql = "DELETE FROM nghia_trang WHERE ma_nghia_trang = ?";
                PreparedStatement st = conn.prepareStatement(sql);
                st.setString(1, s1);                
                PrintWriter out = response.getWriter();
                int check = st.executeUpdate();
                if (check > 0) {
                    response.sendRedirect("/QLMLS/view.jsp");
                } else {
                    out.print("delete error");
                }

            }
            if ("xoa".equals(sl)) {
                String s1 = request.getParameter("1");              
                String sql = "DELETE FROM bong where stt_bong = ? ";
                PreparedStatement st = conn.prepareStatement(sql);
                st.setString(1, s1);               
                PrintWriter out = response.getWriter();
                int check = st.executeUpdate();
                if (check > 0) {
                    response.sendRedirect("/QLMLS/view.jsp");
                } else {
                    out.print("delete error");
                }
            }
        } catch (SQLException ex) {
            out.print("error");
        }
        out.close();
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
