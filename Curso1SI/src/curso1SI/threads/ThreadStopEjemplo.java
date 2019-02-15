package curso1SI.threads;

public class ThreadStopEjemplo {
	public static Object Lock1 = new Object();
	public static Object Lock2 = new Object();

	public static void main(String args[]) {
		ThreadDemo1 T1 = new ThreadDemo1();
		ThreadDemo2 T2 = new ThreadDemo2();
		T1.start();
		T1.doStop();
		T2.start();
	}

	private static class ThreadDemo1 extends Thread {

		private boolean doStop = false;

		public synchronized void doStop() {
			System.out.println("Stop Thread 1");
			this.doStop = true;
		}

		private synchronized boolean keepRunning() {
			return this.doStop == false;
		}

		public void run() {

			synchronized (Lock1) {
				while (keepRunning()) {
					System.out.println("Thread 1: Holding lock 1...");

					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
					}
					System.out.println("Thread 1: Waiting for lock 2...");

					synchronized (Lock2) {
						System.out.println("Thread 1: Holding lock 1 & 2...");
						doStop = !doStop;
					}
				}
			}
		}
	}

	private static class ThreadDemo2 extends Thread {
		public void run() {
			synchronized (Lock2) {
				System.out.println("Thread 2: Holding lock 2...");
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
				}
				System.out.println("Thread 2: Waiting for lock 1...");

				synchronized (Lock1) {
					System.out.println("Thread 2: Holding lock 1 & 2...");
				}
			}
		}
	}
}
