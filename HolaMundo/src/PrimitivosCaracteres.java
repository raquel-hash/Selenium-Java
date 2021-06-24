public class PrimitivosCaracteres {
    public static void main(String[] args) {
        char caracter = '\u0040';
        char decimal = 64;
        System.out.println("caracter = " + caracter);
        System.out.println("decimal = " + decimal);
        System.out.println("decimal = caracter " + (decimal == caracter));

        char simbolo = '@';
        System.out.println("simbolo = " + simbolo);
        System.out.println("simbolo = caracter " + (simbolo == caracter));

        char espacio = ' ';
        char retroceso = '\b';
        char tabulador = '\t';
        char nuevaLinea = '\n';
        char retornoCarro = '\r';

        System.out.println("Char en \t byte ="+ System.lineSeparator() + Character.BYTES);
        System.out.println("Char en bits= " + Character.SIZE);
        System.out.println("Maximo valor de char = " + Character.MAX_VALUE);
        System.out.println("Minimo valor de char = " + Character.MIN_VALUE);

    }
}
