package curso1SI.threads;

public class ThreadEjemplo extends Thread {
	private Thread t;
	private String threadName;

	ThreadEjemplo(String name) {
		threadName = name;
		System.out.println("Creando " + threadName);
	}

	public void run() {
		System.out.println("Ejecutando " + threadName);
		try {
			for (int i = 4; i > 0; i--) {
				System.out.println("Thread: " + threadName + ", " + i);
				Thread.sleep(50);
			}
		} catch (InterruptedException e) {
			System.err.println("Thread " + threadName + " interrumpido");
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
		ThreadEjemplo T1 = new ThreadEjemplo("Thread-UNO");
		T1.start();

		ThreadEjemplo T2 = new ThreadEjemplo("Thread-DOS");
		T2.start();
	}
}
