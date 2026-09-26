/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

import business.enumaration.EnumEmployeeRole;
import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author phatn
 */
@Entity
public class Employee extends User implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private LocalDate hireDate;
    private boolean active;
    @Enumerated(EnumType.STRING)
    private EnumEmployeeRole role;

    public Employee() {
    }

    public Employee(LocalDate hireDate, boolean active, EnumEmployeeRole role, int id, String userName, String passName, String fullName, String gender, LocalDate dob, String email, String phone, String address, String avatarURL) {
        super(id, userName, passName, fullName, gender, dob, email, phone, avatarURL);
        this.hireDate = hireDate;
        this.active = active;
        this.role = role;
    }
     
    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public EnumEmployeeRole getRole() {
        return role;
    }

    public void setRole(EnumEmployeeRole role) {
        this.role = role;
    }
}
