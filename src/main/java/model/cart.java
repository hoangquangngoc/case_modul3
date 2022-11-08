package model;

import java.sql.Date;

public class cart {
    private int id;
    private int id_sp ;
    private Date datecart;
    private double pricetotal;



    public cart(int id, int id_sp, Date datecart, double pricetotal) {
        this.id = id;
        this.id_sp = id_sp;
        this.datecart = datecart;
        this.pricetotal = pricetotal;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_sp() {
        return id_sp;
    }

    public void setId_sp(int id_sp) {
        this.id_sp = id_sp;
    }

    public Date getDatecart() {
        return datecart;
    }

    public void setDatecart(Date datecart) {
        this.datecart = datecart;
    }

    public double getPricetotal() {
        return pricetotal;
    }

    public void setPricetotal(double pricetotal) {
        this.pricetotal = pricetotal;
    }

}
