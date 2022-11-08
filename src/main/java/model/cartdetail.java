package model;

public class cartdetail {
    private int id_sp;
   private String name;

    private double price;
    private int amount;

    public cartdetail() {
    }

    public cartdetail(int id_sp, String name,double price ,int amount) {
        this.id_sp = id_sp;
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public int getId_sp() {
        return id_sp;
    }

    public void setId_sp(int id_sp) {
        this.id_sp = id_sp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
