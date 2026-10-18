package ec.edu.udla.texppres.modulo2;

import java.time.LocalDateTime;

/**
 * Clase que gestiona la programacion de Horarios de Despacho para una Ruta.
 */
public class HorarioDespacho {
    private String idDespacho;
    private String idRuta;
    private LocalDateTime horaSalida;
    private LocalDateTime horaLlegadaEstimada;
    private String estado; // "Programado", "En Transito", "Completado", "Cancelado"

    public HorarioDespacho(String idDespacho, String idRuta, LocalDateTime horaSalida, LocalDateTime horaLlegadaEstimada) {
        this.idDespacho = idDespacho;
        this.idRuta = idRuta;
        this.horaSalida = horaSalida;
        this.horaLlegadaEstimada = horaLlegadaEstimada;
        this.estado = "Programado";
    }

    public void programarSalida() {
        this.estado = "Programado";
    }

    public void actualizarEstado(String nuevoEstado) {
        this.estado = nuevoEstado;
    }

    // Getters y Setters
    public String getIdDespacho() { return idDespacho; }
    public void setIdDespacho(String idDespacho) { this.idDespacho = idDespacho; }

    public String getIdRuta() { return idRuta; }
    public void setIdRuta(String idRuta) { this.idRuta = idRuta; }

    public LocalDateTime getHoraSalida() { return horaSalida; }
    public void setHoraSalida(LocalDateTime horaSalida) { this.horaSalida = horaSalida; }

    public LocalDateTime getHoraLlegadaEstimada() { return horaLlegadaEstimada; }
    public void setHoraLlegadaEstimada(LocalDateTime horaLlegadaEstimada) { this.horaLlegadaEstimada = horaLlegadaEstimada; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}
