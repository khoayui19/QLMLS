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
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;

/**
 *
 * @author khoa0
 */
@WebServlet(urlPatterns = "/add")
public class AddServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String sl = request.getParameter("add");

        try {
            Connection conn = Action.QuanLyMoLietSyServlet.getView();
            if ("thêm sản phẩm".equals(sl)) {
                String s1 = request.getParameter("1");
                String s2 = request.getParameter("2");
                String s3 = request.getParameter("3");
                String s4 = request.getParameter("4");
                String s5 = request.getParameter("5");
                int ss4 = Integer.parseInt(s4);
                float ss5 = Float.parseFloat(s5);
                String sql = "INSERT INTO mo (ma_mo, ten_liet_sy, que_quan, ngay_hi_sinh, ghi_chu, ma_kieu, ma_don_vi) VALUES (?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement st = conn.prepareStatement(sql);
                st.setString(1, s1);
                st.setString(2, s2);
                st.setString(3, s3);
                st.setInt(4, ss4);
                st.setFloat(5, ss5);
                PrintWriter out = response.getWriter();
                int check = st.executeUpdate();
                if (check > 0) {
                    response.sendRedirect("/QLMLS/view.jsp");
                } else {
                    out.print("thêm thất bại!!!");
                }

            }
            if ("them".equals(sl)) {

                String s1 = request.getParameter("1");
                String s2 = request.getParameter("2");
                String s3 = request.getParameter("3");
                String s4 = request.getParameter("4");
                String sql = "INSERT INTO nghia_trang (ma_nghia_trang, ten_nghia_trang, phuong, quan, ma_tinh, ghi_chu) VALUES (?, ?, ?, ?, ?, ?)";
                PreparedStatement st = conn.prepareStatement(sql);
                st.setString(1, s1);
                st.setString(2, s2);
                st.setString(3, s3);
                st.setString(4, s4);
                PrintWriter out = response.getWriter();
                int check = st.executeUpdate();
                if (check > 0) {
                    response.sendRedirect("/QLMLS/view.jsp");
                } else {
                    out.print("thêm thất bại!!!");
                }

            }
            if ("them".equals(sl)) {
                String s1 = request.getParameter("1");
                String s2 = request.getParameter("2");
                String s3 = request.getParameter("3");
                String s4 = request.getParameter("4");
                String sql = "INSERT INTO bong (stt_bong, stt_hang_ngang, stt_hang_doc, ghi_chu) VALUES (?, ?, ?, ?)";
                PreparedStatement st = conn.prepareStatement(sql);
                st.setString(1, s1);
                st.setString(2, s2);
                st.setString(3, s3);
                st.setString(4, s4);
                PrintWriter out = response.getWriter();
                int check = st.executeUpdate();
                if (check > 0) {
                    response.sendRedirect("/QLMLS/view.jsp");
                } else {
                    out.print("thêm thất bại!!!");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(AddServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
