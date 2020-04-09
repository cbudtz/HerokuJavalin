import com.fasterxml.jackson.databind.json.JsonMapper;
import io.javalin.Javalin;
import io.javalin.plugin.json.JavalinJackson;

public class Main {
    public static void main(String[] args) {
        JavalinJackson.configure(new JsonMapper());
        int PortNo = 7000;
        String port = System.getenv("PORT");
        if (port!=null){
            PortNo = Integer.parseInt(port);
        }
        System.out.println("Starting on: " + PortNo);
        Javalin app = Javalin.create().start(PortNo);
        app.get("/api", ctx->{
            ctx.result("Hello!");

        });
        app.post("/api",ctx->{
            String body = ctx.body();
            ctx.result("Hello: " + body);
        });

    }
}
