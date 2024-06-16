package jay.tdd_practice.product;


import lombok.Getter;

@Getter
public enum Membership {

    SILVER(2), GOLD(5), PLATINUM(10);

    private int discount;

    Membership(int discount) {
        this.discount = discount;
    }

}
