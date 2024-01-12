package gdsc.fundhub.kantongsosialcampaign.dto.read;

import org.hibernate.validator.constraints.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;

import gdsc.fundhub.kantongsosialcampaign.model.Category;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReadCampaignDTO {

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
