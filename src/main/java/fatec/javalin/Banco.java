package fatec.javalin;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Base64;


public class Banco {
	
	public static Arquivo arquivo;	
	public static List<Log> logs = new ArrayList<Log>();
	
	//decoda texto em base64 
	public static String decoder(String texto) {

		String textoDeco = new String(Base64.getDecoder().decode(texto));
		return textoDeco;

	}
	
	//encontra pelo id do problema
	public static List<Log> findById(String problem) {
		List<Log> encontrados = new ArrayList<Log>();
		for (Log log: logs) {
			if (log.getArquivo().getProblem().equals(problem)) {
				encontrados.add(log);
			}
		}
		return encontrados;
	}

	//encontra pelo status
	public static List<Log> findByStatus(String status) {
		List<Log> logsEncontrados = new ArrayList<>();
		for (Log log : logs) {
			if(log.getStatus().equals(status)) {
				logsEncontrados.add(log);
			} 
		}
		return logsEncontrados;
	}
	
	//encontra pelo dia, mes e ano
	public static List<Log> findByPeriodo(String dia, String mes, String ano) {
		List<Log> logsEncontrados = new ArrayList<>();
		for (Log log : logs) {
			if(Integer.valueOf(dia)==log.getDatetime().getDayOfMonth() &&
					Integer.valueOf(mes)==log.getDatetime().getMonthValue()&&
					Integer.valueOf(ano)==log.getDatetime().getYear()) {
				logsEncontrados.add(log);
			} 
		}
		return logsEncontrados;
	}
	
	
	//retorna teste de acordo com o problema
	public static String[] findTest(String py) {
		
		if (py.equals("mergulho.py")) {
			String[] testes = new String[4];
			testes[0] = "5 3\n3 1 5\n";
			testes[1] = "2 4 \n";
			testes[2] = "6 6\n6 1 3 2 5 4\n";
			testes[3] = "* \n";
			return testes;
		}
		if (py.equals("zerinho.py")) {
			String[] testes = new String[6];
			testes[0] = "1 1 0\n";
			testes[1] = "C\n";
			testes[2] = "0 0 0\n";
			testes[3] = "*\n";
			testes[4] = "1 0 0\n";
			testes[5] = "A\n";
			return testes;
		}
		return null;
	}
	
	public static void insereLog(Arquivo arq, String status) {
		LocalDateTime data = LocalDateTime.now();
		logs.add(new Log(arq, data, status));
	}
	
	public static Retorno processoEntrada(String texto, Arquivo arq) throws IOException {
		Retorno retorno;
		//decoda texto de base 64
		texto = decoder(texto);
		//busca o nome do arquivo e escreve um arquivo.py
		String novopy = arq.getFilename();
		FileProcesso.escrita(texto, novopy);
		String[] testes = findTest(novopy);
		boolean ok = true;
		//realiza o teste
		for (int i=0; i<testes.length; i+=2) {
			int j = i+1;
			String result = PyFile.PyExe(novopy, testes[i],"saida"+i+".txt");
			if(!(result.equals(testes[j]))) {
				ok = false;
				break;
				}
			}
		
		if (ok) {
			retorno = new Retorno(arq.getFilename(), arq.getProblem(), "SUCESS");
		}
		else {
			retorno = new Retorno(arq.getFilename(), arq.getProblem(), "FAIL");
		}
		//insere envio no log
		insereLog(arq, retorno.getStatus());
		return retorno;
	}
	
	
}
