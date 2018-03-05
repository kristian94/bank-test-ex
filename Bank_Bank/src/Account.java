public class Account {
    int balance;
    String owner;
    String bank;

    public Account(){
        this.owner = "";
        this.balance = 0;
        this.bank = "";
    }

    public Account(String name){
        this.owner = name;
        this.balance = 0;
        this.bank = "Totally Legit Offshore Cuban Bank";
    }

    public Account(String name, int balance, String bank){
        this.owner = name;
        this.balance = balance;
        this.bank = bank;
    }

    public int withdraw(int amount){
        if(amount > this.balance){
            throw new IllegalArgumentException("Tried to withdraw amount ("+amount+") that exceeded balance ("+this.balance+")");
        }
        this.balance -= amount;
        return this.balance;
    }

    public int deposit(int amount){
        this.balance += amount;
        return this.balance;
    }

    public boolean equals(Account a){
        return this.owner.equals(a.owner);
    }

    @Override
    public String toString(){
        return this.owner + ", balance: " + this.balance + ", bank: " + this.bank;
    }


}
