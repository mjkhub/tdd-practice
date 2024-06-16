package jay.tdd_practice.account;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Account {

    private String accountNumber;
    private int money;

    public int transferMoney(int money, Account targetAccount){

        this.minusMoney(money);
        targetAccount.addMoney(money);
        return this.money;
    }

    public void addMoney(int money){
        this.money += money;
    }

    public void minusMoney(int money){
        if(this.money < money)
            throw new IllegalArgumentException("Not enough money");
        this.money -= money;
    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder{
        private Account account = new Account();

        public Builder accountNumber(String accountNumber){
            account.accountNumber = accountNumber;
            return this;
        }

        public Builder money(int money){
            account.money = money;
            return this;
        }
        public Account build(){
            return account;
        }

    }

}

