package jd.piano.teclas;

public class TeclaFactory {
    private TeclaFactory(){}
    public static Tecla crearTecla(int nota){
        // Selecciona el tipo adecuado de nota según la tabla proporcionada en la documentación.
        int resto = nota % 12;

        Tecla tecla = switch(resto) {
            case 0, 5 -> new TeclaBlanca1(nota);
            case 2, 7, 9 -> new TeclaBlanca2(nota);
            case 4, 11 -> new TeclaBlanca3(nota);
            default -> new TeclaNegra(nota);
        };
        return tecla;
    }
}
