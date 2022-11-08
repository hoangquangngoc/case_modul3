package controler;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Product;
import service.ProductService;

import java.io.IOException;

@WebServlet (urlPatterns = "/create")
public class CreateProductServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idProduct = Integer.parseInt(req.getParameter("idProduct"));
        String nameProduct = req.getParameter("nameProduct");
        String img = req.getParameter("img");
        double price = Double.parseDouble(req.getParameter("price"));
        String status = req.getParameter("status");
        int amount = Integer.parseInt(req.getParameter("amount"));
        ProductService.add(new Product(idProduct,nameProduct,img,price,status,amount));
        resp.sendRedirect("/products");
    }
}
