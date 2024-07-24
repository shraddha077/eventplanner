package com.rsl.event.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rsl.event.entity.User;
import com.rsl.event.service.UserService;


@RestController
public class UserController 
{
	@Autowired
	private UserService userService;
	
	@GetMapping("/user")
	public ResponseEntity<List<User>> getAllUsers()
	{
		List<User> list = userService.getAllUserList();
		
		if(list.size()<=0)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(list);
	}
	
	@PostMapping("/user")
	public ResponseEntity<User> addUser(@RequestBody User user)
	{
		User use1 = null;
		try
		{
			use1 = this.userService.AddUser(user);
			return  ResponseEntity.of(Optional.of(use1));
		}
		catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@GetMapping("/user/{mail}/{pass}")
	public ResponseEntity<User> getUser(@PathVariable("mail")String mail, @PathVariable("pass") String pass)
	{
		User user = this.userService.getUserByMailAndPassword(mail,pass);
		if(user==null)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(user));
	}
	
	
	@DeleteMapping("/user/{userId}")
	public ResponseEntity<Void> deleteUser(@PathVariable("userId")int userId)
	{
		try
		{
			this.userService.deleteUser(userId);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PutMapping("/user/{userId}")
	public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable("userId") int userId)
	{
		try
		{
			this.userService.updateUser(user, userId);
			return ResponseEntity.ok().body(user);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}	
}
