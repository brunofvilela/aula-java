package br.com.syonet.database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InitDb {
  private Connection connection;

  public InitDb(Connection connection) {
    this.connection = connection;
  }

  public void start() throws IOException, SQLException {
    byte[] allBytes = this.getClass().getClassLoader().getResourceAsStream("init.sql").readAllBytes();
    String initSql = new String(allBytes);
    try (Statement st = this.connection.createStatement()) {
      st.addBatch(initSql);
      st.executeBatch();
    }
  }
}
