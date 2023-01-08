package com.cdutetc.pojo;

public class Brand {
    private Integer ID;
    private String imageURL;
    private String title;
    //原价
    private Double oPrice;
    //折扣价
    private Double disPrice;
    //购买数量
    private Integer amount;

    public Brand() {
    }



    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Brand(Integer ID, String imageURL, String title, Double oPrice, Double disPrice, Integer amount) {
        this.ID = ID;
        this.imageURL = imageURL;
        this.title = title;
        this.oPrice = oPrice;
        this.disPrice = disPrice;
        this.amount = amount;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getoPrice() {
        return oPrice;
    }

    public void setoPrice(Double oPrice) {
        this.oPrice = oPrice;
    }

    public Double getDisPrice() {
        return disPrice;
    }

    public void setDisPrice(Double disPrice) {
        this.disPrice = disPrice;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "ID='" + ID + '\'' +
                ", imageURL='" + imageURL + '\'' +
                ", title='" + title + '\'' +
                ", oPrice=" + oPrice +
                ", disPrice=" + disPrice +
                ", amount=" + amount +
                '}';
    }
}
