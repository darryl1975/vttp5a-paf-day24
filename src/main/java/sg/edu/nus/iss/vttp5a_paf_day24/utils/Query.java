package sg.edu.nus.iss.vttp5a_paf_day24.utils;

public class Query {
    
    public static final String createAccountSQL = "insert into BankAccount (fullName, isActive, balance) values (?, ?, ?)";

    public static final String selectAllBankAccountSQL = "select * from BankAccount";

    public static final String selectByBankAccountIdSQL = "select * from BankAccount where id = ?";

    public static final String deleteBankAccountByIdSQL = "update BankAccount set isActive = false where id = ?";

    public static final String updateBankAccountByIdSQL = "update BankAccount set balance = ? where id = ?";

    public static final String checkAccountExistsSQL = "select count(*) as cnt from BankAccount where id = ?";
}
