package de.tr7zw.allcontributors;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;

@Data
public class SourceData {

	private String projectName;
	private String projectOwner;
	private int imageSize = 100;
	private Contributor[] contributors;
	private int contributorsPerLine = 7;
	private String repoHost = "https://github.com";
	private Map<String, CustomType> types = new HashMap<String, SourceData.CustomType>();

	@Data
	public static class Contributor {
		private String login;
		private String name;
		private String avatar_url;
		private String profile;
		private String[] contributions;
		private Map<String, String> links = new HashMap<String, String>();
	}

	@Data
	public static class CustomType {
		private String symbol;
		private String description;
	}

}
