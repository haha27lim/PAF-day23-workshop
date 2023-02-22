package sg.edu.nus.iss.app.day23workshop.model;

import java.math.BigDecimal;
import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    
    private Integer orderId;
    private Date orderDate;
    private Integer customerId;
    private Float quantity;
    private Float unitPrice;
    private BigDecimal subTotal;
    private Double discount;
    private BigDecimal totalDiscountedPrice;
    private BigDecimal costPrice;

}
