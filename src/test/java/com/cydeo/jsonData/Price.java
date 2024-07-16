package com.cydeo.jsonData;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Price {
    private boolean active;
    private int baseAmount;
    private String type;
    private boolean upfrontDiscount;
    private int upfrontDiscountAmount;
    private boolean allowCoupons;
    private int couponDiscount;
    private int numberOfInstallments;
}
