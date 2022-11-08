package controler;

import dao.LoginDAO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;
import model.Account;

import java.io.IOException;

@WebServlet(urlPatterns = "/register")
public class registerServlet extends HttpServlet  {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/register.jsp");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password1 = req.getParameter("password1");
        String repass = req.getParameter("repass");
        String email = req.getParameter("email");
        int id_role = Integer.parseInt(req.getParameter("id_role"));
        String address = req.getParameter("address");
        String birthday = req.getParameter("birthday");
        if (!password1.equals(repass)){
            resp.sendRedirect("login.jsp");
        }else {
            LoginDAO loginDAO = new LoginDAO();
           Account a = loginDAO.checkAccount(username);
           if (a == null){
            loginDAO.register(username,password1, id_role,address,birthday);
            resp.sendRedirect("products");
           }else {
               resp.sendRedirect("login.jsp");
           }
        }
    }
}
