package visualizacao;

import bibliotecas.CandidatoDAO;
import negocio.Candidato;

public class ListarCandidatos {

	public static void main(String args[]) {
		
		CandidatoDAO cdao = new CandidatoDAO();
		
		for(Candidato c : cdao.listar()) {
			System.out.println(c);
		}
		
	}
	
}
