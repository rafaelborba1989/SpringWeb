package br.com.eu.api.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosEndereco(
        @NotBlank  // Não permite que o campo fique em branco!
        String logradouro,
        @NotBlank
        String bairro,
        @NotBlank
        @Pattern(regexp = "\\d{8}")      // Define a quantidade de caracteres que o campo deverá receber
        String cep,
        @NotBlank
        String cidade,
       @NotBlank
        String uf,
        String complemento,
        String numero) {
}
