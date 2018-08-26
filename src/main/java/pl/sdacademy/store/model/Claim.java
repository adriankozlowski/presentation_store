package pl.sdacademy.store.model;

import lombok.Data;

import java.util.Date;

@Data
public class Claim extends BaseModel{

    private Date claimDate;
    private String description;
    private Boolean policeWasCalled;
    private String regNumber;
    private Long policyId;
    private Long claimantId;


}
