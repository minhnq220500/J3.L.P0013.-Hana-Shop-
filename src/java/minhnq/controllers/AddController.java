/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minhnq.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import minhnq.daos.ProductDAO;
import minhnq.dtos.CartDTO;
import minhnq.dtos.ProductDTO;
import minhnq.dtos.UserDTO;

/**
 *
 * @author admin
 */
public class AddController extends HttpServlet {

    private static final String SUCCESS = "HomeController";
    private static final String ERROR = "error.jsp";
    private static final String LOGIN = "login.jsp";
    
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
            if (userID != null) {

                String productID = request.getParameter("txtID");

                if(productID==null){
                    url=SUCCESS;
                }
                ProductDAO dao = new ProductDAO();
                ProductDTO product = dao.getListProductByID(productID);
                
//                int quantity=dao.getProductQuantityByID(productID);
//                request.setAttribute("PRODUCT_QUANTITY", quantity);
                
//                List<ProductDTO> list=new ArrayList<>();
//                list.add(product);
//                session.setAttribute("Product", list);
                
                product.setQuantity(1);
                
//                //l???y s??? l?????ng ????? so min max
//                int quantity=product.getQuantity();

                CartDTO cart = (CartDTO) session.getAttribute("CART");

                if (cart == null) {//xem coi gi??? h??ng c?? hay ch??a
                    cart = new CartDTO(userID);//n???u ch??a th?? t???o m???i gi??? h??ng

                }
                cart.addToCart(product);
                session.setAttribute("CART", cart);//c???p nh???t l???i gi??? h??ng
                
//                session.setAttribute("PRO_QUANTITY", quantity);
                
                url = SUCCESS;
            } else {
                url = LOGIN;
            }

        } catch (Exception e) {
            log("ERROR At AddController: " + e.getMessage());
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
