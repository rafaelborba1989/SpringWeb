package br.com.rafael.projetoweb;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class TarefaDao {
    private Conexao c;
    private String REL = "SELECT * FROM Tarefa";
    private String BUS = "SELECT * FROM Tarefa WHERE nome = ?";

    private String INS = "INSERT INTO Tarefa(nome, prioridade) VALUES (?,?) ";



    public TarefaDao(){
        c = new Conexao();
    }

    public Tarefa buscar(String nome){
        Tarefa tarefa = null;
        try {
            c.conectar();
            PreparedStatement instrucao = c.getConexao().prepareStatement(BUS);
            instrucao.setString(1, nome);
            ResultSet rs = instrucao.executeQuery();
            if(rs.next()) {
                tarefa = new Tarefa();
                tarefa.setNome(rs.getString("nome"));
                tarefa.setPrioridade(rs.getInt("prioridade"));
            }
            c.desconectar();

        }catch(Exception e) {
            System.out.println("Erro na busca"+e.getMessage());
        }
        return tarefa;
    }

    public void incluir(Tarefa t) {
        try {
            c.conectar();
            PreparedStatement instrucao = c.getConexao().prepareStatement(INS);
            instrucao.setString(1, t.getNome());
            instrucao.setInt(2, t.getPrioridade());
            instrucao.execute();
            c.desconectar();
        }catch(Exception e){
            System.out.println("Erro ao inserir Cliente" + e.getMessage());
        }
    }

    public ArrayList<Tarefa> relatorio() {
        Tarefa tarefa;
        ArrayList<Tarefa> listaTarefa = new ArrayList<Tarefa>();
        try {
            c.conectar();
            Statement instrucao = c.getConexao().createStatement();
            ResultSet rs = instrucao.executeQuery(REL);
            while(rs.next()) {
                tarefa = new Tarefa();
                tarefa.setNome(rs.getString("nome"));
                tarefa.setPrioridade(rs.getInt("prioridade"));
                listaTarefa.add(tarefa);
            }
            c.desconectar();
        }catch(Exception e){
            System.out.println("Erro ao emitir relatorio!" + e.getMessage());
        }
        return listaTarefa;
    }





}
