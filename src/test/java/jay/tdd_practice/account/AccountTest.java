package jay.tdd_practice.account;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class AccountTest {

    @Test
    public void 정상이체() {

        //given
        Account source = Account.builder()
                .money(1000)
                .accountNumber("1111")
                .build();

        Account target = Account.builder()
                .money(10000)
                .accountNumber("1112")
                .build();

        //when
        int moneyAfterTransfer = source.transferMoney(500, target);

        Assertions.assertThat(source.getMoney()).isEqualTo(500);
        Assertions.assertThat(target.getMoney()).isEqualTo(10500);

    }

    @Test
    public void 이체_예외_발생_돈이_부족() {

        //given
        Account source = Account.builder()
                .money(1000)
                .accountNumber("1111")
                .build();

        Account target = Account.builder()
                .money(10000)
                .accountNumber("1112")
                .build();

        //when
        assertThatThrownBy( () -> source.transferMoney(2000, target) )
                .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("Not enough money");

        //then
        Assertions.assertThat(source.getMoney()).isEqualTo(1000);
        Assertions.assertThat(target.getMoney()).isEqualTo(10000);

    }



}