/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

import business.enumaration.EnumCustomerLevel;
import business.enumaration.EnumDiscountType;
import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 *
 * @author phatn
 */
@Entity
public class Voucher implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String code;

    @Enumerated(EnumType.STRING)
    private EnumCustomerLevel applicableCustomerTier;

    @Enumerated(EnumType.STRING)
    private EnumDiscountType discountType;

    private BigDecimal discountValue;
    private BigDecimal minOrderValue;
    private BigDecimal maxDiscount;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private int usageLimit;
    private int usedCount;
    private boolean active;

    public Voucher() {
    }

    public Voucher(String code, EnumCustomerLevel applicableCustomerTier,
                   EnumDiscountType discountType, BigDecimal discountValue,
                   BigDecimal minOrderValue, BigDecimal maxDiscount,
                   LocalDateTime startDate, LocalDateTime endDate,
                   int usageLimit, int usedCount, boolean active) {

        this.code = code;
        this.applicableCustomerTier = applicableCustomerTier;
        this.discountType = discountType;
        this.discountValue = discountValue;
        this.minOrderValue = minOrderValue;
        this.maxDiscount = maxDiscount;
        this.startDate = startDate;
        this.endDate = endDate;
        this.usageLimit = usageLimit;
        this.usedCount = usedCount;
        this.active = active;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public EnumCustomerLevel getApplicableCustomerTier() {
        return applicableCustomerTier;
    }

    public void setApplicableCustomerTier(EnumCustomerLevel applicableCustomerTier) {
        this.applicableCustomerTier = applicableCustomerTier;
    }

    public EnumDiscountType getDiscountType() {
        return discountType;
    }

    public void setDiscountType(EnumDiscountType discountType) {
        this.discountType = discountType;
    }

    public BigDecimal getDiscountValue() {
        return discountValue;
    }

    public void setDiscountValue(BigDecimal discountValue) {
        this.discountValue = discountValue;
    }

    public BigDecimal getMinOrderValue() {
        return minOrderValue;
    }

    public void setMinOrderValue(BigDecimal minOrderValue) {
        this.minOrderValue = minOrderValue;
    }

    public BigDecimal getMaxDiscount() {
        return maxDiscount;
    }

    public void setMaxDiscount(BigDecimal maxDiscount) {
        this.maxDiscount = maxDiscount;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public int getUsageLimit() {
        return usageLimit;
    }

    public void setUsageLimit(int usageLimit) {
        this.usageLimit = usageLimit;
    }

    public int getUsedCount() {
        return usedCount;
    }

    public void setUsedCount(int usedCount) {
        this.usedCount = usedCount;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}