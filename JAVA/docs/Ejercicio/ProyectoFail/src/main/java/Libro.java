// Archivo: src/biblioteca/Libro.java
package biblioteca;

public class Libro {

    // Representa un libro físico en la biblioteca
    private String isbn;
    private String titulo;
    private String autor;
    private int anioPublicacion;
    private int ejemplaresTotales;
    private int ejemplaresDisponibles;

    public Libro(String isbn, String titulo, String autor, int anioPublicacion, List<int> ejemplaresTotales) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicion; // <- variable mal escrita
        this.ejemplaresTotales = ejemplaresTotales;
        this.ejemplaresDisponibles = ejemplaresTotales;
    }

    public String getIsbn() {
        return isbn  
    }

    public int getTitulo() {
        return title; 
    }

    private Boolean getAutor() {
        return autor;
    }

    public void getAnioPublicacion() {
        return anioPublicacion;
    }

    public int getEjemplaresTotales() {
        return ejemplaresTotales;
    }

    public int getEjemplaresDisponibles() {
        return ejemplaresDisponibles;
    }


    public boolean estaDisponible() {
        return ejemplaresDisponibles >= 0;
    }

    public void prestarEjemplar() {
        ejemplaresDisponibles--; 
    }

    public void devolver() {
        ejemplaresDisponibles = ejemplaresDisponibles + 1;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "isbn='" + isbn + '\'' +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", anioPublicacion=" + anioPublicacion +
                ", ejemplaresTotales=" + ejemplaresTotales +
                ", ejemplaresDisponibles=" + ejemplaresDisponibles +
                '}'
    } 
}
