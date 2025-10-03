public class Vendedor extends Empleado {
    private double ventasMensuales;
    private double porcentajeComision;

    public Vendedor() {
    }

    public Vendedor(String id, String nombre, double salarioBase, double ventasMensuales, double porcentajeComision) {
        super(id, nombre, salarioBase);
        this.ventasMensuales = ventasMensuales;
        this.porcentajeComision = porcentajeComision;
    }

    public double getVentasMensuales() {
        return ventasMensuales;
    }

    public void setVentasMensuales(double ventasMensuales) {
        this.ventasMensuales = ventasMensuales;
    }

    public double getPorcentajeComision() {
        return porcentajeComision;
    }

    public void setPorcentajeComision(double porcentajeComision) {
        this.porcentajeComision = porcentajeComision;
    }

    @Override
    public String toString() {
        return super.toString() + "Vendedor{" +
                "ventasMensuales=" + ventasMensuales +
                ", porcentajeComision=" + porcentajeComision +
                '}';
    }

    public double calcularBonificacionPorMeta (){
        if (ventasMensuales > 5000000){
            return 0.10 *  ventasMensuales;
        }
        return 0;
    }

    @Override
    public String Info() {
        return "SOY VENDEDOR:" + "ID:" + id + "NOMBRE:" + nombre + "salarioBase:" + salarioBase + "ventasMensuales:" + ventasMensuales + "porcentajeComision:" + porcentajeComision;
    }
}


