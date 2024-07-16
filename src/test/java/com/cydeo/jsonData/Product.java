package com.cydeo.jsonData;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private String available;
    private String productName;
    private String productId;
    private String teen;
    private String type;
    private String programId;
    private String programCode;
    private String programName;
    private String startDate;
    private String refundDate;
    private String externalUrl;
    private String terms;
    List<Price> prices;

}
