package jay.tdd_practice.product;


import lombok.Getter;

@Getter
public enum Membership {

    SILVER(0.02), GOLD(0.05), PLATINUM(0.10);

    private final double discount;

    Membership(double discount) {
        this.discount = discount;
    }

}
