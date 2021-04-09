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
import minhnq.dtos.CartDTO;
import minhnq.dtos.ProductDTO;
import minhnq.dtos.UserDTO;

/**
 *
 * @author admin
 */
public class EditController extends HttpServlet {

    private final String ERROR="error.jsp";
    private final String SUCCESS="GetListCartController";
    private final String THONG_BAO="cart.jsp";
    private final String LOGIN="login.jsp";
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
        String userName = user.getName();
        ProductDAO dao=new ProductDAO();
        try {
            if (userName != null) {

                String id = request.getParameter("txtID");
                int quantity = Integer.parseInt(request.getParameter("txtQuantity"));
                
                ProductDTO productCanTim=dao.getListProductByID(id);
                int soLuong=productCanTim.getQuantity();
                
                if(quantity>soLuong){
                    request.setAttribute("ThongBao", "Quantity out of stock");
                    url=THONG_BAO;
                }
                
                CartDTO cart = (CartDTO) session.getAttribute("CART");
                ProductDTO newProduct = null;
                for (ProductDTO product : cart.getCart().values()) {
                    if (product.getProductID().equals(id)) {
                        
                        newProduct =dao.getListProductByID(id);
                        newProduct.setQuantity(quantity);
                        break;
                    }
                }
                cart.update(newProduct);
                session.setAttribute("CART", cart);
                
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
