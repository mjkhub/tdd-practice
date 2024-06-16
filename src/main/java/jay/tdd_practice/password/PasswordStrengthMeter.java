package jay.tdd_practice.password;

public class PasswordStrengthMeter {


    public PasswordStrength meter(String password) {
        if(password==null || password.isEmpty() || password.isBlank()) return PasswordStrength.INVALID;

        int conditionCount = 0;
        if(isLongerThanEight(password))  conditionCount++;
        if(isContainingNumber(password)) conditionCount++;
        if(isContainingUpper(password))  conditionCount++;

        if(conditionCount <=1) return PasswordStrength.WEEK;
        else if( conditionCount == 2) return PasswordStrength.NORMAL;
        return PasswordStrength.STRONG;
    }


    private boolean isLongerThanEight(String password){

        return password.length()>=8;
    }
    private boolean isContainingNumber(String password){
        for (char c : password.toCharArray())
            if('0'<= c && c <= '9')
                return true;
        return false;
    }

    private boolean isContainingUpper(String password){
        for (char c : password.toCharArray())
            if('A'<= c && c <= 'Z')
                return true;
        return false;
    }

}
