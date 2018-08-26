package pl.sdacademy.store.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Customer extends BaseModel implements Serializable {
    private String name;
    private String surname;
    private String documentNo;
    private String telephone;

}
