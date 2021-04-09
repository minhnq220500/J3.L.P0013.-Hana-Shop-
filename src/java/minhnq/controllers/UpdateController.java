/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minhnq.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import minhnq.daos.ProductDAO;
import minhnq.daos.ProductHistoryDAO;
import minhnq.dtos.CategoryDTO;
import minhnq.dtos.ProductDTO;
import minhnq.dtos.ProductErrorDTO;
import minhnq.dtos.ProductHistoryDTO;
import minhnq.dtos.UserDTO;

/**
 *
 * @author admin
 */
public class UpdateController extends HttpServlet {

    private final String ERROR = "update.jsp";
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
        try {
            if (userID!= null) {
                String id = request.getParameter("txtProductID");
                String name = request.getParameter("txtProductName");

                String price = request.getParameter("txtProductPrice");
//                float pricee = Float.parseFloat(price);

                String quantity = request.getParameter("txtProductQuantity");
//                int quantityy = Integer.parseInt(quantity);

                String image = request.getParameter("txtProductImage");
                String description = request.getParameter("txtProductDescription");
                String category = request.getParameter("cmbCate");
                String status=request.getParameter("cmbStatus");

                ProductDAO dao = new ProductDAO();
//                int update = dao.updateProduct(name, price, quantity, image, description, category, id);
                int update=dao.updateProduct(name, price, quantity, status, image, description, category, id);

                ProductHistoryDAO history_dao = new ProductHistoryDAO();

//            HttpSession session = request.getSession();
//            UserDTO user = (UserDTO) session.getAttribute("LOGIN_USER");
//            String userID = user.getUserID();
                if (update == 1) {
                    ProductHistoryDTO history = new ProductHistoryDTO(0, "Update", new Date(), id, userID);

//                    int result = history_dao.insertHistory(history);
                    history_dao.insertHistory(history);

                    url = SUCCESS;
                }
            } else {
                url = LOGIN;
            }

        } catch (Exception e) {
            log("ERROR At UpdateController: " + e.getMessage());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
            out.close();;
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
