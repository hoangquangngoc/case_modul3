package model;

public class billdetail {
    private int id_sp;
    private int idBill;
    private int amount;
    private double totalprice;

    public billdetail() {
    }

    public billdetail(int id_sp, int idBill, int amount, double totalprice) {
        this.id_sp = id_sp;
        this.idBill = idBill;
        this.amount = amount;
        this.totalprice = totalprice;
    }

    public int getId_sp() {
        return id_sp;
    }

    public void setId_sp(int id_sp) {
        this.id_sp = id_sp;
    }

    public int getIdBill() {
        return idBill;
    }

    public void setIdBill(int idBill) {
        this.idBill = idBill;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(double totalprice) {
        this.totalprice = totalprice;
    }
}
