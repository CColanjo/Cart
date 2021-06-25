package com.ccolanjo.cart.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Cart {
    private @Id
    @GeneratedValue
    int id;
    private int productId;
    private String productName;

    public Cart(){}

    public Cart(int productId, String productName) {
        this.productId = productId;
        this.productName = productName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return Objects.equals(id, cart.id) && Objects.equals(productId, cart.productId) && Objects.equals(productName, cart.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productId);
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", productId=" + productId +
                ", productName='" + productName + '\'' +
                '}';
    }
}
