package pro_four;

import java.io.IOException;

class SourceFormat {
	private InputSource source;
	private InputFormat format;
	private InputArticleSource articleSource = null;

	public SourceFormat(InputSource source, InputFormat format) {
		if (source == InputSource.URL && format == InputFormat.SIMPLE) {
			throw new IllegalArgumentException("Invalid inputs.");
		} else {
			this.format = format;
			this.source = source;
		}
	}

	public SourceFormat(InputSource source, InputFormat format, InputArticleSource articleSource) {
		if (format == InputFormat.SIMPLE) {
			throw new IllegalArgumentException("Invalid inputs.");
		} else {
			this.format = format;
			this.source = source;
			this.articleSource = articleSource;
		}
	}

	InputSource getSource() {
		return this.source;
	}

	InputFormat getFormat() {
		return this.format;
	}

	InputArticleSource getAricleSource() {
		return this.articleSource;
	}

	Parser accept(String sourceInput) throws IOException {
		if (this.articleSource != null) {
			Parser parser;
			if (this.source == InputSource.URL) {
				parser = new ParserUrl(Main.logger);
			} else {
				parser = new ParserNewsApi(Main.logger);
			}
			DecoratorArticleSourceFilter decoratorParser = new DecoratorArticleSourceFilter(parser, articleSource);
			decoratorParser.visit(sourceInput);
			return parser;
		} else if (this.source == InputSource.URL && this.format == InputFormat.NOTSIMPLE) {
			Parser parser = new ParserUrl(Main.logger);
			parser.visit(sourceInput);
			return parser;

		} else if (this.source == InputSource.FILE && this.format == InputFormat.NOTSIMPLE) {
			Parser parser = new ParserNewsApi(Main.logger);
			parser.visit(sourceInput);
			return parser;

		} else {
			Parser parser = new ParserSimple(Main.logger);
			parser.visit(sourceInput);
			return parser;
		}
	}

}
