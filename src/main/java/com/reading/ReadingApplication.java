package com.reading;

import com.reading.csv.filterOptions.SingleFieldFilterOptions;
import com.reading.csv.filterOptions.TwoFieldFilterOptions;
import com.reading.services.impl.ProductServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReadingApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReadingApplication.class, args);
        ProductServiceImpl productService = new ProductServiceImpl();

        System.out.println(productService.getAllByFirstPosition("Худи", SingleFieldFilterOptions.BY_TYPE));
        System.out.println("========================================================================================");
        System.out.println(productService.getAllByFirstPosition("Aarhon Джинсы", SingleFieldFilterOptions.BY_NAME));
        System.out.println("========================================================================================");
        System.out.println(productService.getAllByFirstPosition("Befree", SingleFieldFilterOptions.BY_BRAND));
        System.out.println("========================================================================================");

        System.out.println(productService.getAllByPriceInBetween(3350,4440));
        System.out.println("========================================================================================");

        System.out.println(productService.allowLineByFirstPositionAndPriceInBetween("Худи",3350,4440,TwoFieldFilterOptions.BY_TYPE_AND_PRICE_IN_BETWEEN));
        System.out.println("========================================================================================");

        System.out.println(productService.allowLineByFirstPositionAndSecondPosition("Футболка","Tezenis",TwoFieldFilterOptions.BY_TYPE_AND_BRAND));
        System.out.println("========================================================================================");

        System.out.println(productService.allowLineByFirstPositionAndSecondPosition("Костюм спортивный","Aarhon Костюм спортивный",TwoFieldFilterOptions.BY_TYPE_AND_NAME));
        System.out.println("========================================================================================");
    }

}
