package br.com.rafael.projetoweb;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
@RequestMapping("/cadastrar")
public class projetoController {
    @PostMapping
    public void fazerCadastro(HttpServletRequest request, HttpServletResponse response) throws IOException {
        var t = new Tarefa();

        TarefaDao tDao = new TarefaDao();
        var nome = request.getParameter("nome");
        var prioridade  = Integer.parseInt(request.getParameter("prioridade"));

        t.setNome(nome);
        t.setPrioridade(prioridade);

        tDao.incluir(t);







        response.setContentType("text/HTML");

        var writer = response.getWriter();
        writer.println("<html>" +
                "<body>" +
                "<h1>" + t.getNome() +"</h1>" +
                "<p>" + t.getPrioridade() + "</p>" +
                "<p>" + t.getDataCadastro() +"</p>" +
                "</body>" +
                "</html>");
    }

}
