package dorduncuGunOdevi_GameSale;

import Abstract.BaseGameManager;
import Abstract.BaseGamerManager;
import Adapters.MernisServiceAdapter;
import Concrete.CampaignManager;
import Concrete.EpicGameManager;
import Concrete.EpicGamerManager;
import Concrete.SaleManager;
import Concrete.SteamGameManager;
import Concrete.SteamGamerManager;
import Entities.Campaign;
import Entities.Game;
import Entities.Gamer;

public class Main {

	public static void main(String[] args) {
		
		Gamer gamer1 = new Gamer(1, "Bilal", "Dýrmýk", 12345678901L, 1993); // TC No kasýtlý yanlýþ yazýldý.
		
		Gamer gamer2 = new Gamer(2, "Hikmet", "Dýrmýk", 12345678901L, 1992);
		
		
		Game game1 = new Game
				(1, "Survival", "Gamepires", "Devolver Digital", "SCUM", 2018, 57);
		
		Game game2 = new Game
				(2, "Simulation", "Giants Software", "Focus Home Interactive", "Farming Sim 19", 2018, 100);
		
		
		Campaign campaign1 = new Campaign(1, "Winter Sale", 0.5);
		
		Campaign campaign2 = new Campaign(2, "Black Friday", 0.35);
		
		
		System.out.println("----------------Gamer1----------------");
		BaseGamerManager gamerManager1 = new SteamGamerManager(new MernisServiceAdapter());
		gamerManager1.register(gamer1);

		System.out.println("----------------Gamer2----------------");
		BaseGamerManager gamerManager2 = new EpicGamerManager();
		gamerManager2.register(gamer2);
		
		System.out.println("---------------------------------------------");
		
		System.out.println("----------------Game1----------------");
		BaseGameManager gameManager1 = new SteamGameManager();
		gameManager1.add(game1);
		
		System.out.println("----------------Game2----------------");
		BaseGameManager gameManager2 = new EpicGameManager();
		gameManager2.add(game2);
		
		System.out.println("---------------------------------------------");
		
		System.out.println("----------------Campaigns----------------");
		CampaignManager campaignManager = new CampaignManager();
		campaignManager.add(campaign1);
		campaignManager.add(campaign2);
		
		System.out.println("---------------------------------------------");
		
		System.out.println("----------------Sale----------------");
		SaleManager saleManager = new SaleManager();
		saleManager.sell(gamer1, game1, campaign1);
		saleManager.sell(gamer2, game2, campaign2);
		
	}

}
