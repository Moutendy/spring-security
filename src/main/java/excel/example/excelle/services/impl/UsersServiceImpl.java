package excel.example.excelle.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import excel.example.excelle.model.UsersModel;
import excel.example.excelle.repositorie.UserRepository;
import excel.example.excelle.services.UserService;

@Service
public class UsersServiceImpl implements UserService{
	@Autowired
	UserRepository userRepository;
	
	@Override
	public void ajouterUser(UsersModel userModel) {
		userRepository.save(userModel);
	}

}
