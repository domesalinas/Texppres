import java.util.ArrayList;
import java.util.List;

public class GestionFlota {
    private List<Vehiculo> flota;

    public GestionFlota() {
        this.flota = new ArrayList<>();
    }

    // Sub-Funcionalidad 1: Crear / Registrar
    public void registrarVehiculo(Vehiculo vehiculo) {
        if (vehiculo == null) {
            throw new IllegalArgumentException("El vehículo no puede ser nulo.");
        }
        for (Vehiculo v : flota) {
            if (v.getPlaca().equalsIgnoreCase(vehiculo.getPlaca())) {
                throw new IllegalStateException("Ya existe un vehículo registrado con la placa: " + vehiculo.getPlaca());
            }
        }
        flota.add(vehiculo);
    }

    // Sub-Funcionalidad 2: Modificar Estado
    public boolean actualizarEstado(String placa, String nuevoEstado) {
        Vehiculo v = buscarPorPlaca(placa);
        if (v != null) {
            v.setEstadoOperativo(nuevoEstado);
            return true;
        }
        return false;
    }

    // Sub-Funcionalidad 3: Consultar / Buscar
    public Vehiculo buscarPorPlaca(String placa) {
        for (Vehiculo v : flota) {
            if (v.getPlaca().equalsIgnoreCase(placa)) {
                return v;
            }
        }
        return null;
    }

    // Indicador KPI: Índice de Disponibilidad de Flota (%)
    public double calcularKPIDisponibilidad() {
        if (flota.isEmpty()) return 0.0;
        long disponibles = flota.stream()
                .filter(v -> v.getEstadoOperativo().equalsIgnoreCase("Disponible"))
                .count();
        return ((double) disponibles / flota.size()) * 100.0;
    }
}