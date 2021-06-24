import java.util.Locale;

public class EjemploStringValidar {
    public static void main(String[] args) {
        String curso = null;
        
        boolean isNull = curso ==null;

        System.out.println("isNull = " + isNull);

        if(isNull){
            curso = "Programacion Java";
        }
        
        boolean isEmpty = curso.length() == 0;
        System.out.println("isEmpty = " + isEmpty);
        
        boolean isEmpty2 = curso.isEmpty();
        System.out.println("isEmpty2 = " + isEmpty2);

        boolean isBlank = curso.isBlank();// la forma mas segura de validar tiene todas las combinaciones
        System.out.println("isBlank = " + isBlank);
        
        if(isBlank==false){
            System.out.println(curso.toUpperCase());
            System.out.println("Bienvenido al curso " .concat(curso));//concat usamos cuando el objeto se instancia y no es nulo
        }
    }
}
