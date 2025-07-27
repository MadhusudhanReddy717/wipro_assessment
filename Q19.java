package assessment;

public class Q19 {

    public static void main(String[] args) {
        Bank[] customers = new Bank[4];

        customers[0] = new Saving("S101", "Madhu", 2, "Teacher", 5000, 0.05);
        customers[1] = new Current("C102", "Siva", 1, "Engineer", 7000, 0.03, true);
        customers[2] = new Saving("S103", "Ravi", 1, "Clerk", 6000, 0.04);
        customers[3] = new Current("C104", "Lakshmi", 2, "Manager", 8000, 0.02, false);

        System.out.println("Q19: Bank Account Balances:");
        for (Bank b : customers) {
            System.out.println(b + ", Final Balance: " + b.calcBalance());
        }

        String searchAccNo = "C102";
        boolean found = false;
        for (Bank b : customers) {
            if (b.accNo.equals(searchAccNo)) {
                System.out.println("\nCustomer found: " + b);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("\nAccount number " + searchAccNo + " not found.");
        }

        int currentCount = 0;
        double totalCurBal = 0;
        for (Bank b : customers) {
            if (b instanceof Current) {
                currentCount++;
                totalCurBal += b.calcBalance();
            }
        }
        System.out.println("\nTotal Current Account Holders: " + currentCount);
        System.out.println("Total Balance in Current Accounts: " + totalCurBal);
    }
}

abstract class Bank {
    String accNo;
    String custName;
    int custGender;
    String custJob;
    double curBal;

    Bank(String accNo, String custName, int custGender, String custJob, double curBal) {
        this.accNo = accNo;
        this.custName = custName;
        this.custGender = custGender;
        this.custJob = custJob;
        this.curBal = curBal;
    }

    public String toString() {
        return accNo + ", " + custName + ", Gender: " + (custGender == 1 ? "Male" : "Female") +
               ", Job: " + custJob + ", Balance: " + curBal;
    }

    public abstract double calcBalance();
}

class Saving extends Bank {
    double savRate;

    Saving(String accNo, String custName, int custGender, String custJob, double curBal, double savRate) {
        super(accNo, custName, custGender, custJob, curBal);
        this.savRate = savRate;
    }

    public double calcBalance() {
        return curBal + (savRate * curBal);
    }
}

class Current extends Bank {
    boolean fixedDep;
    double curRate;

    Current(String accNo, String custName, int custGender, String custJob, double curBal, double curRate, boolean fixedDep) {
        super(accNo, custName, custGender, custJob, curBal);
        this.curRate = curRate;
        this.fixedDep = fixedDep;
    }

    public double calcBalance() {
        double balance = curBal + (curRate * curBal);
        if (fixedDep) balance -= 150;
        return balance;
    }
}
/*
Q19: Bank Account Balances:
S101, Madhu, Gender: Female, Job: Teacher, Balance: 5000.0, Final Balance: 5250.0
C102, Siva, Gender: Male, Job: Engineer, Balance: 7000.0, Final Balance: 7060.0
S103, Ravi, Gender: Male, Job: Clerk, Balance: 6000.0, Final Balance: 6240.0
C104, Lakshmi, Gender: Female, Job: Manager, Balance: 8000.0, Final Balance: 8160.0

Customer found: C102, Siva, Gender: Male, Job: Engineer, Balance: 7000.0

Total Current Account Holders: 2
Total Balance in Current Accounts: 15220.0
*/

