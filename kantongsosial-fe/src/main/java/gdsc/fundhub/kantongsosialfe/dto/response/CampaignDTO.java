package gdsc.fundhub.kantongsosialfe.dto.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CampaignDTO {

    private String lokasi;
    private long dana;
    private String komunitas;
    private String program;
    private Date deadline;
    private int balance;
    private String judul;
    private String identitas;
    private String profil;
    private String acara;
    private String masalah;
    private String penerima;
    private String cta;
    private String akunMedsos;
}
