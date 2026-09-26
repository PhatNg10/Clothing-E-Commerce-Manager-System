/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

import business.enumaration.EnumCustomerLevel;
import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author phatn
 */
@Entity
public class Customer extends User implements Serializable {

    private static final long serialVersionUID = 1L;

    private LocalDateTime createdAt;
    @Enumerated(EnumType.STRING)
    private EnumCustomerLevel customerLevel;
    @OneToMany (mappedBy="customer", cascade=CascadeType.ALL, orphanRemoval=true)
    private List<Address> address = new ArrayList<>();
    
    @OneToOne(mappedBy="customer", cascade=CascadeType.ALL, orphanRemoval=true)
    private Wishlist wishlist;
    
    public Customer() {
    }

    public Customer(int id, String userName, String passName,
                    String fullName, String gender, java.time.LocalDate dob,
                    String email, String phone, String address,
                    String avatarURL, LocalDateTime createdAt,
                    EnumCustomerLevel customerLevel,
                    List<Address> addresses) {

        super(id, userName, passName, fullName, gender, dob,
              email, phone, avatarURL);

        this.createdAt = createdAt;
        this.customerLevel = customerLevel;
        this.address = addresses;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public EnumCustomerLevel getCustomerLevel() {
        return customerLevel;
    }

    public void setCustomerLevel(EnumCustomerLevel customerLevel) {
        this.customerLevel = customerLevel;
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }
}