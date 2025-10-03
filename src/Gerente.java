public class Gerente extends Empleado {
    private double bonoFijo;
    private int empleadosACargo;

    public Gerente() {
    }

    public Gerente(String id, String nombre, double salarioBase, double bonoFijo, int empleadosACargo) {
        super(id, nombre, salarioBase);
        this.bonoFijo = bonoFijo;
        this.empleadosACargo = empleadosACargo;
    }

    public int getEmpleadosACargo() {
        return empleadosACargo;
    }

    public void setEmpleadosACargo(int empleadosACargo) {
        this.empleadosACargo = empleadosACargo;
    }

    public double getBonoFijo() {
        return bonoFijo;
    }

    public void setBonoFijo(double bonoFijo) {
        this.bonoFijo = bonoFijo;
    }

    @Override
    public String toString() {
        return super.toString() + "Gerente{" +
                "bonoFijo=" + bonoFijo +
                ", empleadosACargo=" + empleadosACargo +
                '}';
    }

    public double calcularIncentivoLiderazgo () {
        if (empleadosACargo > 10){
            return 0.05 *   empleadosACargo;
        }
        return 0;
    }

    public double calcularSalarioPorMeta (){
        return salarioBase + bonoFijo + calcularIncentivoLiderazgo();
    }

    public String Info() {
        return "SOY GERENTE:" + "ID:" + id + "NOMBRE:" + nombre + "salarioBase:" + salarioBase + "bonoFijo:" + bonoFijo + "empleadosACargo:" + empleadosACargo;
    }
}
