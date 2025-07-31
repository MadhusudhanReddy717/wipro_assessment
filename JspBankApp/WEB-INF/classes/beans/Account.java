package beans; 
 
import java.io.Serializable; 
import java.text.DecimalFormat; 
 
/** 
 * JavaBean for Bank Account 
 * Demonstrates proper bean structure with EL compatibility 
 */ 
public class Account implements Serializable { 
    private static final long serialVersionUID = 1L; 
 
    // Private properties 
    private String accountNo; 
    private String name; 
    private double balance; 
 
    // Default constructor (required for JavaBean) 
    public Account() { 
        System.out.println("Account bean created: " + this.hashCode()); 
    } 
 
    // Parameterized constructor 
    public Account(String accountNo, String name, double balance) { 
        this.accountNo = accountNo; 
        this.name = name; 
        this.balance = balance; 
    } 
 
    // Getter and Setter methods (required for JavaBean) 
    public String getAccountNo() { 
        return accountNo; 
    } 
 
    public void setAccountNo(String accountNo) { 
        this.accountNo = accountNo; 
        System.out.println("Account No set: " + accountNo); 
    } 
 
    public String getName() { 
        return name; 
    } 
 
    public void setName(String name) { 
        this.name = name; 
        System.out.println("Name set: " + name); 
    } 
 
    public double getBalance() { 
        return balance; 
    } 
 
    public void setBalance(double balance) { 
        this.balance = balance; 
        System.out.println("Balance set: " + balance); 
    } 
 
    // Utility methods for EL expressions 
    public String getFormattedBalance() { 
        DecimalFormat df = new DecimalFormat("#,##0.00"); 
        return df.format(balance); 
    } 
 
    public String getAccountType() { 
        if (balance >= 50000) return "Premium"; 
        else if (balance >= 10000) return "Gold"; 
        else return "Regular"; 
    } 
 
    public boolean isPremium() { 
        return balance >= 50000; 
    } 
 
    public boolean isGold() { 
        return balance >= 10000 && balance < 50000; 
    } 
 
    public boolean isSufficientBalance() { 
        return balance >= 1000; 
    } 
 
    @Override 
    public String toString() { 
        return "Account{" + 
               "accountNo='" + accountNo + '\'' + 
               ", name='" + name + '\'' + 
               ", balance=" + balance + 
               ", type=" + getAccountType() + 
               '}'; 
    } 
} 
        this.balance = balance; 
    } 
 
    // Getter and Setter methods (required for JavaBean) 
    public String getAccountNo() { 
        return accountNo; 
    } 
 
    public void setAccountNo(String accountNo) { 
        this.accountNo = accountNo; 
        System.out.println("Account No set: " + accountNo); 
    } 
 
    public String getName() { 
        return name; 
    } 
 
    public void setName(String name) { 
        this.name = name; 
        System.out.println("Name set: " + name); 
    } 
 
    public double getBalance() { 
        return balance; 
    } 
 
    public void setBalance(double balance) { 
        this.balance = balance; 
        System.out.println("Balance set: " + balance); 
    } 
 
    // Utility methods for EL expressions 
    public String getFormattedBalance() { 
        DecimalFormat df = new DecimalFormat("#,##0.00"); 
        return df.format(balance); 
    } 
 
    public String getAccountType() { 
        if (balance >= 50000) return "Premium"; 
        else if (balance >= 10000) return "Gold"; 
        else return "Regular"; 
    } 
 
    public boolean isPremium() { 
        return balance >= 50000; 
    } 
 
    public boolean isGold() { 
        return balance >= 10000 && balance < 50000; 
    } 
 
    public boolean isSufficientBalance() { 
        return balance >= 1000; 
    } 
 
    @Override 
    public String toString() { 
        return "Account{" + 
               "accountNo='" + accountNo + '\'' + 
               ", name='" + name + '\'' + 
               ", balance=" + balance + 
               ", type=" + getAccountType() + 
               '}'; 
    } 
} 
