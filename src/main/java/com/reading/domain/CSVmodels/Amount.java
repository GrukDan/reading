package com.reading.domain.CSVmodels;

import com.opencsv.bean.CsvBindByPosition;
import lombok.Data;

@Data
public class Amount {

    @CsvBindByPosition(position = 11)
    private int ordersCount;

    @CsvBindByPosition(position = 12)
    private int purchasesCount;
}
