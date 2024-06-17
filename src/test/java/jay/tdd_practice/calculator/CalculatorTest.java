package jay.tdd_practice.calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CalculatorTest {


    @Test
    public void 덧셈_예제() {
        int result1 = Calculator.plus(1,2);
        assertThat(result1).isEqualTo(3);

        int result2 = Calculator.plus(2,4);
        assertThat(result2).isEqualTo(6);
    }


    @Test
    public void 영으로_나누는() {

        assertThatThrownBy( () -> Calculator.divide(10,0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("divider is zero.");
    }

    @Test
    public void 나눗셈_나누어떨어지는() {

        float divide = Calculator.divide(4, 2);
        assertThat(divide).isEqualTo(2f);
    }

    @Test
    public void 나눗셈_나누어떨어지x() {

        float divide = Calculator.divide(5, 2);
        assertThat(divide).isEqualTo(2.5f);

    }


}