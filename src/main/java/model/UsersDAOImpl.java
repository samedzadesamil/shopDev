package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UsersDAOImpl implements UsersDAO {
	static Connection connection;
	static PreparedStatement ps;
	static Statement st;

	@Override
	public Users getUsers(String username, String password) {
		Users users = new Users();
		try {
			connection = DbConnection.connectDb();
			ps = connection.prepareStatement("select * from users where username=? and password=?");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				users.setId(rs.getInt("id"));
				users.setName(rs.getString("name"));
				users.setUsername(rs.getString("username"));
				users.setPassword(rs.getString("password"));
			}
			connection.close();
		} catch (SQLException e) {
			System.out.println(e);
		}

		return users;
	}

	@Override
	public int insertUsers(Users user) {
		int status = 0;
		try {
			connection = DbConnection.connectDb();
			ps = connection.prepareStatement("insert into users(name,username,password) values(?,?,?)");
			ps.setString(1, user.getName());
			ps.setString(2, user.getUsername());
			ps.setString(3, user.getPassword());
			status = ps.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			System.out.println(e);
		}

		return status;
	}
	
	@Override
	public boolean usernameControl(String username) {
		boolean control = true;
		try {
			connection = DbConnection.connectDb();
			ps = connection.prepareStatement("select * from users where username=?");
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
			control = false;

			}

		} catch (SQLException e) {
			System.out.println(e);
		}

		return control;
	}

}
