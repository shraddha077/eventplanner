package com.rsl.event.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rsl.event.dao.UserRepository;
import com.rsl.event.entity.User;

@Component
public class UserService {
		@Autowired
		private UserRepository userRepository;
		
		// get all employees
		public List<User> getAllUserList()
		{
			List<User> list = (List<User>) this.userRepository.findAll();
			return list;
		}
		
		// get single employee by id
		public User getUserByMailAndPassword(String mail, String password)
		{
			User user=null;
			try
			{
				user = this.userRepository.findByMailAndPassword(mail, password);
			}
			catch(Exception e) {System.out.println(e);}
			
			return user;
		}
		
		// Adding the new employee
		public User AddUser(User mainuser)
		{
			User user = new User();
			user = this.userRepository.save(mainuser);
			return user;
		}
		
		// delete employee
		public void deleteUser(int id)
		{
			this.userRepository.deleteById(id);
		}

			
		// update employee 
		public void updateUser(User user,int id)
		{
			user.setId(id);
			this.userRepository.save(user);
		}
}

