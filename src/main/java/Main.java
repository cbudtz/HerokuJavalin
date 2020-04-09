import com.fasterxml.jackson.databind.json.JsonMapper;
import io.javalin.Javalin;
import io.javalin.plugin.json.JavalinJackson;

public class Main {
    public static void main(String[] args) {
        JavalinJackson.configure(new JsonMapper());
        Javalin app = Javalin.create().start(7000);
        app.get("/api", ctx->{
            ctx.result("Hello!");

        });
        app.post("/api",ctx->{
            String body = ctx.body();
            ctx.result("Hello: " + body);
        });

    }
}
