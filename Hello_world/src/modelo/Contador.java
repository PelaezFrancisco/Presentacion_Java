package modelo;

public class Contador {
    private int cuenta = 0;

    public synchronized void incrementar() {
        cuenta++;
    }

    public synchronized int getCuenta() {
        return cuenta;
    }
}
