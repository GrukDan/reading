package com.reading.csv.filterOptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TwoFieldFilterOptions {

    BY_TYPE_AND_BRAND("Цена в промежутке", 3,4),
    BY_TYPE_AND_NAME("Цена в промежутке", 3,2),
    BY_TYPE_AND_PRICE_IN_BETWEEN("Цена в промежутке", 3,7),
    BY_BRAND_AND_PRICE_IN_BETWEEN("Цена в промежутке", 4,7),
    BY_NAME_AND_PRICE_IN_BETWEEN("Цена в промежутке", 2,7);

    private final String filterOptionName;
    private final int firstFieldPosition;
    private final int secondFieldPosition;
}
