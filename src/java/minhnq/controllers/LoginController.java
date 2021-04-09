/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minhnq.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import minhnq.daos.ProductDAO;
import minhnq.daos.UserDAO;
import minhnq.dtos.CategoryDTO;
import minhnq.dtos.ProductDTO;
import minhnq.dtos.UserDTO;

/**
 *
 * @author admin
 */
public class LoginController extends HttpServlet {

    private final String ERROR = "error.jsp";
    private static final String FAILURE = "login.jsp";
    private static final String SUCCESS="HomeController";
    
    

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String url = ERROR;
        try {
            
            String userID = request.getParameter("txtUserID");
            String password = request.getParameter("txtPassword");

            UserDAO dao = new UserDAO();
            UserDTO userVuaDangNhap = dao.checkLogin(userID, password);
            
            ProductDAO pro_dao=new ProductDAO();
            List<ProductDTO> list=pro_dao.getListProduct();
            List<CategoryDTO> list_cate=pro_dao.getListCategory();

            if (userVuaDangNhap != null) {
                HttpSession session = request.getSession();
                session.setAttribute("LOGIN_USER", userVuaDangNhap);
                request.setAttribute("LIST_PRODUCT", list);
                request.setAttribute("LIST_CATE", list_cate);
                url=SUCCESS;
            } else {
                request.setAttribute("MESSAGE", "Wrong userID and password");
                url = FAILURE;

            }
        } catch (Exception e) {
            log("ERROR At LoginController: " + e.getMessage());
        } finally {
            response.sendRedirect(url);
//            response.sendRedirect(url);
//            khi nào chuyển trang mà không cần chuyển dữ liệu thì dùng response
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
