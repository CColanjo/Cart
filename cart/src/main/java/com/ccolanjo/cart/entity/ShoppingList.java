package com.ccolanjo.cart.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class ShoppingList {
    @Id @GeneratedValue
    private Long id;
    private Long productId;
    private String productName;
    private int quantity;
    private boolean removed;

    public ShoppingList(){}

    public ShoppingList(Long productId, String productName, int quantity, boolean removed) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.removed = removed;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isRemoved() {
        return removed;
    }

    public void setRemoved(boolean removed) {
        this.removed = removed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingList that = (ShoppingList) o;
        return quantity == that.quantity && removed == that.removed && Objects.equals(id, that.id) && Objects.equals(productId, that.productId) && Objects.equals(productName, that.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productId, productName, quantity, removed);
    }

    @Override
    public String toString() {
        return "ShoppingList{" +
                "id=" + id +
                ", productId=" + productId +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", removed=" + removed +
                '}';
    }
}
