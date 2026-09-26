/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

import jakarta.persistence.*;
import java.io.Serializable;

/**
 *
 * @author phatn
 */
@Entity
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String province;
    private String district;
    private String ward;
    private Boolean isDefault;
    @ManyToOne
    @JoinColumn(name="customer_id", nullable=false)
    private Customer customer;

    public Address() {
    }

    public Address(int id, String province, String district,
                   String ward, Boolean isDefault) {
        this.id = id;
        this.province = province;
        this.district = district;
        this.ward = ward;
        this.isDefault = isDefault;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public Boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Address)) {
            return false;
        }

        Address other = (Address) object;

        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "entity.Address[ id=" + id + " ]";
    }
}
