package service.inf;

public interface LoginService {
	
	public String login(String user, String password, String rememberMe);
	
	public String logout();
}
