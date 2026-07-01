package Collections.ArrayList;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    private String bankName;

    private List<Branch> branches;

    public Bank(String bankName) {

        this.bankName = bankName;

        this.branches = new ArrayList<>();

    }

    public boolean addBranch(String branchName) {

        if (findBranch(branchName) == null) {

            branches.add(new Branch(branchName));

            return true;

        }

        return false;

    }

    public boolean addCustomer(String branchName,
                               String customerName,
                               double initialAmount) {

        Branch branch = findBranch(branchName);

        if (branch != null) {

            return branch.newCustomer(customerName, initialAmount);

        }

        return false;

    }

    public boolean addCustomerTransaction(String branchName,
                                          String customerName,
                                          double amount) {

        Branch branch = findBranch(branchName);

        if (branch != null) {

            return branch.addCustomerTransaction(customerName, amount);

        }

        return false;

    }

    public void listCustomers(String branchName,
                              boolean showTransactions) {

        Branch branch = findBranch(branchName);

        if (branch == null) {

            System.out.println("Branch not found.");

            return;

        }

        System.out.println("\n========== " + branchName + " Branch ==========");

        List<Customer> customers = branch.getCustomers();

        for (int i = 0; i < customers.size(); i++) {

            Customer customer = customers.get(i);

            System.out.println("\nCustomer " + (i + 1));

            System.out.println("Name : " + customer.getName());

            if (showTransactions) {

                System.out.println("Transactions:");

                List<Double> transactions = customer.getTransactions();

                for (int j = 0; j < transactions.size(); j++) {

                    System.out.println((j + 1) + ". ₹" + transactions.get(j));

                }

            }

        }

    }

    private Branch findBranch(String branchName) {

        for (Branch branch : branches) {

            if (branch.getBranchName().equalsIgnoreCase(branchName)) {

                return branch;

            }

        }

        return null;

    }

}
