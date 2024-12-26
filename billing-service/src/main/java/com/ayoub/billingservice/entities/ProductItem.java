package com.ayoub.billingservice.entities;

import com.ayoub.billingservice.entities.model.Product;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
public class ProductItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productId;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Bill bill;
    private int quantity;
    private double unitePrice;
    @Transient private Product product;//il segnifie que cette entite existe mais non pas dans la base de donne alors il va la ignorer(un objet n'est pas persistant)

    public ProductItem() {
    }

    public ProductItem(Long id, String productId, Bill bill, int quantity, double unitePrice, Product product) {
        this.id = id;
        this.productId = productId;
        this.bill = bill;
        this.quantity = quantity;
        this.unitePrice = unitePrice;
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitePrice() {
        return unitePrice;
    }

    public void setUnitePrice(double unitePrice) {
        this.unitePrice = unitePrice;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
