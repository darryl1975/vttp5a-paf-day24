package sg.edu.nus.iss.vttp5a_paf_day24.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    
    private int id; // auto_increment

    private String title; // varchar(255)

    private int quantity;

    private Boolean isActive;
}
