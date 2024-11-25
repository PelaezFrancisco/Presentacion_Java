package vista;

import controlador.EdadInvalidaException;
import modelo.Contador;
import modelo.ImprimirLetras;
import modelo.ImprimirNumeros;
import modelo.MiHilo;
import modelo.MiTarea;
import modelo.Producto;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Hola Mundo! :)");
		
		//creamos el objeto
		Producto agua = new Producto();
		
		//stemoas valores
		agua.setNombre("Agua");
		agua.setPrecio(0.5);
		
		//hacemos los gets
		System.out.println("Mi producto es "+agua.getNombre()+" y el precio es "+ agua.getPrecio());
		
		
		int resultado = 0;
		try {
		    resultado = 10 / 0;
		} catch (ArithmeticException e) {
		    System.out.println("Error: División por cero.");
		}

		System.out.println(resultado);
		
		
		int edad = 15;
		try {
			if (edad < 18) {
				throw new EdadInvalidaException("Edad no válida para registrarse.");
			}
		} catch (EdadInvalidaException e) {
			System.out.println("Excepción: " + e.getMessage());
		}
		
		
		//Collections
		
		ArrayList<String> tareas = new ArrayList<>();
        tareas.add("Estudiar Java");
        tareas.add("Hacer ejercicio");
        tareas.add("Leer un libro");
        
        System.out.println("Tareas pendientes:");
        for (String tarea : tareas) {
            System.out.println("- " + tarea);
        }
        
        tareas.remove("Hacer ejercicio");
        System.out.println("\nTareas actualizadas: " + tareas);
        
        //Maps
        HashMap<Integer, String> estudiantes_Map = new HashMap<>();
        estudiantes_Map.put(1, "Ana");
        estudiantes_Map.put(2, "Juan");
        estudiantes_Map.put(1, "Lucía"); // Sobrescribe el valor para la clave 1

        System.out.println("Mapa de estudiantes: " + estudiantes_Map);
        System.out.println("Estudiante con ID 1: " + estudiantes_Map.get(1));
        
        
        
     // Crear un HashMap para almacenar estudiantes (clave: ID, valor: Nombre)
        HashMap<Integer, String> estudiantes = new HashMap<>();

        // 1. Añadir estudiantes al HashMap
        estudiantes.put(1, "Juan");
        estudiantes.put(2, "Ana");
        estudiantes.put(3, "Luis");

        // Mostrar los estudiantes registrados
        System.out.println("Estudiantes registrados: " + estudiantes);

        // 2. Buscar un estudiante por ID
        int idBuscado = 2;
        if (estudiantes.containsKey(idBuscado)) {
            System.out.println("Estudiante con ID " + idBuscado + ": " + estudiantes.get(idBuscado));
        } else {
            System.out.println("No se encontró al estudiante con ID " + idBuscado);
        }

        // 3. Actualizar el nombre de un estudiante
        estudiantes.put(3, "Lucía"); // Actualizamos el ID 3 a "Lucía"
        System.out.println("Estudiantes después de la actualización: " + estudiantes);

        // 4. Eliminar un estudiante
        int idEliminar = 1;
        if (estudiantes.containsKey(idEliminar)) {
            estudiantes.remove(idEliminar);
            System.out.println("Estudiante con ID " + idEliminar + " eliminado.");
        } else {
            System.out.println("No se encontró al estudiante con ID " + idEliminar);
        }

        // 5. Imprimir todos los estudiantes restantes
        System.out.println("Estudiantes actuales: " + estudiantes);

        // Recorrer el HashMap usando un bucle
        System.out.println("\nLista detallada de estudiantes:");
        for (Integer id : estudiantes.keySet()) {
            System.out.println("ID: " + id + ", Nombre: " + estudiantes.get(id));
        }
        
        //-----------------------------Queues---------------------------
        Queue<String> cola = new LinkedList<>();
        cola.add("Ana");
        cola.add("Juan");
        cola.add("Lucía");

        System.out.println("Elemento procesado: " + cola.poll()); // Elimina "Ana"
        System.out.println("Siguiente elemento: " + cola.peek()); // Muestra "Juan"
        
        
        //---------------------------Hilos---------------------------------------
        
     // Usar clase que extiende Thread
        MiHilo hilo1 = new MiHilo();
        hilo1.start();

        // Usar clase que implementa Runnable
        Thread hilo2 = new Thread(new MiTarea());
        hilo2.start();
        
        //-------------------Syncronized ----------------------------
        
        Contador contador = new Contador();

        Runnable tarea = () -> {
            for (int i = 0; i < 1000; i++) {
                contador.incrementar();
            }
        };

        Thread hilo1_sincro = new Thread(tarea);
        Thread hilo2_sincro = new Thread(tarea);

        hilo1_sincro.start();
        hilo2_sincro.start();

        try {
        	hilo1_sincro.join();
        	hilo2_sincro.join();
        } catch (InterruptedException e) {
            System.out.println("Hilo interrumpido.");
        }

        System.out.println("Cuenta final: " + contador.getCuenta());
    
        //----------------------Concurrentes---------------------------
        
        Thread numeros = new ImprimirNumeros();
        Thread letras = new Thread(new ImprimirLetras());

        numeros.start();
        letras.start();

        for (int i = 0; i < 5; i++) {
            System.out.print("-Mensaje fijo-");
        }
        
	}

}
