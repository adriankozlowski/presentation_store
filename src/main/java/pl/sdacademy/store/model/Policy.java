package pl.sdacademy.store.model;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class Policy extends BaseModel implements Serializable {
    private Long customerId;
    private Date date;
    private BigDecimal price;
    private Integer installmentsPerYear;
    private Date startDate;
    private Date endDate;
    private Boolean isAvailable;
}
