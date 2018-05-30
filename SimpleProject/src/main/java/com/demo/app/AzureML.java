package com.demo.app;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import com.demo.pojo.Customer;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

@Component
public class AzureML {
	// public static JSONObject inpParms;
	public static String apikey;
	public static String apiurl;
	public static String jsonBody;

	/**
	 * Read the JSON schema from the file rrsJson.json
	 * 
	 * @param filename
	 *            It expects a fully qualified file name that contains input
	 *            JSON file
	 */
	public void readJson(String filename) {
		try {
			ClassLoader classLoader = getClass().getClassLoader();
			File apiFile = new File(classLoader.getResource(filename).getFile());
			// File apiFile = new File(filename);
			Scanner sc = new Scanner(apiFile);
			jsonBody = "";
			while (sc.hasNext()) {
				jsonBody += sc.nextLine() + "\n";
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	/**
	 * Read the API key and API URL of Azure ML request response REST API
	 * 
	 * @param filename
	 *            fully qualified file name that contains API key and API URL
	 */
	public static void readApiInfo(String filename) {

		try {
			File apiFile = new File(filename);
			Scanner sc = new Scanner(apiFile);

			apiurl = sc.nextLine();
			apikey = sc.nextLine();

		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	/**
	 * Call REST API for retrieving prediction from Azure ML
	 * 
	 * @return response from the REST API
	 */
	public List<Customer> rrsHttpPost() {
		System.out.println("Start ---- Inside rrsHttpPost");
		// apikey =
		// "PGFDndQhF/0t0AQows82WSZPbMPNwn0lj/4kSUONEDeEosXOr1H/qdqXqDGwB5iIe0+S5ZUliX2kuN6dLFY74Q==";
		// jsonBody = "";
		// apiurl =
		// "https://ussouthcentral.services.azureml.net/workspaces/5a76d80162fd466ba385c47c07530903/services/3265986ba99f4ea28fbb2d2d05439397/execute?api-version=2.0&details=true";
		apikey = "Ohg41Ixi6i0bPoXYSGczN9qQEaP48lUcBsaX2dKmH7cQmUlRwQpqMBFCvs/AuSppKNzaHv7nXyOapOvPxHOe5w==";
		apiurl = "https://ussouthcentral.services.azureml.net/workspaces/2f4a475f6ef5482fb497114a71f8919a/services/ea105c62bb364199b6566701dc1b35dc/execute?api-version=2.0&details=true";
		HttpPost post;
		HttpClient client;
		StringEntity entity;
		HttpResponse authResponse = null;
		List<Customer> customers = new ArrayList<Customer>();
		try {
			// create HttpPost and HttpClient object
			post = new HttpPost(apiurl);
			client = HttpClientBuilder.create().build();

			// setup output message by copying JSON body into
			// apache StringEntity object along with content type
			entity = new StringEntity(jsonBody, HTTP.UTF_8);
			entity.setContentEncoding(HTTP.UTF_8);
			entity.setContentType("text/json");

			// add HTTP headers
			post.setHeader("Accept", "text/json");
			post.setHeader("Accept-Charset", "UTF-8");

			// set Authorization header based on the API key
			post.setHeader("Authorization", ("Bearer " + apikey));
			post.setEntity(entity);

			// Call REST API and retrieve response content
			authResponse = client.execute(post);
			System.out.println("http response");
			// System.out.println(EntityUtils.toString(authResponse.getEntity()));
			JsonElement jElement = new JsonParser().parse(EntityUtils
					.toString(authResponse.getEntity()));
			JsonObject jObject = jElement.getAsJsonObject();
			// JSONParser jsonParser = new JSONParser();
			// JsonObject json = (JsonObject)
			// jsonParser.parse(EntityUtils.toString(authResponse.getEntity()));
			System.out.println("json object");
			// String values =
			// json.get("Results").getAsJsonObject().get("output1").getAsJsonObject().get("value").getAsJsonObject().get("Values").getAsJsonArray().toString();
			// String values =
			// jObject.getAsJsonObject("Results").getAsJsonObject("output1").getAsJsonObject("value").getAsJsonArray("Values").toString();
			// System.out.println("fetched Results" + values);

			Gson gson = new Gson();
			JsonArray jsonArray = jObject.getAsJsonObject("Results")
					.getAsJsonObject("output1").getAsJsonObject("value")
					.getAsJsonArray("Values");
			System.out.println("jsonArray "+ jsonArray);

			int length = jsonArray.size();

			for (int i = 0; i < length; i++) {
				JsonElement jElement1 = jsonArray.get(i);
				JsonArray jsonArray1 = jElement1.getAsJsonArray();
				Customer cust = new Customer();
				cust.setClosureStatus(jsonArray1.get(0).getAsString());
				cust.setLocation(jsonArray1.get(1).getAsString());
				cust.setEmailAvailable(jsonArray1.get(2).getAsString());
				cust.setPhoneAvailable(jsonArray1.get(3).getAsString());
				cust.setOfferRejectionReasonAvailable(jsonArray1.get(4)
						.getAsString());
				cust.setExistingCustomer(jsonArray1.get(5).getAsString());
				cust.setCallStatusAbandoned(jsonArray1.get(6).getAsString());
				cust.setCallStatusDepleted(jsonArray1.get(7).getAsString());
				cust.setCallStatusExpired(jsonArray1.get(8).getAsString());
				cust.setCallStatusNew(jsonArray1.get(9).getAsString());
				cust.setCallStatusRedialAutomatic(jsonArray1.get(10)
						.getAsString());
				cust.setCallStatusRedialManualCommon(jsonArray1.get(11)
						.getAsString());
				cust.setCallStatusRedialManualPrivate(jsonArray1.get(12)
						.getAsString());
				cust.setCallStatusUserProcessed(jsonArray1.get(13)
						.getAsString());
				cust.setCallResultDataError(jsonArray1.get(14).getAsString());
				cust.setCallResultOffersAccepted(jsonArray1.get(15)
						.getAsString());
				cust.setCallResultOffersRejected(jsonArray1.get(16)
						.getAsString());
				cust.setCallResultOffersSubmitted(jsonArray1.get(17)
						.getAsString());
				cust.setCallResultUnknown(jsonArray1.get(18).getAsString());
				cust.setCallCount(jsonArray1.get(19).getAsString());
				cust.setOfferAccepted(jsonArray1.get(20).getAsString());
				cust.setScoredLabels(jsonArray1.get(21).getAsString());
				cust.setScoredProbabilities(jsonArray1.get(22).getAsString());
				customers.add(cust);
			}

			/*ArrayList<Customer> objectArray = gson.fromJson(
					jsonArray.toString(), new TypeToken<List<Customer>>() {
					}.getType());
			System.out.println("objectArray " + objectArray);*/
			/*
			 * Class<Customer[]> customerArray = (Class<Customer[]>)
			 * ((Customer[]) Array.newInstance(customer, 0)).getClass();
			 * Customer[] objectArray = gson.fromJson(jsonArray, customerArray);
			 */
			return customers;

			/*
			 * String json = EntityUtils.toString(authResponse.getEntity());
			 * customers = Stream.of(gson.fromJson(json, JsonObject.class)
			 * .getAsJsonObject("Results") .getAsJsonObject("output1")
			 * .getAsJsonObject("value") .getAsJsonArray("Values")) .flatMap(e
			 * -> Stream.of(gson.fromJson(e, Customer[].class)))
			 * .collect(Collectors.toList()); /*Gson gson = new Gson(); String
			 * json = EntityUtils.toString(authResponse.getEntity()); customers
			 * = Stream.of(gson.fromJson(json, JsonObject.class)
			 * .getAsJsonObject("Results") .getAsJsonObject("output1")
			 * .getAsJsonObject("value") .getAsJsonArray("Values")) .flatMap(e
			 * -> Stream.of(gson.fromJson(e, Customer[].class)))
			 * .collect(Collectors.toList());
			 */

			// return EntityUtils.toString(authResponse.getEntity());
			// return customers;
		} catch (Exception e) {

			// return e.toString();
			// return authResponse;
		}
		return customers;

	}

	/**
	 * @param args
	 *            the command line arguments specifying JSON and API info file
	 *            names
	 */
	public static void main(String[] args) {
		// check for mandatory argments. This program expects 2 arguments
		// first argument is full path with file name of JSON file and
		// second argument is full path with file name of API file that contains
		// API URL and API Key of request response REST API
		/*
		 * if (args.length < 2) { System.out.println(
		 * "Incorrect usage. Please use the following calling pattern");
		 * System.out
		 * .println("java AzureML_RRSApp <jsonFilename> <apiInfoFilename>"); }
		 */

		try {
			AzureML ml = new AzureML();
			// read JSON file name
			String jsonFile = args[0];
			// read API file name
			// String apiFile = args[1];

			// call method to read API URL and key from API file
			// readApiInfo(apiFile);

			// call method to read JSON input from the JSON file
			ml.readJson(jsonFile);

			// print the response from REST API
			// System.out.println(ml.rrsHttpPost());
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

}
