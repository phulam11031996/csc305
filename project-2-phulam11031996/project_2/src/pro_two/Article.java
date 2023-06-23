package pro_two;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

class Article {

	private String title = "";
	private String description = "";
	private String url = "";
	private String publishedAt;

	@JsonCreator
	private Article(@JsonProperty("title") String title,
			@JsonProperty("description") String description,
			@JsonProperty("publishDate") String publishDate,
			@JsonProperty("url") String url,
			@JsonProperty("source") Object source,
			@JsonProperty("author") String author,
			@JsonProperty("urlToImage") String urlToImage,
			@JsonProperty("publishedAt") String publishedAt,
			@JsonProperty("content") String content) {
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
