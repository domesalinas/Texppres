import java.time.LocalDate;

/**
 * Módulo 4: Asignación y Control de Personal de Reparto y Conductores.
 * Representa a un conductor dentro del sistema logístico Texppres.
 *
 * @author Jordy Paz
 */
public class Conductor {

    private String idConductor; // Cédula o identificador único
    private String nombreCompleto;
    private String telefono;
    private String tipoLicencia; // Ej: "C" (livianos/camionetas), "E" (camiones pesados > 3.5 ton)
    private LocalDate fechaVencimientoLicencia;
    private String estado; // "Disponible", "En Ruta", "Descanso", "Inactivo"
    private Vehiculo vehiculoAsignado; // Relación con la clase Vehiculo (Módulo 1)

    // Constructor completo
    public Conductor(String idConductor, String nombreCompleto, String telefono,
                     String tipoLicencia, LocalDate fechaVencimientoLicencia) {
        if (idConductor == null || idConductor.trim().isEmpty()) {
            throw new IllegalArgumentException("El ID o cédula del conductor es obligatorio.");
        }
        if (nombreCompleto == null || nombreCompleto.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del conductor no puede estar vacío.");
        }
        this.idConductor = idConductor.trim();
        this.nombreCompleto = nombreCompleto.trim();
        this.telefono = telefono;
        this.tipoLicencia = tipoLicencia.toUpperCase().trim();
        this.fechaVencimientoLicencia = fechaVencimientoLicencia;
        this.estado = "Disponible";
        this.vehiculoAsignado = null;
    }

    /**
     * Verifica si la licencia del conductor se encuentra vigente a la fecha actual.
     * @return true si no ha caducado, false en caso contrario.
     */
    public boolean tieneLicenciaVigente() {
        return fechaVencimientoLicencia != null && !fechaVencimientoLicencia.isBefore(LocalDate.now());
    }

    /**
     * Regla de negocio: Valida si la categoría de licencia del conductor permite operar
     * un vehículo según su capacidad de carga en toneladas.
     * - Licencia Tipo E: habilitada para camiones pesados (> 3.5 toneladas) y menores.
     * - Licencia Tipo C: habilitada para unidades de hasta 3.5 toneladas.
     *
     * @param capacidadToneladas Capacidad de carga del vehículo en toneladas.
     * @return true si el conductor está habilitado para conducir el vehículo.
     */
    public boolean esCompatibleConCapacidad(double capacidadToneladas) {
        if (!tieneLicenciaVigente()) {
            return false;
        }
        if (capacidadToneladas > 3.5) {
            return this.tipoLicencia.equals("E") || this.tipoLicencia.equals("G");
        } else {
            return this.tipoLicencia.equals("C") || this.tipoLicencia.equals("D") || this.tipoLicencia.equals("E");
        }
    }

    /**
     * Operación funcional: Vincula un vehículo de carga al conductor validando su disponibilidad
     * y vigencia de documentos.
     *
     * @param vehiculo Instancia de Vehiculo a asignar.
     * @return true si la vinculación fue exitosa.
     */
    public boolean vincularVehiculo(Vehiculo vehiculo) {
        if (vehiculo == null) {
            System.out.println("Error: El vehículo proporcionado no es válido.");
            return false;
        }
        if (!this.estado.equalsIgnoreCase("Disponible")) {
            System.out.println("Error: El conductor " + nombreCompleto + " no está disponible (Estado actual: " + estado + ").");
            return false;
        }
        if (!tieneLicenciaVigente()) {
            System.out.println("Error: La licencia del conductor " + nombreCompleto + " se encuentra vencida.");
            return false;
        }
        this.vehiculoAsignado = vehiculo;
        this.estado = "En Ruta";
        return true;
    }

    /**
     * Libera al conductor del vehículo actual al finalizar un despacho o turno.
     */
    public void liberarVehiculo() {
        this.vehiculoAsignado = null;
        this.estado = "Disponible";
    }

    /**
     * Actualiza el estado operativo del conductor validando estados permitidos.
     * @param nuevoEstado Nuevo estado ("Disponible", "En Ruta", "Descanso", "Inactivo").
     */
    public boolean actualizarEstado(String nuevoEstado) {
        if (nuevoEstado == null) return false;
        String est = nuevoEstado.trim();
        if (est.equalsIgnoreCase("Disponible") ||
                est.equalsIgnoreCase("En Ruta") ||
                est.equalsIgnoreCase("Descanso") ||
                est.equalsIgnoreCase("Inactivo")) {
            this.estado = est;
            return true;
        }
        System.out.println("Estado no válido para el conductor.");
        return false;
    }

    // Getters y Setters
    public String getIdConductor() {
        return idConductor;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTipoLicencia() {
        return tipoLicencia;
    }

    public void setTipoLicencia(String tipoLicencia) {
        this.tipoLicencia = tipoLicencia.toUpperCase().trim();
    }

    public LocalDate getFechaVencimientoLicencia() {
        return fechaVencimientoLicencia;
    }

    public void setFechaVencimientoLicencia(LocalDate fechaVencimientoLicencia) {
        this.fechaVencimientoLicencia = fechaVencimientoLicencia;
    }

    public String getEstado() {
        return estado;
    }

    public Vehiculo getVehiculoAsignado() {
        return vehiculoAsignado;
    }

    @Override
    public String toString() {
        return "Conductor{" +
                "ID='" + idConductor + '\'' +
                ", Nombre='" + nombreCompleto + '\'' +
                ", Licencia='" + tipoLicencia + '\'' +
                ", Vence=" + fechaVencimientoLicencia +
                ", Estado='" + estado + '\'' +
                ", Vehículo Asignado=" + (vehiculoAsignado != null ? "Sí" : "Ninguno") +
                '}';
    }
}