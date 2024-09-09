package br.com.syonet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import br.com.syonet.database.InitDb;
import br.com.syonet.database.StudantDao;
import br.com.syonet.model.StudantRepository;
import br.com.syonet.service.StudantService;
import br.com.syonet.view.StudantView;

public class Application {

    public static void main(String[] args) throws SQLException, IOException {
        try (Connection connection = ConnectionPool.getConnection();  Scanner scanner = new Scanner(System.in)) {
            new InitDb(connection).start();
            StudantRepository studantRepository = new StudantDao(connection);
            StudantService studantService = new StudantService(studantRepository);
            StudantView studantView = new StudantView(studantService, scanner);

            studantView.init();
            while (!studantView.isExit()) {
                studantView.showOptions();
                studantView.readSelectedOption();
                studantView.executeSelectedOperation();
            }
        }
    }

    class ConnectionPool {
        private static final String URL = "jdbc:postgresql://localhost:5432/aula_jdbc";
        private static final String USER = "syonet";
        private static final String PASSWORD = "syonet";

        public static Connection getConnection() throws SQLException {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            return connection;
        }
    }
}
