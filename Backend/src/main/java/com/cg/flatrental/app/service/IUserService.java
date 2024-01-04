package com.cg.flatrental.app.service;

import java.util.List;

import com.cg.flatrental.app.entity.User;
import com.cg.flatrental.app.exception.UserNotFoundException;


public interface IUserService {
	public User addUser(User user);
	public User updateUser(User user) throws UserNotFoundException;
	public User updatePassword(User user,String newpass) throws UserNotFoundException;
	//public User removeUser(User user) throws UserNotFoundException;
	public User viewUser(int id) throws UserNotFoundException;
	public List<User> viewAllUser();
	public boolean validateUser(String username,String password,String UserType) throws UserNotFoundException;
	Boolean removeUser(Integer id) throws UserNotFoundException;
}
