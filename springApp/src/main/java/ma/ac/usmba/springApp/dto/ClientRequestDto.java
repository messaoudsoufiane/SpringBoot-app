package ma.ac.usmba.springApp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.ac.usmba.springApp.annotation.IpAddress;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientRequestDto {
    //@NotNull(message = "le nome est Obligatoire")
    //@Size(min = 3 , max=10, message = "entre 3 et 10")
    @NotBlank
    private String nome;
    @NotNull(message = "le prenom est Obligatoire")
    @Size(min = 3 , max=10, message = "entre 3 et 10")
    private String prenome;
    @NotNull(message = "not Null")
    @Pattern(regexp = "^\\\\+212[5-7]\\\\d{8}$" , message = "Format Invalide")
    private String telephone ;

    @IpAddress()
    private String ip;

}
