<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> View list molietsy </title>
    </head>
    <body>
        <h1> Danh sach mo </h1>
        <div style=height: 200px; overflow-y: scroll;">
            <h3> action edit </h3> 
            <ul> 
                <li><a href="http://localhost:9999/QLMLS/Login?txtU=Khoa&txtP=123">return</a></li>
                <li><a href="/QLMLS/addsp.jsp">ADD</a></li>
                <li><a href="/QLMLS/upsp.jsp">edit</a></li>
            </ul>
        </div>
        <table border="1">
            <tr>
                <th>Ma mo</th>
                <th>Ten liet sy</th>
                <th>Que quan</th>
                <th>Ngay hi sinh</th>
                <th>Ghi chu</th>
                <th>Ma kieu</th>
                <th>Ma don vi</th>

            </tr>
            <% 
                try {
               
                    java.sql.Connection con = Action.QuanLyMoLietSyServlet.getView();
                    if (con != null) {
                        java.sql.Statement stml = con.createStatement();
                        String sql = "select * from mo";
                        java.sql.ResultSet rs = stml.executeQuery(sql);
                    
                        while (rs.next()) {
                            String mamo = rs.getString("ma_mo");
                            String tenlietsy = rs.getString("ten_liet_sy");
                            String quequan = rs.getString("que_quan");
                            int nhs = rs.getInt("ngay_hi_sinh");
                            String ghichu = rs.getString("ghi_chu");
                            String makieu = rs.getString("ma_kieu");
                            String madv = rs.getString("ma_don_vi");
            %>
            <tr>
                <td><%= mamo %></td>
                <td><%= tenlietsy %></td>
                <td><%= quequan %></td>
                <td><%= nhs %></td>
                <td><%= ghichu %></td>
                <td><%= makieu %></td>
                <td><%= madv %></td>
                <td><form action="de" method="post">
                        <input type="hidden" name="1" value="<%= mamo %>"/>
                        <input type="submit" name="de" value="xoa">
                    </form>
                </td>
            </tr>
            <%
                        }
                        rs.close();
                        con.close();
                    } else {
                        out.println("Connection is null");
                    }
                } catch (Exception e) {
                    out.println("Error: " + e.getMessage());
                }
            %>

        </table>


        <h1> Danh sach nghia trang </h1>


        <table border="1">
            <tr>
                <th>Ma nghia trang</th>
                <th>Ten nghia trang</th>
                <th>Puong</th>
                <th>Quan</th>
                <th>Ma tinh</th> 
                <th>Ghi chu</th>            
            </tr>
            <% 
                try {
               
                    java.sql.Connection con = Action.QuanLyMoLietSyServlet.getView();
                    if (con != null) {
                        java.sql.Statement stml = con.createStatement();
                        String sql = "select * from nghia_trang";
                        java.sql.ResultSet rs = stml.executeQuery(sql);
                    
                        while (rs.next()) {
                            String mant = rs.getString("ma_nghia_trang");
                            String tennt = rs.getString("ten_nghia_trang");
                            String phuong = rs.getString("phuong");
                            String quan = rs.getString("quan");
                            String matinh = rs.getString("ma_tinh");
                            String ghichu = rs.getString("ghi_chu");
                        
            %>
            <tr>
                <td><%= mant %></td>
                <td><%= tennt %></td>
                <td><%= phuong %></td>
                <td><%= quan %></td> 
                <td><%= matinh %></td>
                <td><%= ghichu %></td>                           
                <td><form action="de" method="post">
                        <input type="hidden" name="1" value="<%= mant %>"/>
                        <input type="submit" name="de" value="xoa">
                    </form>
                </td>
            </tr>
            <%
                        }
                        rs.close();
                        con.close();
                    } else {
                        out.println("Connection is null");
                    }
                } catch (Exception e) {
                    out.println("Error: " + e.getMessage());
                }
            %>
        </table>
        <h1> Danh sach bong </h1>


        <table border="1">
            <tr>
                <th>Stt bong</th>
                <th>Stt hang ngang</th>
                <th>Stt hang doc </th>
                <th>Ghi chu</th>           
            </tr>
            <% 
                try {
               
                    java.sql.Connection con = Action.QuanLyMoLietSyServlet.getView();
                    if (con != null) {
                        java.sql.Statement stml = con.createStatement();
                        String sql = "select * from bong";
                        java.sql.ResultSet rs = stml.executeQuery(sql);
                    
                        while (rs.next()) {
                            String sttbong = rs.getString("stt_bong");
                            String stthn = rs.getString("stt_hang_ngang");
                            String stthd = rs.getString("stt_hang_doc");
                            String ghichu = rs.getString("ghi_chu");
                        
            %>
            <tr>
                <td><%= sttbong %></td>
                <td><%= stthn %></td>
                <td><%= stthd %></td>
                <td><%= ghichu %></td>                           
                <td><form action="de" method="post">
                        <input type="hidden" name="1" value="<%= sttbong %>"/>
                        <input type="submit" name="de" value="xoa">
                    </form>
                </td>

            </tr>
            <%
                        }
                        rs.close();
                        con.close();
                    } else {
                        out.println("Connection is null");
                    }
                } catch (Exception e) {
                    out.println("Error: " + e.getMessage());
                }
            %> 
        </table>
    </body>   
</html>

