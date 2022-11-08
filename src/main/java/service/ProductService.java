package service;

import dao.CRUD_Product;
import model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
    public static List<Product>products = CRUD_Product.getAll();


    public static void add(Product product){
        CRUD_Product.save(product);
        products = CRUD_Product.getAll();
    }
    public static void edit(int idProduct , Product product){
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getIdProduct() == idProduct){
                products.set(i,product);
                CRUD_Product.edit(product);
            }

        }
    }
    public static void delete(int idProduct){
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getIdProduct() == idProduct){
                products.remove(i);
                CRUD_Product.delete(idProduct);
            }

        }

    }
}
