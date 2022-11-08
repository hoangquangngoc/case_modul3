package model;

import java.util.Date;

public class bill {
    private int id;
    private int id_account;
    private double totalprice;
    private Date datebill;

    public bill() {
    }

    public bill(int id, int id_account, double totalprice, Date datebill) {
        this.id = id;
        this.id_account = id_account;
        this.totalprice = totalprice;
        this.datebill = datebill;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_account() {
        return id_account;
    }

    public void setId_account(int id_account) {
        this.id_account = id_account;
    }

    public double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(double totalprice) {
        this.totalprice = totalprice;
    }

    public Date getDatebill() {
        return datebill;
    }

    public void setDatebill(Date datebill) {
        this.datebill = datebill;
    }
}
