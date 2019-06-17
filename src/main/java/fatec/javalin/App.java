package fatec.javalin;

import io.javalin.Javalin;
import io.javalin.json.JavalinJson;

public class App {
	public static void main(String[] args) {
	
		//aplicativo na porta :7000
		Javalin app = Javalin.create().start(7000);
		
		//encontrar por id do problema
		app.get("/maratona/id/:id", ctx -> {
			ctx.json(Banco.findById(ctx.pathParam("id")));
		});
		
		//encontrar por data
		app.get("/maratona/:d/:m/:y", ctx -> {
			ctx.json(Banco.findByPeriodo(ctx.pathParam("d"),ctx.pathParam("m"), ctx.pathParam("y")));
		});
		
		//encontrar por status
		app.get("/maratona/status/:status", ctx -> {
			ctx.json(Banco.findByStatus(ctx.pathParam("status")));
		});
		
		//enviar codigo em base64 e recebe json com a resposta
		app.post("/maratona", ctx -> {
			Arquivo arq = ctx.bodyAsClass(Arquivo.class);
			ctx.json(Banco.processoEntrada(arq.getSourcecode(),arq));
		});
	}

	
}