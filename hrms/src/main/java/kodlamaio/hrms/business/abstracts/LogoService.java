package kodlamaio.hrms.business.abstracts;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Logo;

public interface LogoService {

	Result add(Logo logo, MultipartFile imageFile);
	
	Result delete(Logo logo);

	DataResult<Logo> getById(int logoId);

	DataResult<Logo> getByEmployerId(int employerId);

}
