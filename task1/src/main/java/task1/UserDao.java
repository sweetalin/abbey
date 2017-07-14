package task1;

import java.util.ArrayList;

public interface UserDao {
	public ArrayList<User> findAll();
	public int insert();
}
