package com.selisegroup.service.impl;


import com.selisegroup.entity.UserEntity;
import com.selisegroup.model.UserModel;
import com.selisegroup.repository.UserRepository;
import com.selisegroup.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service("UserService")
public class UserServiceImpl implements UserService {
	
	
	private final UserRepository userRepository;
	private final PasswordEncoder bcryptEncoder;
	
	public UserServiceImpl(UserRepository userRepository, PasswordEncoder bcryptEncoder) {
		this.userRepository = userRepository;
		this.bcryptEncoder = bcryptEncoder;
	}
	
	@Override
	public UserModel saveUser(UserModel userModel) {
		UserEntity savedUser = new UserEntity();
		userModel.setPassword(bcryptEncoder.encode(userModel.getPassword()));
		savedUser.setUsername(userModel.getUsername());
		savedUser.setPassword(userModel.getPassword());
		savedUser.setRoleList(userModel.getRoleList());
		savedUser = userRepository.save(savedUser);
		userModel.setId(savedUser.getId());
		return userModel;
	}
}
