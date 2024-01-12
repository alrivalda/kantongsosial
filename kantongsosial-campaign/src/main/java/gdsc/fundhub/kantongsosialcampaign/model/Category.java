package gdsc.fundhub.kantongsosialcampaign.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotNull;
import java.util.List;  

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Category {
    
    
    @Id
    private long id;
    

    @NotNull
    @Column(name = "category",nullable = false)
    private String category;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    @OnDelete(action =OnDeleteAction.CASCADE)
    @JsonIgnore
    private List<Campaign> campaigns;

}
