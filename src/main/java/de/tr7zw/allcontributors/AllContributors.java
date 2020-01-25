package de.tr7zw.allcontributors;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import com.google.gson.Gson;

import de.tr7zw.allcontributors.SourceData.Contributor;

/**
 * Goal which updates the allcontributors section in the readme.md
 *
 */
@Mojo(name = "update", defaultPhase = LifecyclePhase.GENERATE_RESOURCES)
public class AllContributors extends AbstractMojo {

	private Gson gson = new Gson();
	private static final String HEADER = "<!-- ALL-CONTRIBUTORS-LIST:START - Do not remove or modify this section -->";
	private static final String FOOTER = "<!-- ALL-CONTRIBUTORS-LIST:END -->";

	/**
	 * Root directory of the project
	 */
	@Parameter(defaultValue = "${project.basedir}", property = "basedir", required = true)
	private File projectDirectory;
	/**
	 * Readme filename
	 */
	@Parameter(defaultValue = "README.md", property = "readme", required = true)
	private String readmeFileName;
	/**
	 * src filename
	 */
	@Parameter(defaultValue = ".all-contributorsrc", property = "srcFile", required = true)
	private String srcFileName;

	public void execute() throws MojoExecutionException {
		File readme = new File(projectDirectory, readmeFileName);
		if (!readme.exists()) {
			super.getLog().warn("Unable to find README at '" + readme.getAbsolutePath() + "'! Skipping!");
			return;
		}

		File src = new File(projectDirectory, srcFileName);
		if (!src.exists()) {
			super.getLog().warn("Unable to find contributorsrc at '" + src.getAbsolutePath() + "'! Skipping!");
			return;
		}

		SourceData data;
		try {
			data = gson.fromJson(new String(Files.readAllBytes(src.toPath()), StandardCharsets.UTF_8),
					SourceData.class);
		} catch (Exception e) {
			throw new MojoExecutionException("Error reading src file!", e);
		}

		String readmeData;
		try {
			readmeData = new String(Files.readAllBytes(readme.toPath()), StandardCharsets.UTF_8);
		} catch (Exception e) {
			throw new MojoExecutionException("Error reading readme file!", e);
		}

		int startIndex = readmeData.indexOf(HEADER);
		int stopIndex = readmeData.indexOf(FOOTER);

		if ((startIndex != -1 && stopIndex == -1) || (startIndex == -1 && stopIndex != -1)) {
			throw new MojoExecutionException(
					"The 'ALL-CONTRIBUTORS-LIST' tags are invalid/modified! Please fix the README.md!");
		}

		if (startIndex == -1 && stopIndex == -1) { // Not yet added
			super.getLog().warn("Contributors block not found! Generating at the end of the readme!");
			readmeData = readmeData + "\n" + generateTable(data);
		} else { // Replace block
			readmeData = readmeData.replace(readmeData.subSequence(startIndex, stopIndex + FOOTER.length()),
					generateTable(data));
		}

		int offset = 0;
		while (true) {
			Pattern pattern = Pattern.compile("https://img.shields.io/badge/all_contributors-([0-9]+)-");
			Matcher matcher = pattern.matcher(readmeData);
			int i = 0;
			while(i < offset) {
				matcher.find();
				i++;
			}
			if (matcher.find()) {
				readmeData = readmeData.substring(0, matcher.start(1)) + data.getContributors().length
						+ readmeData.substring(matcher.end(1), readmeData.length());
				offset++;
			}else {
				break;
			}
		}

		try {
			Files.write(readme.toPath(), readmeData.getBytes(StandardCharsets.UTF_8));
			super.getLog().info("Updated the readme file!");
		} catch (Exception e) {
			throw new MojoExecutionException("Error writing readme file!", e);
		}
	}

	private String generateTable(SourceData data) {
		StringBuilder builder = new StringBuilder();
		builder.append("<!-- ALL-CONTRIBUTORS-LIST:START - Do not remove or modify this section -->\n"
				+ "<!-- prettier-ignore-start -->\n" + "<!-- markdownlint-disable -->\n"); // Header
		builder.append("<table>\n");

		List<Contributor> contributors = new ArrayList<SourceData.Contributor>(Arrays.asList(data.getContributors()));
		while (!contributors.isEmpty()) {
			builder.append("  <tr>\n");
			for (int i = 0; i < data.getContributorsPerLine(); i++) {
				if (contributors.isEmpty())
					break;
				addContributor(builder, data, contributors.remove(0));
			}
			builder.append("  </tr>\n");
		}

		builder.append("</table>\n");
		builder.append("<!-- markdownlint-enable -->\n" + "<!-- prettier-ignore-end -->\n"
				+ "<!-- ALL-CONTRIBUTORS-LIST:END -->\n"); // Footer
		return builder.toString();
	}

	private void addContributor(StringBuilder builder, SourceData data, Contributor cont) {
		builder.append("    <td align=\"center\">");
		builder.append("<a href=\"" + cont.getProfile() + "\">");
		builder.append("<img src=\"" + cont.getAvatar_url() + "\" width=\"100px;\" alt=\"\"/><br />");
		builder.append("<sub><b>" + cont.getName() + "</b></sub></a><br />");
		boolean first = true;
		for (String contribution : cont.getContributions()) {
			if (first) {
				first = false;
			} else {
				builder.append(" ");
			}
			addContribiution(builder, data, ContributionType.getType(contribution), cont);
		}
		builder.append("</td>\n");
	}

	private void addContribiution(StringBuilder builder, SourceData data, ContributionType type, Contributor cont) {
		String url = "#" + type.name() + "-" + cont.getLogin();
		if (type.getUrl() != null) {
			url = data.getRepoHost() + "/" + data.getProjectOwner() + "/" + data.getProjectName() + "/"
					+ type.getUrl().replace("%login%", cont.getLogin());
		}
		builder.append("<a href=\"" + url + "\" title=\"" + type.getName() + "\">" + type.getEmoji() + "</a>");
	}

}
