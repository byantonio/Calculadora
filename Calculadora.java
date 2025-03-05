import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Calculadora {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("-------MENÚ-------");
        System.out.println("1. Sumar");
        System.out.println("2. Restar");
        System.out.println("3. Multiplicar");
        System.out.println("4. Dividir");
        System.out.print("Seleccione una opción: ");

        int opcion = sc.nextInt();

        System.out.print("Ingrese el primer número: ");
        double num1 = sc.nextDouble();

        System.out.print("Ingrese el segundo número: ");
        double num2 = sc.nextDouble();

        try {
            double resultado = calculadora(num1, num2, opcion);
            System.out.println("El resultado es: " + resultado);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }

    public static double sumar(double num1, double num2) {
        System.out.println("Realizando suma...");
        return num1 + num2;
    }

    public static double restar(double num1, double num2) {
        System.out.println("Realizando resta...");
        return num1 - num2;
    }

    public static double multiplicar(double num1, double num2) {
        System.out.println("Realizando multiplicación...");
        return num1 * num2;
    }

    public static double dividir(double num1, double num2) {
        if (num2 == 0) {
            System.out.println("Se va a lanzar una excepción por división entre cero...");
            throw new ArithmeticException("No se puede dividir por cero.");
        }
        System.out.println("Realizando división...");
        return num1 / num2;
    }

    public static double calculadora(double num1, double num2, int opcion) {
        switch (opcion) {
            case 1:
                return sumar(num1, num2);
            case 2:
                return restar(num1, num2);
            case 3:
                return multiplicar(num1, num2);
            case 4:
                return dividir(num1, num2);
            default:
                throw new IllegalArgumentException("Opción no válida.");
        }
    }

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        System.out.println("---Inicio de las pruebas---");
    }
    @AfterAll
    static void tearDownAfterClass() throws Exception {
        System.out.println("---Final de las pruebas---");
    }


    @Test
    public void testDividir() {
        // Verifica que la división de 10 y -5 sea -2
        assertEquals(-2.0, Calculadora.dividir(10, -5), "División de 10 y -5 debe ser -2");

        // Verifica que la división por cero lance una excepción
        assertThrows(ArithmeticException.class, () -> Calculadora.dividir(10, 0), "División por cero debe lanzar ArithmeticException");
    }
}
