package pro_four;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

class ArticleSource {

	private String id;
	private String name;

	@JsonCreator
	private ArticleSource(@JsonProperty("id") String id,
			@JsonProperty("name") String name) {
		this.id = id;
		this.name = name;
	}

	String getId() {
		return this.id;
	}

	String getName() {
		return this.name;
	}

}
