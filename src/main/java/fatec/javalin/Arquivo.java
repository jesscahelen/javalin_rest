package fatec.javalin;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Arquivo {
	
	private String filename;
	private String problem;
	private String sourcecode;
	
	@JsonCreator
	public Arquivo(@JsonProperty ("filename") String filename, @JsonProperty ("problem") String problem, 
		       @JsonProperty ("sourcecode") String sourcecode) {
		this.filename = filename;
		this.problem = problem;
		this.sourcecode = sourcecode;
	}
	
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getProblem() {
		return problem;
	}
	public void setProblem(String problem) {
		this.problem = problem;
	}
	public String getSourcecode() {
		return sourcecode;
	}
	public void setSourcecode(String sourcecode) {
		this.sourcecode = sourcecode;
	}
	
}
