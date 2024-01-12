package gdsc.fundhub.kantongsosialcampaign.dto.read;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReadAllCampaignDTO {
    private String category;
    private String program;
    private int balance;
    private Date deadline;
}
