package dao;

import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CRUD_Product {
    static Connection connection = Connect_MySql.getConnect();

    public static List<Product> getAll(){
        String sql = "Select * from products";
        List<Product> products = new ArrayList<>();
        try {
            // tạo cái xe để đưa câu lệnh sql qua CSDL
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                int idProduct = resultSet.getInt("idProduct");
                String nameProduct = resultSet.getString("nameProduct");
                String img = resultSet.getString("img");
                double price = resultSet.getDouble("price");
                String status = resultSet.getString("status");
                int amount = resultSet.getInt("amount");
                products.add(new Product(idProduct,nameProduct,img, price,status,amount));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return products;
    }

    public static void save(Product product){
        try {
            String sql = "insert into products (idProduct,nameProduct, img, price,status,amount) value (?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, product.getIdProduct());
            preparedStatement.setString(2, product.getNameProduct());
            preparedStatement.setString(3, product.getImg());
            preparedStatement.setDouble(4,product.getPrice());
            preparedStatement.setString(5, product.getStatus());
            preparedStatement.setInt(6,product.getAmount());
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void delete(int idProduct){
        try {
            String sql = "delete from products where idProduct = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,idProduct);
            preparedStatement.execute();
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void edit(Product product){
        try{
            String sql = "update products set nameProduct = ? , img = ?, price = ? where idProduct = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, product.getNameProduct());
            preparedStatement.setString(2, product.getImg());
            preparedStatement.setDouble(3,product.getPrice());
            preparedStatement.setInt(4,product.getIdProduct());
            preparedStatement.execute();
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    public List<Product> searchByName(String txtSearch){
        List<Product> products = new ArrayList<>();
        String sql = "Select * from products where nameProduct like ?";

        try {
            Connection connection = Connect_MySql.getConnect();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,"%" +txtSearch +"%");
            ResultSet resultSet = preparedStatement.executeQuery();


            while (resultSet.next()){
                int idProduct = resultSet.getInt("idProduct");
                String nameProduct = resultSet.getString("nameProduct");
                String img = resultSet.getString("img");
                double price = resultSet.getDouble("price");
                String status = resultSet.getString("status");
                int amount = resultSet.getInt("amount");
                products.add(new Product(idProduct,nameProduct,img, price,status,amount));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return products;
    }
}