package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.dataAccess.UserDao;
import kodlamaio.hrms.core.entities.User;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;

@Service
public class UserManager implements UserService {
	
	private UserDao userDao;

	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public DataResult<List<User>> getAll() {
		return new SuccessDataResult<List<User>>(this.userDao.findAll(),"Kullanıcılar listelendi");
	}
	
	@Override
	public DataResult<List<User>> getAllAsc() {
		Sort sort = Sort.by(Sort.Direction.ASC,"email");
		return new SuccessDataResult<List<User>>(this.userDao.findAll(sort),"Kullanıcılar listelendi");
	}

	@Override
	public DataResult<List<User>> getAll(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);
		return new SuccessDataResult<List<User>>(this.userDao.findAll(pageable).getContent(),"Kullanıcılar listelendi");
	}

	@Override
	public DataResult<User> findByEmail(String email) {
		var data = this.userDao.findByEmail(email);
		if(data==null) {
			return new ErrorDataResult<User>("Kullanıcı bulunamadı");
		}
		return new SuccessDataResult<User>(data,"Kullanıcı bulundu");
	}

}
