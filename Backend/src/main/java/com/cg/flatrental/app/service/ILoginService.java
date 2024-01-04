package com.cg.flatrental.app.service;

import com.cg.flatrental.app.exception.LoginException;
import com.cg.flatrental.app.exception.UserNotFoundException;

public interface ILoginService  {

	public boolean login(String username, String password, String userType)throws LoginException, UserNotFoundException;

	//public boolean login(User user) throws LoginException, UserNotFoundException;
}
