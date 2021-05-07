package Adapters;

import java.rmi.RemoteException;

import Abstract.GamerCheckService;
import Entities.Gamer;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

public class MernisServiceAdapter implements GamerCheckService {

	@Override
	public boolean CheckIfRealPerson(Gamer gamer) {

		KPSPublicSoapProxy client = new KPSPublicSoapProxy();

		try {
			return client.TCKimlikNoDogrula(
					gamer.getNationalId(),
					gamer.getName(),
					gamer.getSurname(),
					gamer.getDateOfBirth()
					);
		}
		
		catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return false;

	}

}
