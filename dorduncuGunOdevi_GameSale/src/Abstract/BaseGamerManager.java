package Abstract;

import Entities.Gamer;

public abstract class BaseGamerManager implements GamerService {

	@Override
	public void register(Gamer gamer) {
		System.out.println(gamer.getName() + " registered");
	}

	@Override
	public void updateProfile(Gamer gamer) {
		System.out.println(gamer.getName() + " updated");
	}

	@Override
	public void deleteAccount(Gamer gamer) {
		System.out.println(gamer.getName() + " deleted");
	}

}
