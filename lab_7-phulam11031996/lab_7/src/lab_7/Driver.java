package lab_7;

class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Invoker invoke = new Invoker();
		invoke.executeDocument(new WriteCommand(new Document()));
		invoke.executeDocument(new WriteCommand(new Document()));
		invoke.executeDocument(new WriteCommand(new Document()));
		invoke.executeDocument(new ReadCommand(new Document()));
		
		invoke.displayCommand();
		invoke.reverseCommand();

	}

}
