package com.reading.domain.CSVmodels;

import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvNumber;
import lombok.Data;

@Data
public class Price {

    @CsvBindByPosition(position = 5)
    @CsvNumber(value = "0000000000")
    private double oldPrice;

    @CsvBindByPosition(position = 6)
    @CsvNumber(value = "0000000000")
    private double promoPrice;

    @CsvBindByPosition(position = 7,required = true)
    @CsvNumber(value = "0000000000")
    private double price;
}
