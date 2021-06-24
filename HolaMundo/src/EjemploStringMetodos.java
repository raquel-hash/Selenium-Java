import java.util.Locale;

public class EjemploStringMetodos {
    public static void main(String[] args) {

        String nombre = "Raquel";

        System.out.println("nombre.length = " + nombre.length());
        System.out.println("nombre.toUpperCase = " + nombre.toUpperCase());
        System.out.println("nombre.toLowerCase() = " + nombre.toLowerCase());
        System.out.println("nombre.equals(\"Raquel\") = " + nombre.equals("Raquel"));
        System.out.println("nombre.equals(\"Raquel\") = " + nombre.equals("raquel"));
        System.out.println("nombre.equalsIgnoreCase(\"raquel\") = " + nombre.equalsIgnoreCase("raquel"));
        System.out.println("nombre.compareTo(\"Raquel\") = " + nombre.compareTo("Raquel"));//Orden lexico grafico
        System.out.println("nombre.compareTo(\"Aaron\") = " + nombre.compareTo("Aaron"));
        System.out.println("nombre.charAt(0) = " + nombre.charAt(0));
        System.out.println("nombre.charAt(1) = " + nombre.charAt(1));
        System.out.println("nombre.charAt(nombre.length()-1) = " + nombre.charAt(nombre.length()-1));

        System.out.println("nombre.substring(1) = " + nombre.substring(1));
        System.out.println("nombre.substring(1,4) = " + nombre.substring(1,4));
        System.out.println("nombre.substring(4,6) = " + nombre.substring(nombre.length()-1));

        String trabalenguas = "trabalenguas";
        System.out.println("trabalenguas = " + trabalenguas.replace("a","."));
        System.out.println("trabalenguas = " + trabalenguas);
        System.out.println("trabalenguas.indexOf('a') = " + trabalenguas.indexOf('a'));
        System.out.println("trabalenguas.lastIndexOf('a') = " + trabalenguas.lastIndexOf('a'));
        System.out.println("trabalenguas.indexOf('t') = " + trabalenguas.indexOf('t'));
        System.out.println("trabalenguas.contains(\"t\") = " + trabalenguas.contains("t"));

        System.out.println("trabalenguas.startsWith(\"tr\") = " + trabalenguas.startsWith("tr"));
        System.out.println("trabalenguas.endsWith(\"lenguas\") = " + trabalenguas.endsWith("lenguas"));
        System.out.println("  trabalenguas  ");
        System.out.println("  trabalenguas  ".trim());
    }
}
