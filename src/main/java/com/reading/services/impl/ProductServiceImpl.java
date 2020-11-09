package com.reading.services.impl;

import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.CsvToBeanFilter;
import com.reading.csv.filterOptions.SingleFieldFilterOptions;
import com.reading.csv.filterOptions.TwoFieldFilterOptions;
import com.reading.domain.CSVmodels.Product;
import com.reading.csv.filters.ProductFilter;
import com.reading.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final static String path = "src/main/resources/csv/lamoda_full.csv";
    private final char valueSeparator = ';';
    private final char valueQuote = '"';

    @Override
    public Collection<Product> getAllByFirstPosition(String firstPositionParam, SingleFieldFilterOptions options) {
        return collect(ProductFilter.builder()
                .filterParams(new String[]{firstPositionParam})
                .singleFieldFilterOptions(options)
                .build());
    }

    @Override
    public Collection<Product> getAllByPriceInBetween(double minPrice, double maxPrice) {
        return collect(ProductFilter.builder()
                .minPrice(minPrice)
                .maxPrice(maxPrice)
                .singleFieldFilterOptions(SingleFieldFilterOptions.BY_PRICE_IN_BETWEEN)
                .build());
    }

    @Override
    public Collection<Product> allowLineByFirstPositionAndPriceInBetween(
            String firstPositionParam,
             double minPrice,
             double maxPrice,
             TwoFieldFilterOptions options) {
        return  collect(ProductFilter.builder()
                .filterParams(new String[]{firstPositionParam})
                .minPrice(minPrice)
                .maxPrice(maxPrice)
                .twoFieldFilterOptions(options)
                .build());
    }

    @Override
    public Collection<Product> allowLineByFirstPositionAndSecondPosition(
            String firstPositionParam,
            String secondPositionParam,
            TwoFieldFilterOptions options) {
        return collect(ProductFilter.builder()
                .filterParams(new String[]{firstPositionParam,secondPositionParam})
                .twoFieldFilterOptions(options)
                .build());
    }

    private List<Product> collect(CsvToBeanFilter filter) {
        try {
            return new CsvToBeanBuilder<Product>(new FileReader(path))
                    .withSeparator(this.valueSeparator)
                    .withQuoteChar(this.valueQuote)
                    .withSkipLines(1)
                    .withType(Product.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withFilter(filter)
                    .build()
                    .parse();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
