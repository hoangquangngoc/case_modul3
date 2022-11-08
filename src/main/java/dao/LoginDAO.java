package dao;

import model.Account;

import java.sql.*;

public class LoginDAO {

    public static Account Login(String username, String password) {
        try {
            String sql = "select * from account where username = ? and password =?";
            Connection connection = Connect_MySql.getConnect();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            ResultSet resultSet = preparedStatement.executeQuery();
            Account account = null;
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username1 = resultSet.getString("username");
                String password1 = resultSet.getString("password");
                String address = resultSet.getString("address");
                Date birthday = resultSet.getDate("birthday");
                int id_role = resultSet.getInt("id_role");
                account = new Account(id, username1, password1, address, birthday, id_role);
            }
            return account;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public Account checkAccount(String username){
        String sql = "select * from account where username = ?";
        try {
    Connection connection = Connect_MySql.getConnect();
    PreparedStatement preparedStatement = connection.prepareStatement(sql);
    preparedStatement.setString(1,username);
            ResultSet resultSet = preparedStatement.executeQuery();
            Account account = null;
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username1 = resultSet.getString("username");
                String password1 = resultSet.getString("password");
                String address = resultSet.getString("address");
                Date birthday = resultSet.getDate("birthday");
                int id_role = resultSet.getInt("id_role");
                account = new Account(id, username1, password1, address, birthday, id_role);
            }
            return account;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void register(String username , String password1 , int id_role , String address, String birthday){

        try {
            String sql = "insert into account(username , password , id_role , address,birthday) value(?,?,?,?,?)";
            Connection connection = Connect_MySql.getConnect();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password1);
            preparedStatement.setInt(3,id_role);
            preparedStatement.setString(4,address);
            preparedStatement.setString(5,birthday);
            preparedStatement.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

