package com.demo.katcha.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.yaml.snakeyaml.Yaml;

/**
 * Created by william.russell on 8/28/17.
 *
 * Fake File, just to load the yml.
 *
 * currently hardcoded to general.yml
 */
public class DotUtil {

	static JSONObject object;

	private static void loadYaml() {
		InputStream fis = DotUtil.class.getClassLoader().getResourceAsStream("sites/general.yml");

		Yaml yaml = new Yaml();

		Map<String, Object> map = new HashMap<String, Object>();
		try {
			FileInputStream fin = new FileInputStream(
					System.getProperty("user.dir") + "/src/test/resources/sites/general.yml");
			map = (Map<String, Object>) yaml.load(fin);
			fin.close();

		} catch (Exception e) {
			System.out.println(e);
		}
		object = new JSONObject(map);
	}

	public static JSONObject getProperty(String dotNotation) {
		if (object == null) {
			loadYaml();
		}

		String[] parts = dotNotation.split("\\.");

		JSONObject shallow = new JSONObject(object.toString());
		for (int i = 0; i < parts.length; i++) {
			shallow = shallow.getJSONObject(parts[i]);
		}
		return shallow;
	}

}
