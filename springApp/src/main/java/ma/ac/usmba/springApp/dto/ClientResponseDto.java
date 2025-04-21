package ma.ac.usmba.springApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientResponseDto {
    private Integer id;
    private String nome;
    private String prenome;
    private String telephone ;
}
