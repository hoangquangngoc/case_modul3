package model;

public class Product {
    private int idProduct;
    private String nameProduct;
    private String img;
    private double price;
    private String status;
    private int amount;

    public Product() {
    }

    public Product(int idProduct, String nameProduct, String img, double price , String status , int amount) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.img = img;
        this.price = price;
        this.status = status;
        this.amount= amount;
    }

    public Product(String nameProduct, String img, double price , String status , int amount) {
        this.nameProduct = nameProduct;
        this.img = img;
        this.price = price;
        this.status= status;
        this.amount = amount;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Product{" +
                "idProduct=" + idProduct +
                ", nameProduct='" + nameProduct + '\'' +
                ", img='" + img + '\'' +
                ", price=" + price +
                ", status='" + status + '\'' +
                ", amount=" + amount +
                '}';
    }
}
