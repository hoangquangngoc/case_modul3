package controler;

import dao.CRUD_Product;
import dao.LoginDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;
import model.Account;

import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/login.jsp");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Account account = LoginDAO.Login(username,password);
        if (account != null){
            if (account.getId_role() ==1) {
                resp.sendRedirect("/products");
            }else {
                req.setAttribute("sanphams", CRUD_Product.getAll());
                RequestDispatcher dispatcher = req.getRequestDispatcher("/home1.jsp");
                dispatcher.forward(req,resp);
            }
        }else {
            resp.sendRedirect("/login");
        }
    }
}