package jay.tdd_practice.product;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Product {

    private ProductType productType;
    private String name;
    private int price;



}
