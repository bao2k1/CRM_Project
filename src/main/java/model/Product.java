package model;

public class Product {
    private String productName;
    private int soluong;
    private int giaban;

    public String getProductName() {
        return productName;
    }

    public int getSoluong() {
        return soluong;
    }

    public int getGiaban() {
        return giaban;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public void setGiaban(int giaban) {
        this.giaban = giaban;
    }
}
