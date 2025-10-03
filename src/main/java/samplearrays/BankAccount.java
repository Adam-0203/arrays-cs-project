package samplearrays;

public class BankAccount {

    String name;
    double currentBalance;
    //TO-DO: Initialize an Array with 1000 in size that stores Double called 'transactions' to keep track of the user's transactions
    double[] transactions = new double[1000];
    int transaction_index = 0;

    public BankAccount(String name, double startingBalance){
        this.name = name;
        this.currentBalance = startingBalance;
    }

    public void deposit(double amount){
        if (amount>0){
            currentBalance += amount;
            System.out.println("the depositor's name : "+name);
            System.out.println("the deposited amount : "+amount);
            System.out.println("the new balance : "+currentBalance+"\n");
            transactions[transaction_index] = amount;
            transaction_index++;

        }
        else{
            System.out.println("the deposit is unsuccessful");
        }
    }

    public void withdraw(double amount){
        if (0<amount && amount<=currentBalance){
            currentBalance -= amount;
            transactions[transaction_index] = -amount;
            transaction_index++;

            System.out.println("the new balance, After withdrawal : "+currentBalance+"\n");
        }
        else{
            System.out.println("the withdrawal is impossible.");
        }
    }

    public void displayTransactions(){
        for (int i=0; i<transaction_index ; i++){
            if (transactions[i]<0){
                System.out.println("withdrawal of : "+(-transactions[i]));
            }
            else{
                System.out.println("deposit of : "+transactions[i]);
            }
        }
    }

    public void displayBalance(){
        System.out.println("the current balance : "+currentBalance);
    }

    public static void main(String[] args) {

        BankAccount john = new BankAccount("John Doe", 100);

        // ----- DO NOT CHANGE -----

        //Testing..
        john.displayBalance();
        john.deposit(0.25);
        john.withdraw(100.50);
        john.withdraw(40.90);
        john.deposit(-90.55);
        john.deposit(3000);
        john.displayTransactions();
        john.displayBalance();

        // ----- DO NOT CHANGE -----
    }

}
