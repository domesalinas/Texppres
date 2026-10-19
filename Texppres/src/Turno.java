import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Módulo 4: Asignación y Control de Personal de Reparto y Conductores.
 * Representa un turno de trabajo y gestiona la programación y asignación
 * algorítmica de conductores a vehículos.
 *
 * @author Jordy Paz
 */
public class Turno {

    private String idTurno;
    private LocalDate fecha;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private String estadoTurno; // "Programado", "Activo", "Completado", "Cancelado"
    private Conductor conductor;
    private Vehiculo vehiculo;

    // Listas para gestionar el padrón de conductores y turnos del Módulo 4
    private static List<Conductor> padronConductores = new ArrayList<>();
    private static List<Turno> registroTurnos = new ArrayList<>();

    // Constructor del Turno
    public Turno(String idTurno, LocalDate fecha, LocalTime horaInicio, LocalTime horaFin,
                 Conductor conductor, Vehiculo vehiculo) {
        if (horaFin.isBefore(horaInicio) || horaFin.equals(horaInicio)) {
            throw new IllegalArgumentException("La hora de fin debe ser posterior a la hora de inicio.");
        }
        this.idTurno = idTurno;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.estadoTurno = "Programado";
        this.conductor = conductor;
        this.vehiculo = vehiculo;
    }

    // 1. Registrar un nuevo conductor validando unicidad de ID
    public static boolean registrarConductor(Conductor nuevoConductor) {
        if (nuevoConductor == null) return false;
        for (Conductor c : padronConductores) {
            if (c.getIdConductor().equalsIgnoreCase(nuevoConductor.getIdConductor())) {
                System.out.println("Error: Ya existe un conductor con el ID " + nuevoConductor.getIdConductor());
                return false;
            }
        }
        padronConductores.add(nuevoConductor);
        return true;
    }

    // 2. Buscar conductor por su cédula o ID
    public static Conductor buscarConductorPorId(String idConductor) {
        for (Conductor c : padronConductores) {
            if (c.getIdConductor().equalsIgnoreCase(idConductor)) {
                return c;
            }
        }
        return null;
    }

    // 3. Programar turno validando licencia vigente y que no haya cruce de horarios
    public static boolean programarTurno(Turno nuevoTurno) {
        if (nuevoTurno == null || nuevoTurno.getConductor() == null) return false;

        Conductor cond = nuevoTurno.getConductor();
        if (!cond.tieneLicenciaVigente()) {
            System.out.println("Error: Licencia vencida para " + cond.getNombreCompleto());
            return false;
        }

        for (Turno t : registroTurnos) {
            if (!t.getEstadoTurno().equalsIgnoreCase("Cancelado") &&
                    t.getConductor().getIdConductor().equalsIgnoreCase(cond.getIdConductor()) &&
                    t.getFecha().equals(nuevoTurno.getFecha())) {

                boolean seSolapan = nuevoTurno.getHoraInicio().isBefore(t.getHoraFin()) &&
                        nuevoTurno.getHoraFin().isAfter(t.getHoraInicio());
                if (seSolapan) {
                    System.out.println("Error: El conductor ya tiene un turno asignado en ese horario.");
                    return false;
                }
            }
        }

        registroTurnos.add(nuevoTurno);
        return true;
    }

    // 4. Operación algorítmica: Filtra, ordena y asigna el conductor óptimo a un vehículo
    public static Conductor asignarConductorOptimo(Vehiculo vehiculo, double capacidadToneladas,
                                                   LocalDate fecha, LocalTime horaInicio, LocalTime horaFin) {
        List<Conductor> candidatosAptos = new ArrayList<>();

        for (Conductor c : padronConductores) {
            if (c.getEstado().equalsIgnoreCase("Disponible") && c.esCompatibleConCapacidad(capacidadToneladas)) {
                boolean libreEnFranja = true;
                for (Turno t : registroTurnos) {
                    if (!t.getEstadoTurno().equalsIgnoreCase("Cancelado") &&
                            t.getConductor().getIdConductor().equalsIgnoreCase(c.getIdConductor()) &&
                            t.getFecha().equals(fecha)) {
                        if (horaInicio.isBefore(t.getHoraFin()) && horaFin.isAfter(t.getHoraInicio())) {
                            libreEnFranja = false;
                            break;
                        }
                    }
                }
                if (libreEnFranja) {
                    candidatosAptos.add(c);
                }
            }
        }

        if (candidatosAptos.isEmpty()) {
            return null;
        }

        // Ordena priorizando al conductor con mayor vigencia en su licencia
        candidatosAptos.sort(Comparator.comparing(Conductor::getFechaVencimientoLicencia).reversed());

        Conductor seleccionado = candidatosAptos.get(0);
        seleccionado.vincularVehiculo(vehiculo);
        return seleccionado;
    }

    // 5. Filtrar conductores disponibles por tipo de licencia
    public static List<Conductor> filtrarConductoresDisponiblesPorLicencia(String tipoLicencia) {
        List<Conductor> resultado = new ArrayList<>();
        for (Conductor c : padronConductores) {
            if (c.getEstado().equalsIgnoreCase("Disponible") &&
                    c.tieneLicenciaVigente() &&
                    c.getTipoLicencia().equalsIgnoreCase(tipoLicencia)) {
                resultado.add(c);
            }
        }
        return resultado;
    }

    public static List<Conductor> listarConductores() {
        return new ArrayList<>(padronConductores);
    }

    public static List<Turno> listarTurnos() {
        return new ArrayList<>(registroTurnos);
    }

    // Getters y Setters
    public String getIdTurno() {
        return idTurno;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public String getEstadoTurno() {
        return estadoTurno;
    }

    public void setEstadoTurno(String estadoTurno) {
        this.estadoTurno = estadoTurno;
    }

    public Conductor getConductor() {
        return conductor;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    @Override
    public String toString() {
        return "Turno{" +
                "ID='" + idTurno + '\'' +
                ", Fecha=" + fecha +
                ", Horario=" + horaInicio + " - " + horaFin +
                ", Estado='" + estadoTurno + '\'' +
                ", Conductor='" + (conductor != null ? conductor.getNombreCompleto() : "Sin asignar") + '\'' +
                '}';
    }
}