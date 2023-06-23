package lab_8d;

import java.util.concurrent.Semaphore;

class WordPrinter implements Runnable {

	int num;
	String str;
	Semaphore semaOne;
	Semaphore semaTwo;

	public WordPrinter(String str, int num, Semaphore semaOne, Semaphore semaTwo) {
		super();
		this.str = str;
		this.num = num;
		this.semaOne = semaOne;
		this.semaTwo = semaTwo;
	}

	@Override
	public void run() {

		if (this.str.equals("hello")) {
			try {
				for (int i = 0; i <= this.num; i++) {
					semaTwo.acquire();
					System.out.println(i);
					semaOne.release();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		} 

		if (this.str.equals("hi")) {
			try {
				for (int i = 0; i <= this.num; i++) {
					semaOne.acquire();
					System.out.println(i);
					semaTwo.release();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

