package bibliotecas;

import negocio.Candidato;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CandidatoDAO {

	private Connection conexao;
	
	public CandidatoDAO() {
		conexao = FabricaDeConexao.obterConexao();
	}
	
	public void criar(Candidato can) {
		String sql = "INSERT INTO candidatos(codigo,nome,sexo,data_nasc,cargo_pretendido,texto_curriculo) VALUES (?,?,?,?,?,?)";
		try {
			PreparedStatement instrucao = conexao.prepareStatement(sql);
			instrucao.setInt(1, can.getCodigo());
			instrucao.setString(2, can.getNome());
			instrucao.setString(3, can.getSexo());
			instrucao.setDate(4, can.getData_nasc());
			instrucao.setString(5, can.getCargo_pretendido());
			instrucao.setString(6, can.getTexto_curriculo());
			instrucao.execute();
			
		}catch(SQLException e) {
			System.err.println("Erro durante a insercao dos dados!!!");
		}
		
	}

	
	
	public List<Candidato> listar(){
		List<Candidato> listaCandidatos = new ArrayList<Candidato>();
		String sql = "SELECT codigo, nome, sexo, data_nasc, cargo_pretendido, texto_curriculo FROM candidatos";
		
		try {
			PreparedStatement instrucao = conexao.prepareStatement(sql);
			ResultSet resultado = instrucao.executeQuery();
			
			while(resultado.next()) {
				Candidato c = new Candidato(resultado.getInt("codigo"), resultado.getString("nome"), resultado.getString("sexo"), resultado.getDate("data_nasc"), resultado.getString("cargo_pretendido"), resultado.getString("texto_curriculo"));
				listaCandidatos.add(c);
			}
			
			
		}catch(SQLException e){
			System.err.println("Erro durante a leitura dos dados!!!");
		}
		
		return listaCandidatos;
	}
	
}
