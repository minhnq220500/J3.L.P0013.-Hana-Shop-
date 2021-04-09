package minhnq.google.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import minhnq.daos.UserDAO;
import minhnq.dtos.UserDTO;

import stackjava.com.accessgoogle.common.GooglePojo;
import stackjava.com.accessgoogle.common.GoogleUtils;

@WebServlet("/login-google")
public class LoginGoogleServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public LoginGoogleServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String code = request.getParameter("code");

        if (code == null || code.isEmpty()) {
            RequestDispatcher dis = request.getRequestDispatcher("login.jsp");
            dis.forward(request, response);
        } else {
            HttpSession session = request.getSession();
            try {
                String accessToken = GoogleUtils.getToken(code);
                GooglePojo googlePojo = GoogleUtils.getUserInfo(accessToken);
//			request.setAttribute("id", googlePojo.getId());
//			request.setAttribute("name", googlePojo.getName());
//			request.setAttribute("email", googlePojo.getEmail());
                String email = googlePojo.getEmail();

                UserDAO dao = new UserDAO();
                UserDTO user = dao.getUserByEmail(email);

                if (user != null) {
                    session.setAttribute("LOGIN_USER", user);
                    
                    RequestDispatcher dis = request.getRequestDispatcher("HomeController");
                    dis.forward(request, response);
                } else {
                    RequestDispatcher dis = request.getRequestDispatcher("login.jsp");
                    dis.forward(request, response);
                }

            } catch (SQLException ex) {
                Logger.getLogger(LoginGoogleServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
