package Abstract;

import Entities.Game;

public abstract class BaseGameManager implements GameService {

	@Override
	public void add(Game game) {
		System.out.println(game.getName() + " added to store");
	}

	@Override
	public void update(Game game) {
		System.out.println(game.getName() + " updated");
	}

	@Override
	public void delete(Game game) {
		System.out.println(game.getName() + " deleted from store");
	}

}
