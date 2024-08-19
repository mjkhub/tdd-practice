package jay.tdd_practice.calculator;

public class Calculator {

    public static int plus(int a, int b) {

        return a + b;
    }

    public static float divide(int a, int b) {

        if( b == 0 ) throw new IllegalArgumentException("divider is zero.");
        //1234
        return a /(float)b;

    }


}
