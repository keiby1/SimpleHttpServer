import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;


class MyHttpHandler implements HttpHandler {

    @Override

    public void handle(HttpExchange httpExchange) throws IOException {
        OutputStream outputStream = httpExchange.getResponseBody();
        String htmlResponse = Integer.toString(new Random().nextInt(10)+1);
        httpExchange.sendResponseHeaders(200, htmlResponse.length());
        outputStream.write(htmlResponse.getBytes());
        outputStream.flush();
        outputStream.close();
    }
}
