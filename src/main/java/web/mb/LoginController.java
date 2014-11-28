package web.mb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import service.inf.LoginService;

@ManagedBean
@SessionScoped
public class LoginController {

	@ManagedProperty(value = "#{loginService}")
	private LoginService loginService;

	private String usuario;
	private String password;
	private String recuerdame;

	public LoginController() {
	}

	private Log log = LogFactory.getLog(LoginController.class);

	public String login() {
		String res = "error";
		try {
			res = loginService.login(usuario, password, recuerdame);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	public String logout() {
		String res = "error";

		return res;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRecuerdame() {
		return recuerdame;
	}

	public void setRecuerdame(String recuerdame) {
		this.recuerdame = recuerdame;
	}

	public LoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	public Log getLog() {
		return log;
	}

	public void setLog(Log log) {
		this.log = log;
	}

}
