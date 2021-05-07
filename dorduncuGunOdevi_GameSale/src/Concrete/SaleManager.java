package Concrete;

import Abstract.SaleService;
import Entities.Campaign;
import Entities.Game;
import Entities.Gamer;

public class SaleManager implements SaleService {

	@Override
	public void sell(Gamer gamer, Game game, Campaign campaign) {
		System.out.println(
				"Tebrikler " + gamer.getName() + "! "
				+ game.getName() + " oyununu "
				+ campaign.getName() + " dahilinde "
				+ game.getPrice()*campaign.getDiscount()
				+ " TL'ye satýn aldýnýz."
				);
	}

}
