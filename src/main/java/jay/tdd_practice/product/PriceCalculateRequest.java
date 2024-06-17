package jay.tdd_practice.product;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PriceCalculateRequest {

    private int price;
    private ProductType productType;
    private Membership membership;

}
