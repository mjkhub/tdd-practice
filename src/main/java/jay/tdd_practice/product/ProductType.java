package jay.tdd_practice.product;


import lombok.Getter;

@Getter
public enum ProductType {

    CLOTHES(0), ELECTRONIC(0.07), FOOD(0.03);

    private final double discount;

    ProductType(double discount) {
        this.discount = discount;
    }
}
