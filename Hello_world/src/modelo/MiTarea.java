package modelo;

//Ejemplo 2: Implementar Runnable
public class MiTarea implements Runnable {
	public void run() {
	   System.out.println("Tarea ejecutada: " + Thread.currentThread().getName());
	}
}
