package jay.tdd_practice.product;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


class ProductPriceCalculatorTest {
    private final ProductPriceCalculator productPriceCalculator = new ProductPriceCalculator();

    @Test
    public void 할인적용_x() {

        int price = 1000;
        float totalPrice = productPriceCalculator.calculatePrice(price);
        Assertions.assertThat(totalPrice).isEqualTo((float)price);
    }

    @Test
    public void 할인적용_10퍼센트() {

        ProductPriceCalculator productPriceCalculator = new ProductPriceCalculator();

        int price = 150_000;
        float totalPrice = productPriceCalculator.calculatePrice(price);
        Assertions.assertThat(totalPrice).isEqualTo( (float)(price * 0.9));

    }

    @Test
    public void 할인적용_15퍼센트() {

        ProductPriceCalculator productPriceCalculator = new ProductPriceCalculator();

        int price = 300_000;
        float totalPrice = productPriceCalculator.calculatePrice(price);
        Assertions.assertThat(totalPrice).isEqualTo( (float)(price * 0.85));

    }

    @Test
    public void 할인적용_20퍼센트() {

        ProductPriceCalculator productPriceCalculator = new ProductPriceCalculator();

        int price = 600_000;
        float totalPrice = productPriceCalculator.calculatePrice(price);
        Assertions.assertThat(totalPrice).isEqualTo( (float)(price * 0.80));

    }




}