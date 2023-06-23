package lab_7;

import java.util.LinkedList;
import java.util.List;

class Invoker {

	List<ICommand> commandQ = new LinkedList<>();

	List<ICommand> getCommandQ() {
		return this.commandQ;
	}

	public ICommand executeDocument(ICommand command) {
		this.commandQ.add(command);
		command.execute();
		return command;
	}

	public void displayCommand() {
		for (ICommand command : this.commandQ) {
			System.out.println(command);
		}
	}
	public void reverseCommand() {
		for (int i = this.commandQ.size() - 1; i > -1; i--) {
			this.commandQ.get(i).execute();
		}
	}
	
}
