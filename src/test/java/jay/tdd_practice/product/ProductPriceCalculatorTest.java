package jay.tdd_practice.product;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class ProductPriceCalculatorTest {

    private final ProductPriceCalculator productPriceCalculator = new ProductPriceCalculator();

    @Test
    public void 할인적용_x() {

        PriceCalculateRequest priceCalculateRequest = mock(PriceCalculateRequest.class);
        when(priceCalculateRequest.getPrice()).thenReturn(1000);

        double totalPrice = productPriceCalculator.calculatePrice(priceCalculateRequest);

        Assertions.assertThat(totalPrice).isEqualTo(1000 * 1.0);
    }

    @Test
    public void 할인적용_10퍼센트() {

        PriceCalculateRequest priceCalculateRequest = mock(PriceCalculateRequest.class);
        when(priceCalculateRequest.getPrice()).thenReturn(150_000);

        double totalPrice = productPriceCalculator.calculatePrice(priceCalculateRequest);

        Assertions.assertThat(totalPrice).isEqualTo( 150_000 * 0.9);

    }

    @Test
    public void 할인적용_15퍼센트() {
        PriceCalculateRequest priceCalculateRequest = mock(PriceCalculateRequest.class);
        when(priceCalculateRequest.getPrice()).thenReturn(300_000);

        double totalPrice = productPriceCalculator.calculatePrice(priceCalculateRequest);

        Assertions.assertThat(totalPrice).isEqualTo( 300_000 * 0.85);

    }

    @Test
    public void 할인적용_20퍼센트() {

        PriceCalculateRequest priceCalculateRequest = mock(PriceCalculateRequest.class);
        when(priceCalculateRequest.getPrice()).thenReturn(600_000);

        double totalPrice = productPriceCalculator.calculatePrice(priceCalculateRequest);

        Assertions.assertThat(totalPrice).isEqualTo(600_000 * 0.80);

    }

    @Test
    public void 기본할인15퍼_회원할인_골드_5퍼() {

        //given
        PriceCalculateRequest priceCalculateRequest = mock(PriceCalculateRequest.class);
        when(priceCalculateRequest.getPrice()).thenReturn(300_000);
        when(priceCalculateRequest.getMembership()).thenReturn(Membership.GOLD);

        //when
        double totalPrice = productPriceCalculator.calculatePrice(priceCalculateRequest);

        //then
        Assertions.assertThat(totalPrice).isEqualTo( 300_000 * 0.85 * 0.95);

    }

    @Test
    public void 기본할인15퍼_회원할인_골드_5퍼_전자제품_7퍼할인() {

        //given
        PriceCalculateRequest priceCalculateRequest = mock(PriceCalculateRequest.class);
        when(priceCalculateRequest.getPrice()).thenReturn(300_000);
        when(priceCalculateRequest.getMembership()).thenReturn(Membership.GOLD);
        when(priceCalculateRequest.getProductType()).thenReturn(ProductType.ELECTRONIC);

        //when
        double totalPrice = productPriceCalculator.calculatePrice(priceCalculateRequest);

        //then
        Assertions.assertThat(totalPrice).isEqualTo(300_000 * 0.85 * 0.93);

    }


    @Test
    public void 기본할인15퍼_회원할인_골드_5퍼_음식_3퍼할인() {

        //given
        PriceCalculateRequest priceCalculateRequest = mock(PriceCalculateRequest.class);
        when(priceCalculateRequest.getPrice()).thenReturn(300_000);
        when(priceCalculateRequest.getMembership()).thenReturn(Membership.GOLD);
        when(priceCalculateRequest.getProductType()).thenReturn(ProductType.FOOD);

        //when
        double totalPrice = productPriceCalculator.calculatePrice(priceCalculateRequest);

        //then
        Assertions.assertThat(totalPrice).isEqualTo(300_000 * 0.85 * 0.95);

    }


}