package com.reading.csv.converters;

import com.opencsv.bean.AbstractBeanField;
import com.reading.domain.CSVmodels.Category;

import java.util.Arrays;

public class CategoryConverter extends AbstractBeanField {

    private final String selector = "/";

    @Override
    protected Object convert(String s){
        Category category = new Category();
        category.setCategories(Arrays.asList(s.split(selector)));
        return category;
    }
}
