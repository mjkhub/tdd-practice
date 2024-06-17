package jay.tdd_practice.email;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


class EmailValidatorTest {

    private final EmailValidator emailValidator = new EmailValidator();

    private void assertEmail(String email, boolean result){
        Assertions.assertThat(emailValidator.validateEmail(email)).isEqualTo(result);

    }
    @Test
    public void 정상적인_이메일(){
        assertEmail("rlaakswo0687@gmail.com", true);
    }

    @Test
    public void 널_빈문자열_공백인경우(){
        assertEmail(null, false);
        assertEmail("", false);
        assertEmail("   ", false);
    }

    @Test
    public void 공백_포함(){
        assertEmail("  rlaakswo0687   @gmail.com", false);
    }


    @Test
    public void 골뱅이_기호_0개_2개이상(){
        assertEmail("rlaakswo0687gmail.com", false);
        assertEmail("rlaakswo0687@@gmail.com", false);
        assertEmail("rlaakswo0687@@@@@gmail.com", false);
    }

    @Test
    public void 로컬파트가없는경우(){
        assertEmail("@gmail.com", false);
    }
    @Test
    public void 도메인_파트가없는경우(){
        assertEmail("1234@", false);
    }

    @Test
    public void 도메인_파트에_dot없는(){
        assertEmail("rlaakswo0687@gmailcom", false);
    }

    @Test
    public void 도메인_Dot이연속으로있는경우(){
        assertEmail("rlaakswo0687@gmail..com", false);
    }

    @Test
    public void 도메인_Dot개수가_안맞는(){
        assertEmail("rlaakswo0687@gmail.com.", false);
        assertEmail("rlaakswo0687@.gmail.com", false);
    }

    @Test
    public void 영어_숫자_At_Dot_외에_다른문자(){
        assertEmail("!-_+", false);
    }



}