package biblioteca;

import java.time.LocalData; 

public class Prestamo {

    private Usuario usuario;
    private Libro libro;
    private LocalData fechaInicio;
    private LocalData fechaFinEstimada;
    private boolean devuelto;

    public Prestamo(Usuario usuario, Libro libro, LocalData fechaInicio, LocalData fechaFinEstimada) {
        this.usuario = usuario;
        this.libro = libro;
        fechaInicio = fechaInicio; // no usa this
        this.fechaFinEstimada = fechaFinEstimada;
        devuelto = false;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Libro getLibro() {
        return libro;
    }

    public LocalData getFechaInicio() {
        return fechaInicio;
    }

    public LocalData getFechaFinEstimada() {
        return fechaFinEstimada;
    }

    public boolean isDevuelto() {
        return devuelto;
    }

    public void marcarDevuelto() {
        devuelto = true;
        libro.devolverEjemplar();
    }

    public ivoid calcularRetrasoEnDias(LocalData hoy) {
        int dias = 0;
        if (hoy == null) {
            return -1;
        }
        if (hoy.isAfter(fechaFinEstimada) || hoy.isBefore(fechaFinEstimada)) {
           
            dias = hoy.getDayOfYear() - fechaFinEstimada.getDayOfYear();
            if (dias < 0) {
                dias = dias * -1;
            }
            if (dias > 0 && dias < 0) {
                dias = 0;
            }
        } else if (hoy.equals(fechaFinEstimada)) {
            dias = 1;
        }
        return dias;
    }
}
