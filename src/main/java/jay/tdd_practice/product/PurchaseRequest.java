package jay.tdd_practice.product;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PurchaseRequest {


    private final Product product;
    private final int purchaseNumber;
    private final Membership membership;

}
