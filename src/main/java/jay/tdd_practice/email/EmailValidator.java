package jay.tdd_practice.email;

import org.springframework.util.StringUtils;

import java.util.regex.Pattern;

public class EmailValidator {

    private static final String EMAIL_PATTERN = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN);
    public boolean validateEmail(String email){
        if(containInvalidInput(email)) return false;

        if(containAtSymbolMoreThanOne(email)) return false;

        String[] localAndDomain = email.split("@");
        if(!isValidLocalAndDomain(localAndDomain)) return false;

        String local = localAndDomain[0];
        String domain = localAndDomain[1];

        int dotCounts = countDotSymbol(domain);
        if(isDotSymbolZero(dotCounts)) return false;

        String[] domainSplit = domain.split("\\.");
        if(!isValidSplitDomain(domainSplit, dotCounts)) return false;
        
        return true;
    }


    private boolean containInvalidInput(String email){
        if(!StringUtils.hasText(email)) return true;
        if(!pattern.matcher(email).matches()) return true;
        if(StringUtils.containsWhitespace(email)) return true;

        return false;
    }

    private boolean containAtSymbolMoreThanOne(String email){
        int count = 0;
        for (char c : email.toCharArray()) {
            if(c == '@')
                count++;
        }
        return count != 1;
    }

    private boolean isValidLocalAndDomain(String[] localAndDomain){
        if(!StringUtils.hasText(localAndDomain[0]) || localAndDomain.length==1) return false;
        return true;
    }


    private int countDotSymbol(String domain){
        int count = 0;
        for (char c : domain.toCharArray()) {
            if(c == '.')
                count++;
        }
        return count;
    }

    private boolean isDotSymbolZero(int dotCounts){
        return dotCounts == 0;
    }

    private boolean isValidSplitDomain(String[] domainSplit, int dotCounts){
        for (String s : domainSplit) {
            if(!StringUtils.hasText(s))
                return false;
        }

        if(domainSplit.length != dotCounts+1) return false;
        return true;
    }

}
