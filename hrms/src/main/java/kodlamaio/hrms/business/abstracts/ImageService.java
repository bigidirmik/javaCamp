package kodlamaio.hrms.business.abstracts;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Image;

public interface ImageService {
	
	Result add(Image image, MultipartFile imageFile);
	
	
	DataResult<Image> getById(int imageId);
	
	DataResult<Image> getByCandidateId(int candidateId);

}
