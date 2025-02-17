package co.edu.uniquindio.repaso;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainTransporte {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmpresaTransporte empresaTransporte = inicializarDatos();

        int opcion;
        do {
            System.out.println("\n--- Menú de Empresa de Transporte ---");
            System.out.println("1. Agregar Propietario");
            System.out.println("2. Agregar Vehículo");
            System.out.println("3. Mostrar Propietarios");
            System.out.println("4. Mostrar capacidad total de pasajeros");
            System.out.println("5. Obtener usuarios con peso superior a un valor");
            System.out.println("6. Obtener número de usuarios movilizados por placa");
            System.out.println("7. Obtener número de propietarios mayores de 40 años");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    agregarPropietario(scanner, empresaTransporte);
                    break;
                case 2:
                    agregarVehiculo(scanner, empresaTransporte);
                    break;
                case 3:
                    mostrarPropietarios(empresaTransporte);
                    break;
                case 4:
                    calcularCapacidadTotalPasajeros(empresaTransporte);
                    break;
                case 5:
                    obtenerUsuariosConPesoSuperior(scanner, empresaTransporte);
                    break;
                case 6:
                    obtenerUsuariosPorPlaca(scanner, empresaTransporte);
                    break;
                case 7:
                    obtenerPropietariosMayoresDe40(empresaTransporte);
                    break;
                case 8:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 8);

        scanner.close();
    }

    private static void obtenerUsuariosConPesoSuperior(Scanner scanner, EmpresaTransporte empresaTransporte) {
        System.out.print("\nIngrese el valor de peso límite: ");
        double pesoLimite = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("\nUsuarios con peso superior a " + pesoLimite + " kg:");
        for (Propietario propietario : empresaTransporte.getListaPropietarios()) {
            for (Vehiculo vehiculo : propietario.getListaVehiculosAsociados()) {
                if (vehiculo instanceof VehiculoPasajero) { // Verifica si es un VehiculoPasajero
                    VehiculoPasajero vehiculoPasajero = (VehiculoPasajero) vehiculo; // Casting
                    for (Usuario usuario : vehiculoPasajero.getListaUsuariosAsociados()) {
                        if (usuario.getPeso() > pesoLimite) {
                            System.out.println("Nombre: " + usuario.getNombre() + ", Peso: " + usuario.getPeso() + " kg");
                        }
                    }
                }
            }
        }
    }

    private static void obtenerUsuariosPorPlaca(Scanner scanner, EmpresaTransporte empresaTransporte) {
        System.out.print("\nIngrese la placa del vehículo: ");
        String placa = scanner.nextLine();

        int contadorUsuarios = 0;
        for (Propietario propietario : empresaTransporte.getListaPropietarios()) {
            for (Vehiculo vehiculo : propietario.getListaVehiculosAsociados()) {
                if (vehiculo.getPlaca().equalsIgnoreCase(placa) && vehiculo instanceof VehiculoPasajero) {
                    VehiculoPasajero vehiculoPasajero = (VehiculoPasajero) vehiculo; // Casting
                    contadorUsuarios += vehiculoPasajero.getListaUsuariosAsociados().size();
                }
            }
        }

        System.out.println("\nNúmero de usuarios que se movilizaron en el vehículo con placa " + placa + ": " + contadorUsuarios);
    }

    private static void obtenerPropietariosMayoresDe40(EmpresaTransporte empresaTransporte) {
        int contador = 0;
        for (Propietario propietario : empresaTransporte.getListaPropietarios()) {
            if (propietario.getEdad() > 40) {
                contador++;
            }
        }
        System.out.println("\nNúmero de propietarios mayores de 40 años: " + contador);
    }

    private static void calcularCapacidadTotalPasajeros(EmpresaTransporte empresaTransporte) {
        int capacidadTotal = 0;
        for (Propietario propietario : empresaTransporte.getListaPropietarios()) {
            for (Vehiculo vehiculo : propietario.getListaVehiculosAsociados()) {
                if (vehiculo instanceof VehiculoPasajero) {
                    capacidadTotal += ((VehiculoPasajero) vehiculo).getNumeroMaximoPasajeros();
                }
            }
        }
        System.out.println("\nCapacidad total de pasajeros en la empresa: " + capacidadTotal);
    }

    private static void agregarPropietario(Scanner scanner, EmpresaTransporte empresaTransporte) {
        System.out.println("\n--- Registro de Propietario ---");
        System.out.print("Ingrese el nombre del propietario: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la cédula del propietario: ");
        String cedula = scanner.nextLine();
        System.out.print("Ingrese el email del propietario: ");
        String email = scanner.nextLine();
        System.out.print("Ingrese la edad del propietario: ");
        int edad = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese el celular del propietario: ");
        String celular = scanner.nextLine();

        Propietario propietario = new Propietario(nombre, cedula, email, edad, celular);
        empresaTransporte.getListaPropietarios().add(propietario);
        System.out.println("Propietario agregado exitosamente.");
    }

    private static void agregarVehiculo(Scanner scanner, EmpresaTransporte empresaTransporte) {
        System.out.println("\n--- Registro de Vehículo ---");
        System.out.print("Ingrese la cédula del propietario: ");
        String cedulaPropietario = scanner.nextLine();
        Propietario propietario = buscarPropietarioPorCedula(empresaTransporte, cedulaPropietario);
        if (propietario == null) {
            System.out.println("Propietario no encontrado. Registre el propietario primero.");
            return;
        }

        System.out.print("Ingrese la placa del vehículo: ");
        String placa = scanner.nextLine();
        System.out.print("Ingrese el modelo del vehículo: ");
        String modelo = scanner.nextLine();
        System.out.print("Ingrese la marca del vehículo: ");
        String marca = scanner.nextLine();
        System.out.print("Ingrese el color del vehículo: ");
        String color = scanner.nextLine();
        System.out.print("Ingrese el número máximo de pasajeros: ");
        int numeroMaximoPasajeros = scanner.nextInt();
        scanner.nextLine();

        VehiculoPasajero vehiculo = new VehiculoPasajero(placa, modelo, marca, color, propietario, numeroMaximoPasajeros);
        propietario.agregarVehiculoPasajero(vehiculo);
        System.out.println("Vehículo agregado exitosamente.");
    }

    private static void mostrarPropietarios(EmpresaTransporte empresaTransporte) {
        System.out.println("\n--- Lista de Propietarios ---");
        for (Propietario propietario : empresaTransporte.getListaPropietarios()) {
            System.out.println("Nombre: " + propietario.getNombre() + ", Edad: " + propietario.getEdad());
        }
    }

    private static Propietario buscarPropietarioPorCedula(EmpresaTransporte empresaTransporte, String cedula) {
        for (Propietario propietario : empresaTransporte.getListaPropietarios()) {
            if (propietario.getCedula().equals(cedula)) {
                return propietario;
            }
        }
        return null;
    }

    private static EmpresaTransporte inicializarDatos() {
        EmpresaTransporte empresaTransporte = new EmpresaTransporte();
        empresaTransporte.setNombre("Transportadora SA");

        Propietario propietario1 = new Propietario("Pedro", "1094884823", "Pedro@email.com", 35, "3174875717");
        Propietario propietario2 = new Propietario("Luisa", "1001116789", "Luisa@email.com", 45, "3218824490");

        VehiculoPasajero vehiculo1 = new VehiculoPasajero("ABC123", "2019", "Renault", "Blanco", propietario1, 20);
        VehiculoPasajero vehiculo2 = new VehiculoPasajero("DEF123", "2002", "Mazda", "Negro", propietario1, 8);
        VehiculoPasajero vehiculo3 = new VehiculoPasajero("GHI123", "2025", "Mercedes", "Rojo", propietario2, 12);

        Usuario usuario1 = new Usuario("Miguel", 70, 70.2);
        Usuario usuario2 = new Usuario("Nelly", 27, 50.3);
        Usuario usuario3 = new Usuario("Julian", 53, 68.9);
        Usuario usuario4 = new Usuario("Maria", 42, 71.6);

        propietario1.agregarVehiculoPasajero(vehiculo1);
        propietario1.agregarVehiculoPasajero(vehiculo2);
        propietario2.agregarVehiculoPasajero(vehiculo3);

        empresaTransporte.getListaPropietarios().add(propietario1);
        empresaTransporte.getListaPropietarios().add(propietario2);

        return empresaTransporte;
    }
}