/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

import business.enumaration.EnumProductCategory;
import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 *
 * @author phatn
 */
@Entity
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    @Enumerated(EnumType.STRING)
    private EnumProductCategory category;
    private String description;
    private String color;
    private String size;
    private boolean active;
    private BigDecimal basePrice;
    private String imageUrl;
    private LocalDateTime createdAt;
    
    @OneToOne(mappedBy="product", cascade=CascadeType.ALL, orphanRemoval=true)
    private DiscountProduct discountProduct;

    public Product() {
    }

    public Product(int id, String name, EnumProductCategory category,
                   String description, String color, String size,
                   boolean active, BigDecimal basePrice,
                   String imageUrl, LocalDateTime createdAt) {

        this.id = id;
        this.name = name;
        this.category = category;
        this.description = description;
        this.color = color;
        this.size = size;
        this.active = active;
        this.basePrice = basePrice;
        this.imageUrl = imageUrl;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EnumProductCategory getCategory() {
        return category;
    }

    public void setCategory(EnumProductCategory category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public BigDecimal getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(BigDecimal basePrice) {
        this.basePrice = basePrice;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Product)) {
            return false;
        }

        Product other = (Product) object;

        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "entity.Product[ id=" + id + " ]";
    }
}