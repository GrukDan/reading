package com.reading.services;

import com.reading.csv.filterOptions.SingleFieldFilterOptions;
import com.reading.csv.filterOptions.TwoFieldFilterOptions;
import com.reading.domain.CSVmodels.Product;

import java.util.Collection;

public interface ProductService {

    Collection<Product> getAllByFirstPosition(String firstPositionParam, SingleFieldFilterOptions options);

    Collection<Product> getAllByPriceInBetween(double minPrice, double maxPrice);

    Collection<Product> allowLineByFirstPositionAndPriceInBetween
            (String firstPositionParam,
             double minPrice,
             double maxPrice,
             TwoFieldFilterOptions options);

    Collection<Product> allowLineByFirstPositionAndSecondPosition
            (String firstPositionParam,
             String secondPositionParam,
             TwoFieldFilterOptions options);
}
