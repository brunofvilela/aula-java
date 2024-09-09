package br.com.syonet.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

import br.com.syonet.model.Studant;
import br.com.syonet.model.StudantRepository;

public class StudantDao implements StudantRepository {
  private final Logger log = Logger.getLogger(this.getClass().getName());
  private Connection connection;

	public StudantDao(Connection connection) {
    this.connection = connection;
  }

	@Override
	public Studant create(Studant studant) {
    String sql = "insert into students (name, age, email) values (?, ?, ?);";
    try (PreparedStatement prst = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			prst.setString(1, studant.getName());
      prst.setInt(2, studant.getAge());
      prst.setString(3, studant.getEmail());
      prst.executeUpdate();
      try (ResultSet resultSet = prst.getGeneratedKeys()) {
        resultSet.next();
        int id = resultSet.getInt(1);
        return new Studant(id, studant.getName(), studant.getAge(), studant.getEmail());
      }
		} catch (SQLException e) {
			log.warning(e.getMessage());
      throw new RuntimeException(e);
		}
	}

  @Override
  public List<Studant> listAll() {
    try (Statement st = this.connection.createStatement()) {
      st.execute("SELECT id, name, age, email FROM students;");
      List<Studant> result = new ArrayList<>();
      try (ResultSet rs = st.getResultSet()) {
        while (rs.next()) {
          var id = rs.getInt("id");
          var name = rs.getString("name");
          var age = rs.getInt("age");
          var email = rs.getString("email");
          result.add(new Studant(id, name, age, email));
        }
      }
      return result;
    } catch (SQLException e) {
      return Collections.emptyList();
    }
  }

  @Override
public void update(Studant studant) {
    String sql = "UPDATE students SET name = ?, age = ?, email = ? WHERE id = ?";
    try (PreparedStatement prst = this.connection.prepareStatement(sql)) {
        prst.setString(1, studant.getName());
        prst.setInt(2, studant.getAge());
        prst.setString(3, studant.getEmail());
        prst.setLong(4, studant.getId());
        prst.executeUpdate();
    } catch (SQLException e) {
        log.warning(e.getMessage());
        throw new RuntimeException(e);
    }
}

@Override
public List<Studant> findByName(String name) {
    String sql = "SELECT id, name, age, email FROM students WHERE name ILIKE ?";
    try (PreparedStatement prst = this.connection.prepareStatement(sql)) {
        prst.setString(1, "%" + name + "%");
        ResultSet rs = prst.executeQuery();
        List<Studant> result = new ArrayList<>();
        while (rs.next()) {
            var id = rs.getLong("id");
            var studentName = rs.getString("name");
            var age = rs.getInt("age");
            var email = rs.getString("email");
            result.add(new Studant(id, studentName, age, email));
        }
        return result;
    } catch (SQLException e) {
        log.warning(e.getMessage());
        return Collections.emptyList();
    }
}

@Override
public void delete(long id) {
    String sql = "DELETE FROM students WHERE id = ?";
    try (PreparedStatement prst = this.connection.prepareStatement(sql)) {
        prst.setLong(1, id);
        prst.executeUpdate();
    } catch (SQLException e) {
        log.warning(e.getMessage());
        throw new RuntimeException(e);
    }
}

@Override
public Studant findById(long id) {
    String sql = "SELECT id, name, age, email FROM students WHERE id = ?";
    try (PreparedStatement prst = this.connection.prepareStatement(sql)) {
        prst.setLong(1, id);
        ResultSet rs = prst.executeQuery();
        if (rs.next()) {
            var studentId = rs.getLong("id");
            var name = rs.getString("name");
            var age = rs.getInt("age");
            var email = rs.getString("email");
            return new Studant(studentId, name, age, email);
        }
    } catch (SQLException e) {
        log.warning(e.getMessage());
    }
    return null;
}
  
}
