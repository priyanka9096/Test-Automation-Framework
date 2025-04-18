package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.constants.Env;
import com.google.gson.Gson;
import com.ui.pojo.Config;
import com.ui.pojo.Environment;

public class JSONUtitlity {

	public static Environment readJSON(Env env) {

		Gson gson = new Gson();
//		Gson gson = new GsonBuilder()
//	            .serializeNulls()
//	            .setLenient()
//	            .create();
		File jsonFile = new File(System.getProperty("user.dir") + "\\config\\config.json");
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(jsonFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Config config = gson.fromJson(fileReader, Config.class);
		Environment environment=config.getEnvironment().get("QA");
		return environment;

	}
}
