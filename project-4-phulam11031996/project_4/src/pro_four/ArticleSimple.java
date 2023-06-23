package pro_four;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

class ArticleSimple {

	private String title = "";
	private String description = "";
	private String url = "";
	private String publishedAt = "";

	@JsonCreator
	private ArticleSimple(@JsonProperty("title") String title,
			@JsonProperty("description") String description,
			@JsonProperty("publishedAt") String publishedAt,
			@JsonProperty("url") String url) {
		this.url = url;
		this.title = title;
		this.description = description;
		this.publishedAt = publishedAt;
	}

	String getTitle() {
		return this.title;
	}

	String getDescription() {
		return this.description;
	}

	String getUrl() {
		return this.url;
	}

	String getPublishedAt() {
		return this.publishedAt;
	}

	public String toString() {
		StringBuilder resultStr = new StringBuilder();
		resultStr.append(this.title + "\n");
		resultStr.append(this.description + "\n");
		resultStr.append(this.publishedAt + "\n");
		resultStr.append(this.url + "\n");
		return resultStr.toString();
	}

}
