package lab_7;

class WriteCommand implements ICommand {
	
	Document document;

	public WriteCommand(Document document) {
		this.document = document;
	}

	public void execute() {
		this.document.writeFile();
	}

}
