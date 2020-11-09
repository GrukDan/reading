package com.reading.csv.filterOptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SingleFieldFilterOptions {

    BY_CODE("Код", 0),
    BY_CATEGORY("Категория", 1),
    BY_NAME("Название", 2),
    BY_TYPE("Тип", 3),
    BY_BRAND("Бренд", 4),
    BY_OLD_PRICE("Старая цена", 5),
    BY_PROMO_PRICE("Цена по промокоду", 6),
    BY_PRICE("Цена", 7),
    BY_RATING("Рейтинг", 8),
    BY_REVIEWS_COUNT("Количество отзывов", 9),
    BY_FEATURED_PRODUCTS("Рекомендованные товары", 10),
    BY_ORDERS_COUNT("Количество заказов", 11),
    BY_PURCHASES_COUNT("Количество покупок", 12),
    BY_UPDATE_DATE("Дата обновления", 15),

    BY_PRICE_IN_BETWEEN("Цена в промежутке", 7);

    private final String filterOptionName;
    private final int positionNumber;
}
