package lab_7;

class ReadCommand implements ICommand {
	
	Document document;
	
	public ReadCommand(Document document) {
		this.document = document;
	}

	public void execute() {
		this.document.readFile();
	}

}
