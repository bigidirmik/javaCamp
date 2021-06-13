package kodlamaio.hrms.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.entities.User;
import kodlamaio.hrms.core.utilities.results.DataResult;

@RestController
@RequestMapping("/api/users")
public class UsersController  {
	
	private UserService userService;
	
	@Autowired
	public UsersController(UserService userService) {
		super();
		this.userService=userService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<User>> getAll(){
		return this.userService.getAll();
	}
	
	@GetMapping("/getAllAsc")
	public DataResult<List<User>> getAllAsc(){
		return this.userService.getAllAsc();
	}
	
	@GetMapping("/getAllByPage")
	public DataResult<List<User>> getAll(int pageNo, int pageSize){
		return this.userService.getAll(pageNo, pageSize);
	}
	
	@GetMapping("/findByEmail")
	public DataResult<User> findByEmail(@RequestParam String email){
		return this.userService.findByEmail(email);
	}
	
}
