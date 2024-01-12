package gdsc.fundhub.kantongsosialcampaign.dto.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCampaignDescryptionRequestDTO {
    
    private UUID uuid;

    private String judul;

    private String identitas;

    private String profil;

    private String acara;

    private String masalah;

    private String penerima;

    private String cta;
}
