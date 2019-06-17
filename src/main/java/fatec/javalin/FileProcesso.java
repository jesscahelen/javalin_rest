package fatec.javalin;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

public class FileProcesso{
	
	//le arquivo e retorna string
	public static String leitura(String entrada) throws IOException {
		String pathInput = System.getProperty("user.dir")+File.separator+entrada; //pega o caminho da entrada
		BufferedReader reader = new BufferedReader(new FileReader(pathInput));
		
		String texto = "";
		String line = null;
		//le o arquivo e escreve na saída
		while((line = reader.readLine()) != null) {
			texto = texto.concat(line)+"\n";
		}
		reader.close();
		return texto;
	}
	
	//escreve arquivo
	public static String escrita(String texto, String saida) throws IOException {
		String pathOutput = System.getProperty("user.dir")+File.separator+saida;
		Writer writer = new PrintWriter(pathOutput);
		writer.write(texto);
		writer.flush();
		writer.close();
		return texto;
	}
	
}
