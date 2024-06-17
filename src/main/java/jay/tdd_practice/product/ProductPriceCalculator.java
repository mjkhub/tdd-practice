package jay.tdd_practice.product;

import java.util.ArrayList;
import java.util.List;

public class ProductPriceCalculator {

    public double calculatePrice(PriceCalculateRequest priceCalculateRequest) {

        double price = priceCalculateRequest.getPrice();
        if(100_000<=price && price < 200_000) price *= 0.9;
        else if(200_000<=price && price < 500_000) price *= 0.85;
        else if(500_000 < price ) price *= 0.8;

        double maxAdditionalDiscount = findMaxAdditionalDiscount(priceCalculateRequest);
        price *= (1.0-maxAdditionalDiscount);

        return Math.ceil(price);
    }


    private double findMaxAdditionalDiscount(PriceCalculateRequest priceCalculateRequest){

        Membership membership = priceCalculateRequest.getMembership();
        ProductType productType = priceCalculateRequest.getProductType();

        List<Double> discounts = new ArrayList<>();
        discounts.add(0.0);
        if(membership != null) discounts.add(membership.getDiscount());
        if(productType != null) discounts.add(productType.getDiscount());

        discounts.sort((a,b) -> b.compareTo(a)); // 내림차순


        return discounts.get(0);
    }


}
