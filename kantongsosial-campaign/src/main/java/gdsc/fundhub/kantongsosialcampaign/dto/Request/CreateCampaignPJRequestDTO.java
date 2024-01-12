package gdsc.fundhub.kantongsosialcampaign.dto.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCampaignPJRequestDTO {
    private UUID uuid;
    private String noKtp;

    private String noHp;

    private String pekerjaan;

    private String jabatan;

    private String akunMedsos;
}
