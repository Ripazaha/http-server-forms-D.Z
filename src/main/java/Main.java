public class Main {

    public static void main(String[] args) {
        int port = 9999;
        int poolSize = 64;

        final var server = new Server(port, poolSize);

        server.addHandler("GET", "/messages", (request, responseStream) -> server.responseWithoutContent(responseStream,
                "404", "Not found"));
        server.addHandler("POST", "/messages", (request, responseStream) -> server.responseWithoutContent(responseStream,
                "404", "Not found"));
        server.addHandler("GET", "/", (request, responseStream) -> server.processing(responseStream, "spring.png"));

        server.serverStart();
    }
}