package jay.tdd_practice.product;

public class ProductPriceCalculator {

    public float calculatePrice(int price) {

        if(100_000<=price && price < 200_000) return (float) (price * 0.9);
        else if(200_000<=price && price < 500_000) return (float) (price * 0.85);
        else if(500_000 < price ) return (float) (price * 0.8);

        return (float) (price * 1.0);
    }


}
