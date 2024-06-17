package jay.tdd_practice.email;

import org.springframework.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {

    private static final String EMAIL_PATTERN = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN);
    public boolean validateEmail(String email){
        if(!StringUtils.hasText(email)) return false;
        if(!pattern.matcher(email).matches()) return false;
        if(StringUtils.containsWhitespace(email)) return false;
        if(countAtSymbol(email) != 1) return false;

        String[] s = email.split("@");
        if(!StringUtils.hasText(s[0]) || s.length==1) return false;

        String local = s[0];
        String domain = s[1];

        int countDots = countDotSymbol(domain);
        if(countDots == 0) return false;

        String[] domainSplit = domain.split(".");
        if(countDots+1 != domainSplit.length) return false;

        return true;
    }


    private int countAtSymbol(String email){
        int count = 0;
        for (char c : email.toCharArray()) {
            if(c == '@')
                count++;
        }
        return count;
    }

    private int countDotSymbol(String domain){
        int count = 0;
        for (char c : domain.toCharArray()) {
            if(c == '.')
                count++;
        }
        return count;
    }

}
