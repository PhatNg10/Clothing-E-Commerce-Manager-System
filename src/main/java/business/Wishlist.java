/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author phatn
 */
@Entity
public class Wishlist implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToMany
    private List<Product> items = new ArrayList<>();

    @OneToOne
    @JoinColumn(name="customer_id", nullable=false, unique=true)
    private Customer customer;
    
    public Wishlist() {
    }

    public Wishlist(int id, List<Product> items) {
        this.id = id;
        this.items = items;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Product> getItems() {
        return items;
    }

    public void setItems(List<Product> items) {
        this.items = items;
    }

    @Override
    public int hashCode() {
        return (int) id;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Wishlist)) {
            return false;
        }

        Wishlist other = (Wishlist) object;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "entity.Wishlist[ id=" + id + " ]";
    }
}