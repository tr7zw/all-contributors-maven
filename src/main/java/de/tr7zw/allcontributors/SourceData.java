package de.tr7zw.allcontributors;

import lombok.Data;

@Data
public class SourceData {

	private String projectName;
	private String projectOwner;
	private String[] files;
	private int imageSize;
	private Contributor[] contributors;
	private String repoType;
	private int contributorsPerLine = 7;
	private String repoHost;
	private String commitConvention;
	private boolean skipCi = true;

	@Data
	public static class Contributor {
		private String login;
		private String name;
		private String avatar_url;
		private String profile;
		private String[] contributions;
		
	}

}
