package Collections.ArrayList;

import java.util.ArrayList;
import java.util.List;

public class Branch {

    private String branchName;
    private List<Customer> customers;

    public Branch(String branchName) {
        this.branchName = branchName;
        this.customers = new ArrayList<>();
    }

    public String getBranchName() {
        return branchName;
    }

    public boolean newCustomer(String customerName, double initialAmount) {

        if (findCustomer(customerName) == null) {

            customers.add(new Customer(customerName, initialAmount));

            return true;
        }

        return false;
    }

    public boolean addCustomerTransaction(String customerName, double amount) {

        Customer customer = findCustomer(customerName);

        if (customer != null) {

            customer.addTransaction(amount);

            return true;
        }

        return false;
    }

    public Customer findCustomer(String customerName) {

        for (Customer customer : customers) {

            if (customer.getName().equalsIgnoreCase(customerName)) {

                return customer;

            }

        }

        return null;

    }

    public List<Customer> getCustomers() {
        return customers;
    }

}
