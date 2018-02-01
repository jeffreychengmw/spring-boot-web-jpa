package com.hivesplaceteam.sb2StarterWebJpaThymeleaf.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hivesplaceteam.sb2StarterWebJpaThymeleaf.model.User;
import com.hivesplaceteam.sb2StarterWebJpaThymeleaf.repository.UserRepository;

@RestController
public class HomeController {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/")
	public List<User> getUserList() {
		Sort sort = new Sort(Direction.ASC, "username");
		return userRepository.findAll(sort);
	}
	
	@GetMapping("/id/{id}")
	public User getUserById(@PathVariable("id") int id) {
		return userRepository.findById(id)
			.orElseThrow(()->new RuntimeException("No user found with the id: "+id));
	}
	
	/*This Controller adopts {PathVariable:Regex} format*/
	@GetMapping(value="/username/{username:.+}")
	public User getUserbyUserName(@PathVariable("username") String username) {
		System.out.println(">>>>>>>>>>>>>>>>username: "+username);
		return userRepository.findByUserName(username)
			.orElseThrow(()->new RuntimeException("No user found with user name: "+username));
	}
	
	@PostMapping("/createUser")
	public ResponseEntity<User> createUser(@RequestBody @Valid User user, BindingResult bindingResult) {
		System.out.println("id: "+user.getId()+"; username: "+user.getUsername()+"; password: "+user.getPassword()+"; status: "+user.getStatus());
		if(bindingResult.hasErrors()) {
			System.out.println("bindingResult has error!");
			return new ResponseEntity<>(user, HttpStatus.BAD_REQUEST);
		}
		if (userRepository.findById(user.getId()).isPresent()) {
			System.out.println("User already exist!");
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		/*Custom Http Headers*/
		/*HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader1", "MyValue1");
		responseHeaders.set("MyResponseHeader1", "MyValue1");*/
		/*return new ResponseEntity<>(userRepository.save(user), responseHeaders, HttpStatus.CREATED);*/
		System.out.println("bindingResult has error");
		return new ResponseEntity<>(userRepository.save(user), HttpStatus.CREATED);
	}
}
