package br.com.eu.api.medico;

import br.com.eu.api.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroMedico(

        @NotBlank       // Define que o campo não podera ficar em branco!
        String nome,

        @NotBlank
        @Email
        String email,

        @NotBlank
        String telefone,

        @NotBlank
        @Pattern(regexp = "\\d{4,6}")      // Define a quantidade de caracteres que o campo irá receber
        String crm,

        @NotNull
        Especialidade especialidade,
        @NotNull @Valid DadosEndereco endereco ) {  /* @valid: Este atributo representa uma record
                                                        e tambem precisa ser validado, logo essa anotação define que atributo
                                                        tambem precisa ser validado!*/
}

/*OBS:
*
* */
