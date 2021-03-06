package kodlamaio.hrms.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.SystemPersonnelService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.entities.concretes.SystemPersonnel;

@RestController
@RequestMapping("/api/systempersonel")
@CrossOrigin
public class SystemPersonnelController {

	private SystemPersonnelService systemPersonnelService;

	@Autowired
	public SystemPersonnelController(SystemPersonnelService systemPersonnelService) {
		super();
		this.systemPersonnelService = systemPersonnelService;
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody SystemPersonnel systemPersonnel) {
		return ResponseEntity.ok(this.systemPersonnelService.add(systemPersonnel));
	}

	@GetMapping("/getAll")
	public DataResult<List<SystemPersonnel>> getAll() {
		return this.systemPersonnelService.getAll();
	}

	@GetMapping("/getAllAsc")
	public DataResult<List<SystemPersonnel>> getAllAsc() {
		return this.systemPersonnelService.getAllAsc();
	}

	@GetMapping("/getAllByPage")
	public DataResult<List<SystemPersonnel>> getAll(int pageNo, int pageSize) {
		return this.systemPersonnelService.getAll(pageNo, pageSize);
	}
	
	
	@GetMapping("/findById")
	public DataResult<SystemPersonnel> findById(@RequestParam int systemPersonnelId){
		return this.systemPersonnelService.findById(systemPersonnelId);
	}
	
	@GetMapping("/findByEmail")
	public DataResult<SystemPersonnel> findByEmail(@RequestParam String email){
		return this.systemPersonnelService.findByEmail(email);
	}

	
	// hata f??rlatma

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions) {
		Map<String, String> validationErrors = new HashMap<String, String>();
		for (FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}

		ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors, "Do??rulama hatalar??");
		return errors;
	}

}
