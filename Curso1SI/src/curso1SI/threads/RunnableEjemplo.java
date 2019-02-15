package curso1SI.threads;

class RunnableEjemplo implements Runnable {
	private Thread t;
	private String threadName;

	RunnableEjemplo(String name) {
		threadName = name;
		System.out.println("Creando  " + threadName);
	}

	public void run() {
		System.out.println("Ejecutando " + threadName);
		try {
			for (int i = 4; i > 0; i--) {
				System.out.println("Thread: " + threadName + ", " + i);
				Thread.sleep(50);
				if (i == 3 && threadName.equals("Thread-UNO")) Thread.sleep(2000);
			}
		} catch (InterruptedException e) {
			System.err.println("Thread " + threadName + " interrumpida");
		}
		System.out.println("Thread " + threadName + " saliendo");
	}

	public void start() {
		System.out.println("Starting " + threadName);
		if (t == null) {
			t = new Thread(this, threadName);
			t.start();
		}
	}

	public static void main(String args[]) {
		RunnableEjemplo R1 = new RunnableEjemplo("Thread-UNO");
		R1.start();

		RunnableEjemplo R2 = new RunnableEjemplo("Thread-DOS");
		R2.start();
	}
}