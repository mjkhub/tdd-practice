package jay.tdd_practice.password;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PasswordStrengthMeterTest {

    private final PasswordStrengthMeter passwordStrengthMeter = new PasswordStrengthMeter();

    private void assertStrength(String password, PasswordStrength expectedStrength){
        PasswordStrength strength = passwordStrengthMeter.meter(password);
        assertThat(strength).isEqualTo(expectedStrength);
    }

    @Test
    public void 모든_조건_충족(){

        assertStrength("ab12!@AB123", PasswordStrength.STRONG);
    }

    @Test
    public void 길이만8미만_모든_조건_만족(){

        assertStrength("Ab12345", PasswordStrength.NORMAL);
    }

    @Test
    public void 숫자만포함x_모든_조건_만족(){
        assertStrength("Abcdefghi", PasswordStrength.NORMAL);
    }

    @Test
    public void 대문자만포함x_모든_조건_만족(){
        assertStrength("abcdef1234k", PasswordStrength.NORMAL);
    }

    @Test
    public void 널값_공백_입력(){
        assertStrength(null, PasswordStrength.INVALID);
        assertStrength("", PasswordStrength.INVALID);
        assertStrength("      ", PasswordStrength.INVALID);
    }

    @Test
    public void 길이가_8자_이상인_경우만_만족(){
        assertStrength("aaaaaaaaaa", PasswordStrength.WEEK);
    }



    @Test
    public void 숫자를포함하는_경우만_만족(){
        assertStrength("1234", PasswordStrength.WEEK);
    }

    @Test
    public void 대문자를포함하는_경우만_만족(){
        assertStrength("ABCD", PasswordStrength.WEEK);
    }

    @Test
    public void 아무것도_만족x(){
        assertStrength("!@#$", PasswordStrength.WEEK);
    }




}