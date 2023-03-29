package br.com.eu.api.controller;

import br.com.eu.api.medico.DadosCadastroMedico;
import br.com.eu.api.medico.Medico;
import br.com.eu.api.medico.MedicoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  // Define que será uma aplicação Rest!
@RequestMapping("/medicos")   // Define o mapeamento da URL "/medicos"!
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping  // Defiine qual metodo será chamado atraves de uma requisição tipo Post!
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados){
        System.out.println(dados);
        repository.save(new Medico(dados));

    }
}

/*OBS:
 @RequestBody: Define que o parametro recebido estará no "corpo(body)" da requisição!
 @Valid: DadosCadastroMedico é um record e precisa ser validado.
 Logo, essa anotação sinaliza que o record PRECISA ser validado!
 */