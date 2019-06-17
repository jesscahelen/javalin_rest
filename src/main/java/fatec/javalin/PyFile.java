package fatec.javalin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class PyFile {
	Process pypr;
	BufferedReader pybuffreader;
	BufferedWriter pybuffwriter;
	
	//le o .py
	public PyFile(String filecmd) throws IOException{
		
		String python_path= System.getenv("Python_Path");
	    pypr=Runtime.getRuntime().exec("cmd /c "+ python_path+" "+filecmd);
	    pybuffreader=new BufferedReader(new InputStreamReader(pypr.getInputStream()));
	    pybuffwriter=new BufferedWriter(new OutputStreamWriter(pypr.getOutputStream()));
	    

	}
	
	//executa o .py
	public static String PyExe(String py, String teste, String saida) throws IOException {
		String resultado = null;
		try {
			
			PyFile pyexe= new PyFile(py +">"+saida);
		    pyexe.pybuffwriter.write(teste);
		    pyexe.pybuffwriter.flush();
		    resultado = FileProcesso.leitura(saida);

			
		} catch (Exception e) {
			System.out.println(e);
		}
	    return resultado;
	}


}