package taller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {
	Connection connection = null;
	String host = "localhost";
	String port = "5432";
	String db_name = "postgres";
	String username = "randy";
	String password = "root";

	public void query(String SQL) {
		conexion();
		try (Connection conn = connection;
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(SQL)) {
			displayActor(rs);
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}

	private void displayActor(ResultSet rs) throws SQLException {
		while (rs.next()) {
			System.out
					.println(rs.getString("id_usuario") + "\t" + rs.getString("login") + "\t" + rs.getString("passwd"));

		}
	}

	public void conexion() {

		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://" + host + ":" + port + "/" + db_name + "",
					"" + username + "", "" + password + "");
			if (connection != null) {
				System.out.println("Connection OK");
			} else {
				System.out.println("Connection Failed");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean buscarUsuario(String SQL) {
		boolean res = false;
		conexion();
		try (Connection conn = connection;
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(SQL)) {
			rs.next();
			boolean c = rs.getBoolean(1);
			if (c) {
				res = true;
				System.out.println("Inicio de sesion exitoso");
			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return res;
	}

	public long addUsuario(String login, String Passwd) {

		String SQL = "INSERT INTO usuario(login,passwd) " + "VALUES(?,?)";

		long id = 0;
		conexion();

		try (Connection conn = connection;
				PreparedStatement pstmt = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS)) {

			pstmt.setString(1, login);
			pstmt.setString(2, Passwd);

			int affectedRows = pstmt.executeUpdate();
			// check the affected rows
			if (affectedRows > 0) {
				// get the ID back
				try (ResultSet rs = pstmt.getGeneratedKeys()) {
					if (rs.next()) {
						id = rs.getLong(1);
					}
				} catch (SQLException ex) {
					System.out.println(ex.getMessage());
				}
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return id;
	}

}
