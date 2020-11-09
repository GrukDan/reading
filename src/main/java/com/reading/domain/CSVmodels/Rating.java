package com.reading.domain.CSVmodels;

import com.opencsv.bean.CsvBindByPosition;
import lombok.Data;

@Data
public class Rating {

    @CsvBindByPosition(position = 8)
    private double rating;

    @CsvBindByPosition(position = 9)
    private int reviewsCount;

    @CsvBindByPosition(position = 10)
    private String featuredProducts;
}
