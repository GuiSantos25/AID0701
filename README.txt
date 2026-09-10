========================================================================
UFCD 0791 - Programação em JAVA (avançada)
TRABALHO PRÁTICO 1 - COMUNICAÇÃO EM REDE: ARQUITETURA CLIENTE-SERVIDOR
========================================================================

1. INFORMAÇÃO DO AMBIENTE DE DESENVOLVIMENTO
------------------------------------------------------------------------
- Versão do JDK utilizada: OpenJDK 17 (ou versão ativa no Codespaces)
- Ambiente de Execução: GitHub Codespaces (Universal Image).
- Nota: O trabalho foi desenvolvido e testado integralmente via browser no 
  GitHub Codespaces, sem recurso a instalações locais do JDK.


2. INSTRUÇÕES DE COMPILAÇÃO
------------------------------------------------------------------------
A partir do diretório raiz do projeto (onde se encontra este ficheiro README.txt),
execute o seguinte comando no terminal do Codespaces para compilar o código fonte
e guardar os ficheiros .class na pasta 'bin':

    javac -d bin src/*.java


3. INSTRUÇÕES DE EXECUÇÃO
------------------------------------------------------------------------
Para executar o sistema, são necessários dois terminais abertos em simultâneo 
no GitHub Codespaces.

Passo 1: Iniciar o Servidor (No Terminal 1)
    java -cp bin EchoServer

Passo 2: Iniciar o Cliente (No Terminal 2)
    java -cp bin EchoClient

Porto parametrizado: 12345
Endereço do Servidor: localhost


4. REGISTO DE CENÁRIO DE TESTE TÍPICO
------------------------------------------------------------------------
[Terminal 1 - Servidor]
=== Servidor Echo Iniciado ===
A aguardar conexões no porto 12345...
Cliente conectado com sucesso: 127.0.0.1
Mensagem recebida: ola mundo em java
Mensagem recebida: teste de socket
Comando de encerramento recebido do cliente.
Servidor encerrado e recursos libertados.

[Terminal 2 - Cliente]
=== Cliente Echo Iniciado ===
A tentar estabelecer ligação a localhost:12345...
Conexão estabelecida com sucesso!
Escreva uma mensagem e prima Enter. Escreva 'sair' para encerrar.

Cliente > ola mundo em java
Servidor > ECHO: OLA MUNDO EM JAVA
Cliente > teste de socket
Servidor > ECHO: TESTE DE SOCKET
Cliente > sair
Servidor > Sessão encerrada pelo servidor.
Cliente encerrado com sucesso.