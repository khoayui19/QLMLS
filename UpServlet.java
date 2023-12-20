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

/**
 *
 * @author hieu0
 */
@WebServlet(urlPatterns = "/up")
public class UpServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String sl = request.getParameter("up");

        try {
            Connection conn = Action.QuanLyMoLietSyServlet.getView();
            if ("Sua".equals(sl)) {
                String s1 = request.getParameter("1");
                String s2 = request.getParameter("2");
                String s3 = request.getParameter("3");
                String s4 = request.getParameter("4");
                String s5 = request.getParameter("5");
                int ss4 = Integer.parseInt(s4);
                float ss5 = Float.parseFloat(s5);
                String sql = "update mo set ten_liet_sy = ?, que_quan = ?, ngay_hi_sinh = ?, ghi_chu=?, ma_kieu=?, ma_don_vi=? where ma_mo = ?";
                PreparedStatement st = conn.prepareStatement(sql);                                         
                st.setString(1, s2);
                st.setString(2, s3);
                st.setInt(3, ss4);
                st.setFloat(4, ss5);
                st.setString(5, s1);
                PrintWriter out = response.getWriter();
                int check = st.executeUpdate();
                if (check > 0) {
                    response.sendRedirect("/QLMLS/view.jsp");
                } else {
                    out.print("data error");
                }
                
            }
            if ("Sua".equals(sl)) {

                String s1 = request.getParameter("1");
                String s2 = request.getParameter("2");
                String s3 = request.getParameter("3");
                String s4 = request.getParameter("4");
                String sql = "update nghia_trang set ten_nghia_trang= ?, phuong= ?, quan= ?, ma_tinh= ?, ghi_chu= ? where ma_nghia_trang= ?";
                PreparedStatement st = conn.prepareStatement(sql);
                st.setString(4, s1);
                st.setString(1, s2);
                st.setString(2, s3);
                st.setString(3, s4);
                PrintWriter out = response.getWriter();
                int check = st.executeUpdate();
                if (check > 0) {
                    response.sendRedirect("/QLMLS/view.jsp");
                } else {
                    out.print("data error");
                }

            }
            if ("Sua".equals(sl)) {
                String s1 = request.getParameter("1");
                String s2 = request.getParameter("2");
                String s3 = request.getParameter("3");
                String s4 = request.getParameter("4");
                String sql = "Update bong set stt_hang_ngang = ?, stt_hang_doc = ?, ghi_chu = ? where stt_bong = ?";
                PreparedStatement st = conn.prepareStatement(sql);
                st.setString(4, s1);
                st.setString(1, s2);
                st.setString(2, s3);
                st.setString(3, s4);
                PrintWriter out = response.getWriter();
                int check = st.executeUpdate();
                if (check >0) {
                    response.sendRedirect("/QLMLS/view.jsp");
                } else {
                    out.print("data error");
                }
            }
        } catch (SQLException ex) {
            out.print("data error");
        }
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
