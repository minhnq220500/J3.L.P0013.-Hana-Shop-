/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minhnq.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author admin
 */
public class MainController extends HttpServlet {

    private static final String ERROR = "error.jsp";

    private static final String HOME = "HomeController";
    private static final String LOGIN_ACCOUNT = "login.jsp";
    private static final String CONFIRM_LOGIN = "LoginController";

    private static final String LOGOUT = "LogoutController";
    private static final String CATEGORY_ID = "CategoryController";
    private static final String PRODUCT_DETAIL = "DetailController";

    private static final String SEARCH = "SearchController";
    private static final String SEARCH_BY_PRICE = "SearchByPriceController";

    private static final String UPDATE = "update.jsp";
    private static final String CONFIRM_UPDATE = "UpdateController";

    private static final String MANAGE_PRODUCT = "ManageProductController";
    private static final String DELETE = "DeleteController";

    private static final String INSERT = "insert.jsp";
    private static final String CONFIRM_INSERT = "InsertController";

    private static final String PRODUCT_HISTORY = "ProductHistoryController";

    private static final String ADD = "AddController";
    private final static String VIEW_CART = "GetListCartController";
    private final static String REMOVE = "RemoveController";
    private final static String EDIT = "EditController";

    private static final String ORDER = "OrderController";
    
    private static final String BUYING_HISTORY = "BuyingHistoryController";
    
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
            String btnAction = request.getParameter("btnAction");

            if ("cateButton".equals(btnAction)) {
                url = CATEGORY_ID;
            } else if ("Detail".equals(btnAction)) {
                url = PRODUCT_DETAIL;
            } else if ("Search".equals(btnAction)) {
                url = SEARCH;
            } else if ("Search By Price".equals(btnAction)) {
                url = SEARCH_BY_PRICE;
            } else if ("Login_Account".equals(btnAction)) {
                url = LOGIN_ACCOUNT;
            } else if ("Login".equals(btnAction)) {
                url = CONFIRM_LOGIN;
            } else if ("Logout".equals(btnAction)) {
                url = LOGOUT;
            } else if ("Update".equals(btnAction)) {
                url = UPDATE;
            } else if ("Confirm Update".equals(btnAction)) {
                url = CONFIRM_UPDATE;
            } else if ("Manage Product".equals(btnAction)) {
                url = MANAGE_PRODUCT;
            } else if ("Delete Selected Product".equals(btnAction)) {
                url = DELETE;
            } else if ("Add New".equals(btnAction)) {
                url = INSERT;
            } else if ("Confirm Insert".equals(btnAction)) {
                url = CONFIRM_INSERT;
            } else if ("".equals(btnAction)) {
                url = HOME;
            } else if ("Product History".equals(btnAction)) {
                url = PRODUCT_HISTORY;
            } else if ("Add To Cart".equals(btnAction)) {
                url = ADD;
            } else if ("View".equals(btnAction)) {//
                url = VIEW_CART;
            } else if ("Remove".equals(btnAction)) {//
                url = REMOVE;
            } else if ("Edit".equals(btnAction)) {//
                url = EDIT;
            } else if ("Order".equals(btnAction)) {//
                url = ORDER;
            }else if ("Buying History".equals(btnAction)) {//
                url = BUYING_HISTORY;
            }

        } catch (Exception e) {
            log("ERROR At MainController: " + e.getMessage());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
            out.close();
        }
        // 404 -> url
        //500 -> jsp properties
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
