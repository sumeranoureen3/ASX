package com.app;


public interface IUserService {

	   public Iterable<Trading_Calendar> listAllUsers();

	   public Trading_Calendar getUserById(long id);

	   public Trading_Calendar saveUser(Trading_Calendar user);
	    
	   public void deleteUser(long id);
	
}
