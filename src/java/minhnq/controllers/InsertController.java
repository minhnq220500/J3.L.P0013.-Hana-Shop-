/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minhnq.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import minhnq.daos.ProductDAO;
import minhnq.dtos.ProductDTO;
import minhnq.dtos.ProductErrorDTO;
import minhnq.dtos.UserDTO;

/**
 *
 * @author admin
 */
public class InsertController extends HttpServlet {

    private final String ERROR = "insert.jsp";
    private final String NOT_SUCCESS = "error.jsp";
    private final String SUCCESS = "ManageProductController";
    private final String LOGIN = "login.jsp";
    
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
        HttpSession session = request.getSession();
        UserDTO user = (UserDTO) session.getAttribute("LOGIN_USER");
        String userID = user.getUserID();
        ProductErrorDTO error = new ProductErrorDTO("", "", "", "", "", "", "", "", "", "");
        try {
            if (userID != null) {
                String productID = request.getParameter("txtProductID");
                String productName = request.getParameter("txtProductName");

                String price = request.getParameter("txtPrice");
                float pricec = Float.parseFloat(price);

                String quantity = request.getParameter("txtQuantity");
                int quantityy = Integer.parseInt(quantity);

                boolean status = true;
                String image = request.getParameter("txtImage");
                String description = request.getParameter("txtDesscription");
                Date createDate = new Date();
                int counter = 0;
                String categoryID = request.getParameter("ckbCate");

                ProductDAO dao = new ProductDAO();

                boolean check = true;

                if (dao.checkDuplicate(productID) == true) {
                    check = false;
                    error.setProductIDError("Product ID is duplicated");
                }

                if (check == true) {
                    ProductDTO product = new ProductDTO(productID, productName, pricec, quantityy, status, image, description, createDate, counter, categoryID);
                    if (dao.insertProduct(product) == 1) {
                        url = SUCCESS;
                    } else {
                        url = NOT_SUCCESS;
                    }
                } else {
                    //lấy dữ liệu bị lỗi đưa qua trang update để hiện lên
                    url = ERROR;
                    request.setAttribute("ERROR_PRODUCT", error);
                }
            } else {
                url = LOGIN;
            }

        } catch (Exception e) {
            log("ERROR At InserController: " + e.getMessage());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
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
