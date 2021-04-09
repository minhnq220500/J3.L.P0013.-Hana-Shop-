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
import minhnq.dtos.ProductHistoryDTO;
import minhnq.dtos.UserDTO;

/**
 *
 * @author admin
 */
public class DeleteController extends HttpServlet {

    private final String SUCCESS = "ManageProductController";
    private final String ERROR = "error.jsp";
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
            if (userID != null) {
                String list_ProductID_Delete[] = request.getParameterValues("ckbDel");

                if (list_ProductID_Delete != null) {
                    ProductDAO dao = new ProductDAO();
                    ProductHistoryDAO history_dao = new ProductHistoryDAO();

                    for (String delete_item : list_ProductID_Delete) {
                        if (dao.deleteProductByID(delete_item) == 1) {

                            int history = history_dao.insertHistory(new ProductHistoryDTO(0, "Delete", new Date(), delete_item, userID));

                            if (history == 1) {
                                url = SUCCESS;
                            }

                        }
                    }
                } else {
                    request.setAttribute("MESSAGE", "Delete list is empty!!");
                    url = SUCCESS;
                }
            } else {
                url = LOGIN;
            }

        } catch (Exception e) {
            log("ERROR At DeleteController: " + e.getMessage());
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
