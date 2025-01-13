package sg.edu.nus.iss.vttp5a_paf_day24.model.exception;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMessage {
    
    private int status;

    private String message;

    private Date timeStamp;

    private String endPoint;

    
}
