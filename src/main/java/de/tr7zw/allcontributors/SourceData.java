package de.tr7zw.allcontributors;

import lombok.Data;

@Data
public class SourceData {

	private String projectName;
	private String projectOwner;
	private int imageSize = 100;
	private Contributor[] contributors;
	private int contributorsPerLine = 7;
	private String repoHost = "https://github.com";

	@Data
	public static class Contributor {
		private String login;
		private String name;
		private String avatar_url;
		private String profile;
		private String[] contributions;
		
	}

}
