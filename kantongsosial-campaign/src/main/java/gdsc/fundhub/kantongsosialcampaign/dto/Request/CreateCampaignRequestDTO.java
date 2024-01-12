package gdsc.fundhub.kantongsosialcampaign.dto.Request;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateCampaignRequestDTO {
    private String lokasi;
    private long dana;
    private String komunitas;
    private String program;
    private Date deadline;
    private long category;

}
