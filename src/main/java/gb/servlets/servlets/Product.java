package gb.servlets.servlets;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class Product {
    private long id;
    private String title;
    private BigDecimal cost;
}
