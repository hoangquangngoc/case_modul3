package controler;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Product;
import service.ProductService;

import java.io.IOException;

@WebServlet(urlPatterns = "/edit")
public class EditProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       int idProduct = Integer.parseInt(req.getParameter("idProduct"));
        for (Product p: ProductService.products) {
         if (p.getIdProduct() ==idProduct){
             req.setAttribute("p",p);
         }
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("/editProduct.jsp");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idProduct = Integer.parseInt(req.getParameter("idProduct"));
        String nameProduct = req.getParameter("nameProduct");
        String img = req.getParameter("img");
        double price = Double.parseDouble(req.getParameter("price"));
        String status = req.getParameter("status");
        int amount = Integer.parseInt(req.getParameter("amount"));
        ProductService.edit(idProduct,new Product(idProduct , nameProduct,img,price,status,amount));
        resp.sendRedirect("/products");

    }
}
