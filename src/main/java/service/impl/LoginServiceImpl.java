package service.impl;

import service.inf.LoginService;

public class LoginServiceImpl implements LoginService {

	@Override
	public String login(String user, String password, String rememberMe) {

		return "rol";
	}

	@Override
	public String logout() {

		return "loggedout";
	}

}
