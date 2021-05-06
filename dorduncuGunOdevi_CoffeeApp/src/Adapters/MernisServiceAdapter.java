package Adapters;

import java.rmi.RemoteException;

import Abstract.CustomerCheckService;
import Entities.Customer;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

public class MernisServiceAdapter implements CustomerCheckService {

	@Override
	public boolean CheckIfRealPerson(Customer customer) {
		
		KPSPublicSoapProxy client = new KPSPublicSoapProxy();
		
		try {
			return client.TCKimlikNoDogrula(
					customer.getNationalId(),
					customer.getFirstName(),
					customer.getLastName(),
					customer.getDateOfBirth()
					);
		}
		
		catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return false;
		
	}

}
