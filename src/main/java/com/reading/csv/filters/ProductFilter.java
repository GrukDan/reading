package com.reading.csv.filters;

import com.opencsv.bean.CsvToBeanFilter;
import com.reading.csv.filterOptions.SingleFieldFilterOptions;
import com.reading.csv.filterOptions.TwoFieldFilterOptions;
import com.reading.exeptions.ServiceException;
import lombok.Builder;

@Builder
public class ProductFilter implements CsvToBeanFilter {

    private String[] filterParams;
    private double minPrice;
    private double maxPrice;
    private SingleFieldFilterOptions singleFieldFilterOptions;
    private TwoFieldFilterOptions twoFieldFilterOptions;

    @Override
    public boolean allowLine(String[] strings) {
        if(singleFieldFilterOptions!=null) {
            try {
                return singleFieldAllowLine(strings);
            } catch (ServiceException e) {
                e.printStackTrace();
            }
        }
        if(twoFieldFilterOptions!=null) {
            try {
                return twoFieldAllowLine(strings);
            } catch (ServiceException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    private boolean singleFieldAllowLine(String[] strings) throws ServiceException {
        switch (singleFieldFilterOptions) {
            case BY_NAME:
            case BY_TYPE:
            case BY_BRAND:
                return allowLineByPosition(strings, singleFieldFilterOptions.getPositionNumber());
            case BY_PRICE_IN_BETWEEN:
                return allowLineByPriceInBetween(strings, singleFieldFilterOptions.getPositionNumber());
            default:
                return false;
        }
    }

    private boolean twoFieldAllowLine(String[] strings) throws ServiceException {
        switch (twoFieldFilterOptions) {
            case BY_TYPE_AND_NAME:
            case BY_TYPE_AND_BRAND:
                return allowLineByTwoPosition(
                        strings,
                        twoFieldFilterOptions.getFirstFieldPosition(),
                        twoFieldFilterOptions.getSecondFieldPosition());
            case BY_TYPE_AND_PRICE_IN_BETWEEN:
            case BY_NAME_AND_PRICE_IN_BETWEEN:
            case BY_BRAND_AND_PRICE_IN_BETWEEN:
                return allowLineByFirstPositionAndPriceInBetween(
                        strings,
                        twoFieldFilterOptions.getFirstFieldPosition(),
                        twoFieldFilterOptions.getSecondFieldPosition());
            default:
                return false;
        }
    }

    private boolean allowLineByPosition(String[] strings,int positionNumber) throws ServiceException {
        if(filterParams.length == 0) throw new ServiceException();
        return strings[positionNumber].equalsIgnoreCase(filterParams[0]);
    }

    private boolean allowLineByPriceInBetween(String[] strings,int positionNumber) {
        double actualPrice = Double.parseDouble(strings[positionNumber].replace(',','.'));
        return actualPrice >= minPrice && actualPrice <= maxPrice;
    }

    private boolean allowLineByTwoPosition(String[] strings,int firstPosition, int secondPosition){
        return strings[firstPosition].equalsIgnoreCase(filterParams[0])
                && strings[secondPosition].equalsIgnoreCase(filterParams[1]);
    }

    private boolean allowLineByFirstPositionAndPriceInBetween(String[] strings,int firstFieldPosition,int secondFieldPosition)
            throws ServiceException {
        return allowLineByPosition(strings,firstFieldPosition)
                && allowLineByPriceInBetween(strings,secondFieldPosition);
    }

}
