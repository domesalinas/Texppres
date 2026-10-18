package ec.edu.udla.texppres.modulo2;

import java.time.LocalDateTime;

/**
 * Clase que representa una Ruta de transporte logistico en el sistema Texppres.
 */
public class Ruta {
    private String idRuta;
    private String origen;
    private String destino;
    private double distanciaKm;
    private double tiempoEstimadoHoras;

    public Ruta(String idRuta, String origen, String destino, double distanciaKm, double tiempoEstimadoHoras) {
        this.idRuta = idRuta;
        this.origen = origen;
        this.destino = destino;
        this.distanciaKm = distanciaKm;
        this.tiempoEstimadoHoras = tiempoEstimadoHoras;
    }

    /**
     * Calcula la velocidad promedio esperada para el trayecto.
     * @return velocidad en km/h
     */
    public double calcularVelocidadPromedio() {
        if (tiempoEstimadoHoras > 0) {
            return distanciaKm / tiempoEstimadoHoras;
        }
        return 0.0;
    }

    public String obtenerDetallesRuta() {
        return "Ruta " + idRuta + ": " + origen + " -> " + destino + " (" + distanciaKm + " km, " + tiempoEstimadoHoras + " hrs)";
    }

    // Getters y Setters
    public String getIdRuta() { return idRuta; }
    public void setIdRuta(String idRuta) { this.idRuta = idRuta; }

    public String getOrigen() { return origen; }
    public void setOrigen(String origen) { this.origen = origen; }

    public String getDestino() { return destino; }
    public void setDestino(String destino) { this.destino = destino; }

    public double getDistanciaKm() { return distanciaKm; }
    public void setDistanciaKm(double distanciaKm) { this.distanciaKm = distanciaKm; }

    public double getTiempoEstimadoHoras() { return tiempoEstimadoHoras; }
    public void setTiempoEstimadoHoras(double tiempoEstimadoHoras) { this.tiempoEstimadoHoras = tiempoEstimadoHoras; }
}
