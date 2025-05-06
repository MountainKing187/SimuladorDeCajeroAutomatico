import java.util.Scanner;

public class Cajero {

    private static int saldo = 100000;
    private static Scanner scanner = new Scanner(System.in);

    /**
     * Ejecuta el menú principal del programa y gestiona la interacción con el usuario.
     */
    public static void menu() {
        // TODO: Implementar el código para gestionar la interacción con el usuario.
    }

    /**
     * Muestra el menú principal con las opciones disponibles.
     */
    private static void mostrarOpciones() {
        // TODO: Implementar el código para mostrar las opciones del menú en pantalla.
    }

    /**
     * Ejecuta la acción correspondiente según la opción seleccionada.
     * @param opcion Opción ingresada por el usuario.
     */
    private static void ejecutarOpcion(int opcion) {
        // TODO: Implementar la lógica para ejecutar la opción seleccionada.
    }

    /**
     * Realiza un retiro de dinero si las condiciones son válidas.
     * @param monto Monto a retirar.
     */
    public static void retirar(int monto) {
        try {
            validarMontoPositivo(monto);
            validarMultiploMil(monto);
            validarSaldoSuficiente(monto);

            saldo -= monto;
        } catch (IllegalArgumentException iae){
            System.out.println("Error al retirar fondos: " + iae.getMessage());
        }
    }

    /**
     * Deposita un monto de dinero al saldo, si es válido.
     * @param monto Monto a depositar.
     */
    public static void depositar(int monto) {
        try {
            validarMontoPositivo(monto);
            validarMultiploMil(monto);

            saldo += monto;
        } catch (IllegalArgumentException iae){
            System.out.println("Error al depositar fondos: " + iae.getMessage());
        }
    }

    /**
     * Retorna el saldo disponible en la cuenta simulada.
     * @return Saldo actual.
     */
    public static int obtenerSaldo() {
        System.out.println("Su saldo es de: $" + saldo + " Pesos");
        return saldo;
    }

    /**
     * Reinicia el saldo a un valor inicial fijo (usado en pruebas).
     */
    public static void reiniciarSaldo() {
        saldo = 100000;
    }

    public static void validarMontoPositivo(int monto){
        if(monto <= 0){
            throw new IllegalArgumentException("El monto debe ser mayor que cero.");
        }
    }

    public static void validarMultiploMil (int monto){
        if(monto % 1000 != 0){
            throw new IllegalArgumentException("El monto debe ser un multiplo de 1000.");
        }
    }

    public static void validarSaldoSuficiente(int monto){
        if (monto > saldo){
            throw new IllegalArgumentException("El monto no debe exceder saldo disponible.");
        }
    }
}