package com.reading.domain.CSVmodels;

import com.opencsv.bean.CsvBindByPosition;
import lombok.Data;

@Data
public class Goods {

    @CsvBindByPosition(position = 2,required = true)
    private String name;

    @CsvBindByPosition(position = 3,required = true)
    private String type;

    @CsvBindByPosition(position = 4,required = true)
    private String brand;
}
