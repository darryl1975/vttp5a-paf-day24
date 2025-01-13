package sg.edu.nus.iss.vttp5a_paf_day24.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.vttp5a_paf_day24.model.BankAccount;
import sg.edu.nus.iss.vttp5a_paf_day24.model.exception.AccountNotFoundException;
import sg.edu.nus.iss.vttp5a_paf_day24.utils.Query;

@Repository
public class BankAccountRepo {
    
    @Autowired
    JdbcTemplate template;

    public Boolean accountExists(int accountId) {

        try {
            BankAccount bankAccount = template.queryForObject(Query.selectByBankAccountIdSQL, BeanPropertyRowMapper.newInstance(BankAccount.class), accountId);

            return true;
        } catch (DataAccessException error) {
            throw new AccountNotFoundException("The account you are querying doesn't not exist in the system.");
        }
    }

    public BankAccount getAccountById(int accountId) {
        try {
            BankAccount account = template.queryForObject(Query.selectByBankAccountIdSQL, BeanPropertyRowMapper.newInstance(BankAccount.class), accountId);

            return account;
        } catch (DataAccessException ex) {
            throw new AccountNotFoundException("Account with id " + accountId + " does not exist.");
        }
    }

    public Boolean updateAccountById(BankAccount accountToUpdate) {
        int accountUpdated = template.update(Query.updateBankAccountByIdSQL, accountToUpdate.getBalance(), accountToUpdate.getId());

        if (accountUpdated > 0) {
            return true;
        }
        return false;
    }
}
