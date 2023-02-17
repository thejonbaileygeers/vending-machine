package com.techelevator.VendingMachine;

import java.math.BigDecimal;

public class Purchasables {
    // Product

    private String selectNumber;
    private String name;
    private BigDecimal price;
    private String type;

    public String getSelectNumber() {return selectNumber; }

    public String getName() { return name; }

    public BigDecimal getPrice() { return price; }

    public String getType() { return type; }


  public Purchasables(String selectNumber, String name, BigDecimal price, String type) {
       this.selectNumber = selectNumber;
        this.name = name;
        this.price = price;
        this.type = type;

    }


}

