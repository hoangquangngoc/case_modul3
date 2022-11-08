package controler;

import com.sun.tools.attach.VirtualMachine;
import dao.CRUD_Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Product;
import model.cartdetail;

import jakarta.servlet.RequestDispatcher;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.FileStore;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/Addcart")
public class Addcart extends HttpServlet {
    List<Product> products = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        products = new ArrayList<>();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        List<Product> products = (List<Product>) session.getAttribute("products");
        if (products == null) products = new ArrayList<>();
        String action = req.getParameter("action");
        int idProduct = Integer.parseInt(req.getParameter("idProduct"));
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "delete":
                for (int i = 0; i < products.size(); i++) {
                    if (products.get(i).getIdProduct() == idProduct) {
                        products.remove(i);
                        break;
                    }
                }
                showCart(products, req, resp);

                break;
            default:
                Product sp = findById(Integer.parseInt(String.valueOf(idProduct)), CRUD_Product.getAll());
                if (sp != null) {
                    products.add(sp);
                }
                showCart(products, req, resp);
        }
    }

    public void showCart(List<Product> products, HttpServletRequest req, HttpServletResponse resp) {
        List<cartdetail> cartdetails = new ArrayList<>();
        for (int i = 0; i < products.size(); i++) {
            boolean check = false;
            for (cartdetail ca : cartdetails) {
                if (products.get(i).getIdProduct() == ca.getId_sp()) {
                    ca.setAmount(ca.getAmount() + 1);
                    check = true;
                    break;
                }
            }
            if (check == false) {
                cartdetails.add(new cartdetail(products.get(i).getIdProduct(), products.get(i).getNameProduct(), products.get(i).getPrice(), 1));
            }
        }
        HttpSession session = req.getSession();
        session.setAttribute("products", products);
        req.setAttribute("carts", cartdetails);
        double sum = 0;
        for (Product p : products) {
            sum += p.getPrice();
        }
        req.setAttribute("total", sum);
        RequestDispatcher dispatcher1 = req.getRequestDispatcher("viewcart.jsp");
        try {
            dispatcher1.forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Product findById(int idProduct, List<Product> list) {
        Product result = null;
        for (Product sp : list) {
            if (sp.getIdProduct() == idProduct) {
                result = sp;
                break;
            }
        }
        return result;
    }

    public double getToTal() {
        double sum = 0;
        for (Product p : products) {
            sum += p.getPrice();
        }
        return sum;
    }
}
