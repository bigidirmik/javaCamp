package Concrete;

import Abstract.BaseGamerManager;
import Abstract.GamerCheckService;
import Entities.Gamer;

public class SteamGamerManager extends BaseGamerManager{
	
	private GamerCheckService gamerCheckService;

	public SteamGamerManager(GamerCheckService gamerCheckService) {
		this.gamerCheckService = gamerCheckService;
	}
	

	@Override
	public void register(Gamer gamer) {
		
		if(gamerCheckService.CheckIfRealPerson(gamer)) {
			super.register(gamer);
		}
		else {
			System.out.println("Not a valid person!");
		}
		
	}

}
