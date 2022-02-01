package visualizacao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Scanner;

import bibliotecas.CandidatoDAO;
import negocio.Candidato;

public class IncluirCandidato {
	
	public static void main(String args[]) throws SQLException{
		Scanner reader = new Scanner(System.in);
		
		String nome, sexo, cargo_pretendido, texto_curriculo, dataString;
		int codigo;
		Date data_nasc;
		
		System.out.println("Digite o codigo do candidato: ");
		codigo = reader.nextInt();
		reader.nextLine();
		System.out.println("Digite o nome do candidato: ");
		nome = reader.nextLine();
		System.out.println("Digite o sexo do candidato: ");
		sexo = reader.nextLine();
		System.out.println("Digite o ano de nascimento do candidato no formato: ");
		dataString = reader.nextLine();
		System.out.println("Digite o mes de nascimento do candidato no formato: ");
		dataString += "-" + reader.nextLine();
		System.out.println("Digite o dia de nascimento do candidato no formato: ");
		dataString += "-" + reader.nextLine();
		data_nasc = java.sql.Date.valueOf(dataString);
		System.out.println("Digite o cargo pretendido do candidato: ");
		cargo_pretendido = reader.nextLine();
		System.out.println("Digite o texto do curriculo do candidato: ");
		texto_curriculo = reader.nextLine();
		
		Candidato candidato = new Candidato(codigo, nome, sexo, data_nasc, cargo_pretendido, texto_curriculo);
		
		CandidatoDAO dao = new CandidatoDAO();
		dao.criar(candidato);
		System.out.println("Candidato criado!");
		
		reader.close();
		
	}
	
}
