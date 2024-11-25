package modelo;

//Clase abstracta
abstract class Forma {
 abstract void dibujar(); // Método abstracto (sin implementación)

 void descripcion() { // Método concreto (con implementación)
     System.out.println("Soy una forma geométrica.");
 }
}

//Subclase concreta
class Circulo extends Forma {
 @Override
 void dibujar() {
     System.out.println("Dibujando un círculo.");
 }
}

//Subclase concreta
class Cuadrado extends Forma {
 @Override
 void dibujar() {
     System.out.println("Dibujando un cuadrado.");
 }
}
