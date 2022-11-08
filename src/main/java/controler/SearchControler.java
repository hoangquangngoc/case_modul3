package controler;
import dao.CRUD_Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.Product;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/search")
public class SearchControler extends HttpServlet  {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String txtSearch = req.getParameter("txt");
        CRUD_Product crud_product = new CRUD_Product();
        List<Product> products = crud_product.searchByName(txtSearch);
        req.setAttribute("sanphams",products);
        req.getRequestDispatcher("home1.jsp").forward(req,resp);
    }
}
