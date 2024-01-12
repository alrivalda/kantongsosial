package gdsc.fundhub.kantongsosialcampaign.model;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Campaign {
    @Id
    @Column(name = "campaign_id")
    private UUID id = UUID.randomUUID();

    @NotNull
    @Column(name = "lokasi")
    private String lokasi;

    @NotNull
    @PositiveOrZero
    @Column(name = "dana")
    private long dana;

    @NotNull
    @Column(name = "komunitas")
    private String komunitas;

    @NotNull
    @Column(name = "program")
    private String program;

    @Column(name = "deadline", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date deadline;

    @PositiveOrZero
    @Column(name = "balance")
    private int balance = 0;

    @Column(name = "judul")
    private String judul;

    @Column(name = "identitas")
    private String identitas;

    @Column(name = "profil")
    private String profil;

    @Column(name = "acara")
    private String acara;

    @Column(name = "masalah")
    private String masalah;

    @Column(name = "penerima")
    private String penerima;

    @Column(name = "cta")
    private String cta;

    @Column(name = "no_ktp")
    private String noKtp;

    @Column(name = "no_hp")
    private String noHp;

    @Column(name = "pekerjaan")
    private String pekerjaan;

    @Column(name = "jabatan")
    private String jabatan;

    @Column(name = "akun_medsos")
    private String akunMedsos;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

}
