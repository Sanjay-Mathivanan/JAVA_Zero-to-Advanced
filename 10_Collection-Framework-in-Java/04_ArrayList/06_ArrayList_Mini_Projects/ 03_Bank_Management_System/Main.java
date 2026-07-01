package Collections.ArrayList;

public class Main {

    public static void main(String[] args) {

        Bank bank = new Bank("State Bank of India");

        bank.addBranch("Coimbatore");

        bank.addBranch("Chennai");

        bank.addCustomer("Coimbatore", "Sanjay", 1000);

        bank.addCustomer("Coimbatore", "Arun", 2000);

        bank.addCustomer("Coimbatore", "Priya", 5000);

        bank.addCustomerTransaction("Coimbatore", "Sanjay", 500);

        bank.addCustomerTransaction("Coimbatore", "Sanjay", 750);

        bank.addCustomerTransaction("Coimbatore", "Arun", 1200);

        bank.addCustomerTransaction("Coimbatore", "Priya", 2500);

        bank.listCustomers("Coimbatore", true);

    }

}
