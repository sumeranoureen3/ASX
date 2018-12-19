package com.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements IUserService{

	private IUser userRepo;
	
	//Spring Setter Injection
	@Autowired
	public void setUserRepo(IUser userRepo) {
		this.userRepo = userRepo;
	}

	@Override
	public Iterable<Trading_Calendar> listAllUsers() {
		return userRepo.findAll();
	}


	@Override
	public Trading_Calendar getUserById(long id) {
		return userRepo.findOne(id);
	}

	@Override
	public Trading_Calendar saveUser(Trading_Calendar user) {
		return userRepo.save(user);
	}

	@Override
	public void deleteUser(long id) {
		
		 userRepo.delete(id);
		
	}

	
}
