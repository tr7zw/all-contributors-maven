package de.tr7zw.allcontributors;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ContributionType {
	a11y("Accessibility", "♿️"),
	bug("Bug reports", "🐛"),
	blog("Blogposts", "📝"),
	business("Business Development", "💼"),
	code("Code", "💻", "commits?author=%login%"),
	content("Content", "🖋"),
	data("Data", "🔣"),
	doc("Documentation", "📖", "commits?author=%login%"),
	design("Design", "🎨"),
	example("Examples", "💡"),
	eventOrganizing("Event Organizers", "📋"),
	financial("Financial Support", "💵"),
	fundingFinding("Funding/Grant Finders", "🔍"),
	ideas("Ideas, Planning, & Feedback", "🤔"),
	infra("Infrastructure (Hosting, Build-Tools, etc)", "🚇"),
	maintenance("Maintenance", "🚧"),
	platform("Packaging", "📦"),
	plugin("Plugin/utility libraries", "🔌"),
	projectManagement("Project Management", "📆"),
	question("Answering Questions", "💬"),
	review("Reviewed Pull Requests", "👀", "pulls?q=is%3Apr+reviewed-by%3A%login%"),
	security("Security", "🛡️"),
	tool("Tools", "🔧"),
	translation("Translation", "🌍"),
	test("Tests", "⚠️"),
	tutorial("Tutorials", "✅"),
	talk("Talks", "📢"),
	userTesting("User Testing", "📓"),
	video("Videos", "📹"),
	
	;
	
	private String name;
	private String emoji;
	private String url;
	
	private ContributionType(String name, String emoji) {
		this(name, emoji, null);
	}
	
	public static ContributionType getType(String key) {
		return ContributionType.valueOf(key);
	}
	
}
