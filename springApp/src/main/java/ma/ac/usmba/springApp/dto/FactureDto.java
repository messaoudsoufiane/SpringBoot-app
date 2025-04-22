package ma.ac.usmba.springApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FactureDto {

    private String ref;
    private String cin ;
    List<LigneFactureDto> ligneFactureDtoList;

}
