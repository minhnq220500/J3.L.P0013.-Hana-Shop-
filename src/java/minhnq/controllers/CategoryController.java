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
import minhnq.daos.ProductDAO;
import minhnq.dtos.CategoryDTO;
import minhnq.dtos.ProductDTO;

/**
 *
 * @author admin
 */
public class CategoryController extends HttpServlet {

    private final String SEARCH_CATE="home.jsp";
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
        String url=SEARCH_CATE;
        try {
            
            String indexString=request.getParameter("index");
            if(indexString==null){
                indexString="1";//nếu nó bị null thì mặc định sẽ đẩy ng dùng vào trang đầu tiên
            }
            int index=Integer.parseInt(indexString);
            
            String cateID=request.getParameter("categoryID");
            
            ProductDAO dao=new ProductDAO();
            List<ProductDTO> list=dao.getListProductByCategoryID(cateID,index);
            List<CategoryDTO> list_cate=dao.getListCategory();
            int numberPage=dao.getNumberPageSearchByCategory(cateID);
            
            if(list!=null){
                request.setAttribute("LIST_PRODUCT", list);
                request.setAttribute("LIST_CATE", list_cate);
                request.setAttribute("CATE_ID", cateID);
                
                request.setAttribute("NUMBER_PAGE", numberPage);
                request.setAttribute("INDEX", index);
                url=SEARCH_CATE;
            }
            
        }catch(Exception e){
            log("ERROR At CategoryController: " + e.getMessage());
        }finally{
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
