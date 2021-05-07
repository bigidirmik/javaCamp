package Abstract;

import Entities.Gamer;

public interface GamerService {
	
	void register(Gamer gamer);
	
	void updateProfile(Gamer gamer);
	
	void deleteAccount(Gamer gamer);

}
