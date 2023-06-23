package pro_three;

import java.io.IOException;

class SourceFormat {

	private Source source;
	private Format format;
    
    public SourceFormat(Source source, Format format) {
        if (source == Source.URL && format == Format.SIMPLE) {
            throw new IllegalArgumentException("Invalid inputs.");
          }
          else {
			this.format = format;
			this.source = source;
          }
    }

    Source getSource() {
        return this.source;
    }

    Format getFormat() {
        return this.format;
    }

	Parser accept(String sourceInput) throws IOException {
		if (this.source == Source.URL && this.format == Format.NOTSIMPLE) {
			Parser parser = new ParserUrl(Main.logger);
			parser.visit(sourceInput);
			return parser;
		} else if (this.source == Source.FILE && this.format == Format.NOTSIMPLE) {
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
