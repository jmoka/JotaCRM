package top.jota.config;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import top.jota.db.Db;

@SpringBootApplication
public class TesteThreadConexao implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(TesteThreadConexao.class, args);
    }

    @Override
    public void run(String... args) {
    	
    	
    	// Cria um pool de threads que pode executar tarefas em paralelo, 
    	// e o número de threads é limitado por numberOfConnections
        int numberOfConnections = 2;
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfConnections);
        

        for (int i = 0; i < numberOfConnections; i++) {
            Db db = new Db();

            // Executa a conexão em uma thread separada
            executorService.execute(() -> {
                db.connection();

                // Adicione algum código aqui para realizar operações no banco de dados

                // Fecha a conexão
                db.closeConnection();
            });
        }

        // Encerra o ExecutorService após a conclusão de todas as tarefas
        executorService.shutdown();
    }
}
