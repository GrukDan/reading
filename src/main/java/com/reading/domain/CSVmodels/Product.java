package com.reading.domain.CSVmodels;


import com.opencsv.bean.*;
import com.reading.csv.converters.CategoryConverter;
import lombok.*;

import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @CsvBindByPosition(position = 0,required = true)
    private String code;

    @CsvCustomBindByPosition(position = 1, converter = CategoryConverter.class)
    private Category category;

    @CsvRecurse
    private Goods goods;

    @CsvRecurse
    private Price price;

    @CsvRecurse
    private Rating rating;

    @CsvRecurse
    private Amount amount;

    @CsvBindByPosition(position = 13)
    private String productLink;

    @CsvBindByPosition(position = 14)
    private String photo;

    @CsvBindByPosition(position = 15)
    @CsvDate(value = "dd.mm.yyyy hh:mm")
    private Date updateDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return code.equals(product.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Product{");
        sb.append("amount=").append(amount);
        sb.append(", category=").append(category);
        sb.append(", code='").append(code).append('\'');
        sb.append(", goods=").append(goods);
        sb.append(", photo='").append(photo).append('\'');
        sb.append(", price=").append(price);
        sb.append(", productLink='").append(productLink).append('\'');
        sb.append(", rating=").append(rating);
        sb.append(", updateDate=").append(updateDate);
        sb.append('}');
        return sb.toString();
    }

}
