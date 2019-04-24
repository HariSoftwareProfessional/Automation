package aggregationAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import OAuth.GenerateOAuthToken;

public class getMethod_XMLResponse {

	private static StringBuilder jsonData = new StringBuilder();
	private static final String PRINCIPALROLE = "CLIENT";
	private static final String USERIDTYPE = "USERIDTYPE";
	private static final String DATASTATE = "DATASTATE";
	private static final String PLANTYPE = "PLANTYPE";

	public static String getPlanDataXML(String responseFormat, String environment, String planID, String versionID,
			String TagName, String xpath) throws IOException, SAXException, ParserConfigurationException {

		StringBuilder planProvisions = new StringBuilder();
		ArrayList<String> tokenData = GenerateOAuthToken.getToken();
		System.out.println(tokenData);

		String elements;
		BufferedReader  br;
		URL url;

		url = new URL("http://privateUrl-" + environment + ".com/" + planID + "/verions/" + versionID
				+ "/planDataAggregation=true");

		HttpURLConnection con = (HttpURLConnection) url.openConnection();

		System.out.println(url);

		con.setRequestProperty("Authorization", tokenData.get(0) + " " + tokenData.get(0));
		con.setRequestProperty("Accept", "application/" + responseFormat + "");
		con.setRequestProperty("LOG-TRACKING-ID", "LOG-TRACKING-ID");
		con.setRequestProperty("PRINCIPAL-ROLE", "PRINCIPAL-ROLE");
		con.setRequestProperty("USER-ID-TYPE", "USER-ID-TYPE");
		con.setRequestProperty("USER-ID", "USER-ID");
		con.setRequestProperty("Data-state", "DATASTATE");
		con.setRequestProperty("plan-type", "PLANTYPE");
		con.setRequestProperty("content-type", "application/"+responseFormat + "");
		
		if(con.getResponseCode() != 200) {
			throw new RuntimeException("Catalog aggregation call failed:HTTP error code - "+ con.getResponseCode());
		}else {
			br=new 	BufferedReader(new InputStreamReader(con.getInputStream()));
			while((elements = br.readLine()) != null) {
				planProvisions.append(elements);
			}
			br.close();
		}
		System.out.println(planProvisions.toString());
		
		
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new StringReader(planProvisions.toString())));
		
		NodeList errNodes = doc.getElementsByTagName(TagName);
		Element err = null;
		if(errNodes.getLength()>0) {
			err=(Element)errNodes.item(0);
		}else {
			//success-do nothing
		}
		return err.getElementsByTagName(xpath).item(0).getTextContent();

	}
}
