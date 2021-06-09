package kodlamaio.hrms.business.concretes;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.ImageService;
import kodlamaio.hrms.core.utilities.imageUpload.CloudinaryService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ImageDao;
import kodlamaio.hrms.entities.concretes.Image;

@Service
public class ImageManager implements ImageService {

	private ImageDao imageDao;
	private CloudinaryService cloudinaryService;

	@Autowired
	public ImageManager(ImageDao imageDao,CloudinaryService cloudinaryService) {
		super();
		this.imageDao = imageDao;
		this.cloudinaryService = cloudinaryService;
	}

	@Override
	public Result add(Image image,MultipartFile imageFile) {
		@SuppressWarnings("unchecked")
		Map<String,String> uploadImage = this.cloudinaryService.upload(imageFile).getData();
		image.setUrl(uploadImage.get("url"));
		this.imageDao.save(image);
		return new SuccessResult("Fotoğraf eklendi!");
	}

//	@Override
//	public Result update(Image image) {
//		this.imageDao.save(image);
//		return new SuccessResult("Fotoğraf güncellendi!");
//	}
//
//	@Override
//	public Result delete(int id) {
//		this.imageDao.deleteById(id);
//		return new SuccessResult("Fotoğraf eklendi!");
//	}
//
//	@Override
//	public DataResult<Image> getById(int id) {
//		return new SuccessDataResult<Image>(this.imageDao.getById(id));
//		
//	}
//
//	@Override
//	public DataResult<List<Image>> getAll() {
//		return new SuccessDataResult<List<Image>>(this.imageDao.findAll());		
//	}

	@Override
	public DataResult<Image>getByCandidateId(int id) {
		return new SuccessDataResult<Image>(this.imageDao.getByCandidate_id(id));
	}
	
	
	
}
