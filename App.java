import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpExchange;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class App {
    public static void main(String[] args) throws Exception {

        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        server.createContext("/", (HttpExchange exchange) -> {

            String response = "DevOps Project Running ";

            exchange.getResponseHeaders().set("Content-Type", "text/plain");

            exchange.sendResponseHeaders(200, response.getBytes().length);

            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.flush();
            os.close();
        });

        server.setExecutor(null);
        server.start();

        System.out.println("Server running on http://127.0.0.1:8080");
    }
}
