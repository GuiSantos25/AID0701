import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Cliente Socket que se conecta ao Servidor Echo local.
 * Envia mensagens inseridas pelo utilizador e exibe as respostas processadas.
 */
public class EchoClient {
    private static final String HOST = "localhost";
    private static final int PORT = 12345;

    public static void main(String[] args) {
        System.out.println("=== Cliente Echo Iniciado ===");
        System.out.println("A tentar estabelecer ligação a " + HOST + ":" + PORT + "...");

        // Uso de try-with-resources para gestão segura de sockets, streams e teclado
        try (Socket socket = new Socket(HOST, PORT);
             BufferedReader serverReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter serverWriter = new PrintWriter(socket.getOutputStream(), true);
             Scanner consoleScanner = new Scanner(System.in)) {

            System.out.println("Conexão estabelecida com sucesso!");
            System.out.println("Escreva uma mensagem e prima Enter. Escreva 'sair' para encerrar.\n");

            while (true) {
                System.out.print("Cliente > ");
                String userInput = consoleScanner.nextLine();

                if (userInput == null || userInput.trim().isEmpty()) {
                    continue;
                }

                // Envia a mensagem do utilizador para o servidor
                serverWriter.println(userInput);

                // Lê a resposta devolvida pelo servidor
                String serverResponse = serverReader.readLine();
                if (serverResponse != null) {
                    System.out.println("Servidor > " + serverResponse);
                }

                // Se o comando inserido for 'sair', quebra o ciclo local
                if ("sair".equalsIgnoreCase(userInput.trim())) {
                    break;
                }
            }

        } catch (IOException e) {
            System.err.println("Erro de comunicação com o servidor: " + e.getMessage());
        } finally {
            System.out.println("Cliente encerrado com sucesso.");
        }
    }
}