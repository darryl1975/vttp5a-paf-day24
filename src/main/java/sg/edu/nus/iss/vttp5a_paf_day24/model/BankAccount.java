package sg.edu.nus.iss.vttp5a_paf_day24.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankAccount {
    
    private int id;

    private String fullName;

    private Boolean isActive;

    private Float balance;


}
