package model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
public class CartPageModel {
    private String poNumber;
    private String jobName;
    private String shipTerms;
    private String carrier;
    private String shippingOption;

}
