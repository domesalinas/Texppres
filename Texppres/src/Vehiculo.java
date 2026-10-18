public class Vehiculo {
    private String placa;
    private String marca;
    private String modelo;
    private double capacidadToneladas;
    private double volumenM3;
    private String estadoOperativo; // ej: "Disponible", "En Ruta", "Mantenimiento"

    public Vehiculo(String placa, String marca, String modelo, double capacidadToneladas, double volumenM3) {
        setPlaca(placa);
        this.marca = marca;
        this.modelo = modelo;
        this.capacidadToneladas = capacidadToneladas;
        this.volumenM3 = volumenM3;
        this.estadoOperativo = "Disponible";
    }

    // Regla de Negocio / Validación de Placa
    public void setPlaca(String placa) {
        if (placa == null || !placa.matches("^[A-Z]{3}-\\d{3,4}$")) {
            throw new IllegalArgumentException("Formato de placa inválido. Ejemplo: ABC-1234");
        }
        this.placa = placa;
    }

    public String getPlaca() { return placa; }
    public String getEstadoOperativo() { return estadoOperativo; }
    public void setEstadoOperativo(String estadoOperativo) { this.estadoOperativo = estadoOperativo; }

    @Override
    public String toString() {
        return "Vehiculo{" + "placa='" + placa + '\'' + ", marca='" + marca + '\'' +
                ", estado='" + estadoOperativo + '\'' + '}';
    }
}