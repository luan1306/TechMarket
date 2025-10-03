import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Menu();

    }

    // MENU PRINCIPAL
    public static void Menu(){

        Scanner menu = new Scanner(System.in);
        Scanner datos = new Scanner(System.in);
        List<Empleado> lstLista = new ArrayList<>();


        int opcion;
        do {
            Empleado e1 = new Empleado();
            System.out.println("=== SISTEMA DE NÓMINA TECHMARKET ===");
            System.out.println("1. Registrar Vendedor");
            System.out.println("2. Registrar Gerente");
            System.out.println("3. Listar empleados");
            System.out.println("4. Calcular nómina total");
            System.out.println("5. Mostrar empleado con mayor salario");
            System.out.println("6. Calcular salario promedio");
            System.out.println("7. Buscar empleado por ID");
            System.out.println("8. Mostrar cantidad de Vendedores y Gerentes");
            System.out.println("0. Salir");




            opcion = menu.nextInt();

            switch(opcion){
                case 1:

                    System.out.println("Ingrese el ID del vendedor");
                    e1.setId(datos.next());
                    System.out.println("Ingrese el nombre del vendedor");
                    e1.setNombre(datos.next());
                    System.out.println("Ingrese el salario base");
                    e1.setSalarioBase(datos.nextDouble());
                    System.out.println("Ingrese las ventas mensuales");
                    double ventasMensuales = datos.nextDouble();
                    System.out.println("Ingrese la porcentaje de comision");
                    double porcentajeComision = datos.nextDouble();


                    Empleado v1 = new Vendedor(e1.id, e1.nombre, e1.salarioBase, ventasMensuales, porcentajeComision);


                    lstLista.add(v1);
                    break;
                case 2:

                    System.out.println("Ingrese el ID del gerente");
                    e1.setId(datos.next());
                    System.out.println("Ingrese el nombre del gerente");
                    e1.setNombre(datos.next());
                    System.out.println("Ingrese el salario base");
                    e1.setSalarioBase(datos.nextDouble());
                    System.out.println("Ingrese bono fijo");
                    double bonoFijo = datos.nextDouble();
                    System.out.println("Ingrese empleados a cargo");
                    int empleadosACargo = datos.nextInt();


                    Empleado g1 = new Gerente (e1.id, e1.nombre, e1.salarioBase, bonoFijo, empleadosACargo);
                    lstLista.add(g1);

                    break;
                case 3:

                    for (Empleado e : lstLista) {
                        System.out.println(e.toString());
                    }

                    break;
                case 4:

                    double nominaTotal = 0;
                    for (Empleado e : lstLista) {
                        nominaTotal += e.calcularSalario();
                    }
                    System.out.println("La nómina total es: " + nominaTotal);


                    break;
                case 5:


                    Empleado mayor = null;
                    for (Empleado e : lstLista) {
                        if (mayor == null || e.calcularSalario() > mayor.calcularSalario()) {
                            mayor = e;
                        }
                    }

                    if (mayor != null) {
                        System.out.println("Empleado con mayor salario:");
                        System.out.println(mayor.Info());
                        System.out.println("Nombre: " + mayor.getNombre());
                        System.out.println("Salario: " + mayor.calcularSalario());
                    } else {
                        System.out.println("No hay empleados registrados.");
                    }

                    break;
                case 6:

                    if (!lstLista.isEmpty()) {
                        double suma = 0;
                        for (Empleado e : lstLista) {
                            suma += e.calcularSalario();
                        }
                        double promedio = suma / lstLista.size();
                        System.out.println("El salario promedio es: " + promedio);
                    } else {
                        System.out.println("No hay empleados registrados.");
                    }

                    break;
                case 7:

                    System.out.print("Ingrese el ID: ");
                    String idBuscar = datos.next();
                    for (Empleado e : lstLista) {
                        if (e.getId().equalsIgnoreCase(idBuscar)) {
                            System.out.println(e.Info());
                            System.out.println("Nombre del empleado: " + e.getNombre());
                        }
                    }
                    break;
                case 8:

                    int contV = 0, contG = 0;
                    for (Empleado e : lstLista) {
                        if (e instanceof Vendedor) contV++;
                        if (e instanceof Gerente) contG++;
                    }
                    System.out.println("Cantidad de Vendedores: " + contV);
                    System.out.println("Cantidad de Gerentes: " + contG);

                    break;

                case 0:
                    System.out.println("salir...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion !=0);


    }
}