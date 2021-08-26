package model;

public interface UsersDAO {
	
	public Users getUsers(String username,String password);
	public int insertUsers(Users user);
	public boolean usernameControl(String username);

}
