package controllers;

import play.libs.Crypto;
import models.User;

public class Security extends Secure.Security {

	static boolean authenticate(String username, String password) {
		User user = User.find("byMunchkinId", username.toUpperCase().trim())
				.first();
		return user != null
				//&& user.password.equals(Crypto.passwordHash(password));
				&& user.password.equals(password);
	}
}
