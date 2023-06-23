package lab_7;

import static org.junit.jupiter.api.Assertions.*;

class Test {

	@org.junit.jupiter.api.Test
	void testWrite() {
		Invoker invoke = new Invoker();
		ICommand command = invoke.executeDocument(new WriteCommand(new Document()));

		assertEquals(command, invoke.getCommandQ().get(0));
	}

	@org.junit.jupiter.api.Test
	void testRead() {
		Invoker invoke = new Invoker();
		ICommand command1 = invoke.executeDocument(new WriteCommand(new Document()));
		ICommand command2 = invoke.executeDocument(new ReadCommand(new Document()));

		assertEquals(command1, invoke.getCommandQ().get(0));
		assertEquals(command2, invoke.getCommandQ().get(1));
	}

}
