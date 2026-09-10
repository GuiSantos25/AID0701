import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Servidor Echo que escuta conexões TCP na porta especificada.
 * Converte todas as mensagens recebidas para maiúsculas e devolve-as ao cliente.
 */
public class EchoServer {
    private static final int PORT = 12345;

    public static void main(String[] args) {
        System.out.println("=== Servidor Echo Iniciado ===");
        System.out.println("A aguardar conexões no porto " + PORT + "...");

        // Uso de try-with-resources para garantir o fecho automático do ServerSocket, Socket e Streams
        try (ServerSocket serverSocket = new ServerSocket(PORT);
             Socket clientSocket = serverSocket.accept();
             BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true)) {

            System.out.println("Cliente conectado com sucesso: " + clientSocket.getInetAddress().getHostAddress());

            String inputLine;
            // Lê continuamente as mensagens enviadas pelo cliente
            while ((inputLine = reader.readLine()) != null) {
                // Comando de terminação enviado pelo cliente
                if ("sair".equalsIgnoreCase(inputLine.trim())) {
                    System.out.println("Comando de encerramento recebido do cliente.");
                    writer.println("Sessão encerrada pelo servidor.");
                    break;
                }

                System.out.println("Mensagem recebida: " + inputLine);

                // Transformação textual: Conversão para maiúsculas
                String transformedMessage = inputLine.toUpperCase();
                
                // Envio da resposta ao cliente
                writer.println("ECHO: " + transformedMessage);
            }

        } catch (IOException e) {
            System.err.println("Ocorreu um erro no servidor: " + e.getMessage());
        } finally {
            System.out.println("Servidor encerrado e recursos libertados.");
        }
    }
}