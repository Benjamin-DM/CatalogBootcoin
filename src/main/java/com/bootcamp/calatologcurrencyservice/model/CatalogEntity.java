package com.bootcamp.calatologcurrencyservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "CatalogCurrency")
@ToString
public class CatalogEntity implements Serializable{
    @Id
    private String id;
    //Moneda al que se va cambiar
    private String currencyName;
    //Moneda origen
    private String currencyReference;
    private Double amountBuy;
    private Double amountSale;
    @CreatedDate
    //@DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate createDate;
}
