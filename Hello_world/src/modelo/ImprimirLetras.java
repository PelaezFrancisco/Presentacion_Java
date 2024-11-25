package modelo;

public class ImprimirLetras implements Runnable {
	public void run() {
        for (char c = 'A'; c <= 'E'; c++) {
            System.out.print(c);
        }
    }
}
