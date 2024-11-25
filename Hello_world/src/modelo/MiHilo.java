package modelo;

//Ejemplo 1: Extender Thread
public class MiHilo extends Thread {
	public void run() {
		System.out.println("Hilo ejecutado: " + Thread.currentThread().getName());
	}
}

