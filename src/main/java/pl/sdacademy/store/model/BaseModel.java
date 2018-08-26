package pl.sdacademy.store.model;

import lombok.Data;

import java.io.Serializable;

@Data
public abstract class BaseModel implements Serializable {
    private Long id;



}
