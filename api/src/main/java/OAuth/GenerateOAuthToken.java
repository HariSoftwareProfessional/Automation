package OAuth;

import java.util.ArrayList;
import org.json.JSONObject;

public class GenerateOAuthToken {
	private static StringBuilder jsonData = new StringBuilder();

	/*
	 * Code to generate and return the OAuth token for the web Service calls
	 * 
	 * @return
	 * 
	 * @throws JSONException
	 * 
	 * @throws Exception
	 */

	public static ArrayList<String> getToken() {

		ArrayList<String> output = new ArrayList<String>();
		String OAuthurl = "OAuthurl";
		String clientId = "clientId";
		String clientSecret = "clientSecret";
		String scope = "scope";
		String grantType = "grantType";
		String username = "username";
		String userpass = "userpass";
		Token token = new wiqa.tools.services.auth.Token(OAuthurl);

		token.setUsername(username);
		token.setPassword(userpass);
		token.setClient_id(clientId);
		token.setClient_secret(clientSecret);
		token.setScope(scope);
		token.setGrant_type(grantType);

		JSONObject obj = new JSONObject(token.issueToken());

		output.add(obj.getString("token_type"));
		output.add(obj.getString("access_token"));
		return output;

	}

}
