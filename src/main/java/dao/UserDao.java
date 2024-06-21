package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import beans.User;

public class UserDao {
	private static final String INSERT_USERS = "INSERT INTO User VALUES (0, ?, ?, ?, ?)";
	private static final String UPDATE_USERS = "UPDATE User SET lastName = ?, firstName = ?, login =?, password = ? WHERE id = ? ";
	private static final String SELECT_USER_BY_ID = "SELECT * FROM User WHERE id = ?";
	private static final String SELECT_USER_BY_LOGIN = "SELECT * FROM User WHERE login = ?";
	private static final String DELETE_USER = "DELETE FROM User WHERE id = ?";
	private static final ArrayList<User> users = new ArrayList<User>();

//	private static User user;
	static {
		users.add(new User("DIAO", "Saliou Samba", "saliou", "saliou@esp"));
	}

	public static boolean addUser(User user) {
		Connection connexion = ConnexionManager.getInstance();
		PreparedStatement statement = null;
		try {
			statement = connexion.prepareStatement(INSERT_USERS);
			statement.setString(1, user.getLastName());
			statement.setString(2, user.getFirstName());
			statement.setString(3, user.getLogin());
			statement.setString(4, user.getPassword());
			int status = statement.executeUpdate();
			return status == 1 ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connexion != null) {
				try {
					connexion.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}

	public static ArrayList<User> list() {
		ArrayList<User> users = new ArrayList<User>();
		Connection connexion = ConnexionManager.getInstance();
		Statement statement = null;
		ResultSet resultSet = null;
		if (connexion != null) {
			try {
				statement = connexion.createStatement();
				resultSet = statement.executeQuery("SELECT * FROM User");
				int id;
				String lastName, firstName, login, password;
				while (resultSet.next()) {
					id = resultSet.getInt("id");
					lastName = resultSet.getString("lastName");
					firstName = resultSet.getString("firstName");
					login = resultSet.getString("login");
					password = resultSet.getString("password");

					users.add(new User(id, lastName, firstName, login, password));

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return users;
	}

	public static boolean update(User user) {
		Connection connection = ConnexionManager.getInstance();
		PreparedStatement statement = null;

		try {
			statement = connection.prepareStatement(UPDATE_USERS);
			statement.setString(1, user.getLastName());
			statement.setString(2, user.getFirstName());
			statement.setString(3, user.getLogin());
			statement.setString(4, user.getPassword());
			statement.setInt(5, user.getId());

			int affectedRows = statement.executeUpdate();
			return affectedRows == 1 ? true : false;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return false;
	}

	public static boolean delete(int id) {
		Connection connexion = ConnexionManager.getInstance();
		PreparedStatement statement = null;

		try {
			statement = connexion.prepareStatement(DELETE_USER);
			statement.setInt(1, id);

			int affectedRows = statement.executeUpdate();
			return affectedRows == 1 ? true : false;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connexion != null) {
				try {
					connexion.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		for (User user : users) {
			if (user.getId() == id) {
				users.remove(user);
				return true;
			}
		}

		return false;
	}

	public static User get(int id) {

		Connection connection = ConnexionManager.getInstance();
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			statement = connection.prepareStatement(SELECT_USER_BY_ID);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {

				String lastName = resultSet.getString("lastName");
				String firstName = resultSet.getString("firstName");
				String login = resultSet.getString("login");
				String password = resultSet.getString("password");
				return new User(id, lastName, firstName, login, password);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return null;
	}

	public static User getLogin(String login) {
		Connection connexion = ConnexionManager.getInstance();
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			statement = connexion.prepareStatement(SELECT_USER_BY_LOGIN);
			statement.setString(1, login);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				int id = resultSet.getInt("id");
				String lastName = resultSet.getString("lastName");
				String firstName = resultSet.getString("firstName");
				String password = resultSet.getString("password");
				return new User(id, lastName, firstName, login, password);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connexion != null) {
				try {
					connexion.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return null;

	}

}