package dorduncuGunOdevi_eCommerceSystem.business.concretes;

import dorduncuGunOdevi_eCommerceSystem.GoogleLogin.GoogleLoginManager;
import dorduncuGunOdevi_eCommerceSystem.business.abstracts.ThirdPartyLoginService;

public class GoogleLoginManagerAdapter implements ThirdPartyLoginService {

	@Override
	public void login(String email) {
		
		GoogleLoginManager googleLoginManager = new GoogleLoginManager();
		googleLoginManager.login(email);
		
	}

}
