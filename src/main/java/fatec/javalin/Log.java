package fatec.javalin;

import java.time.LocalDateTime;

public class Log {
	
	private Arquivo arquivo;
	private LocalDateTime datetime;
	private String status;
	
	
	
	public Log(Arquivo arquivo, LocalDateTime datetime, String status) {
		this.arquivo = arquivo;
		this.datetime = datetime;
		this.status = status;
	}


	
	public Arquivo getArquivo() {
		return arquivo;
	}



	public void setArquivo(Arquivo arquivo) {
		this.arquivo = arquivo;
	}



	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getDatetime() {
		return datetime;
	}

	public void setDatetime(LocalDateTime datetime) {
		this.datetime = datetime;
	}

}
