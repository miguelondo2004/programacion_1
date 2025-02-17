package co.edu.uniquindio.repaso;
import java.util.ArrayList;
import java.util.List;

public class Propietario {
    private String nombre;
    private String cedula;
    private String email;
    private int edad;
    private String celular;
    private List<VehiculoCarga> listaVehiculosAsociados;
    private List<VehiculoPasajero> listaVehiculosPasajero;

    public Propietario() {
        this.listaVehiculosAsociados = new ArrayList<>();
        this.listaVehiculosPasajero = new ArrayList<>();
    }
    public Propietario(String nombre, String cedula, String email, int edad, String celular) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.email = email;
        this.edad = edad;
        this.celular = celular;
        this.listaVehiculosAsociados = new ArrayList<>();
        this.listaVehiculosPasajero = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public List<VehiculoCarga> getListaVehiculosAsociados() {
        return listaVehiculosAsociados;
    }

    public void setListaVehiculosAsociados(List<VehiculoCarga> listaVehiculosAsociados) {
        this.listaVehiculosAsociados = listaVehiculosAsociados;
    }
    public List<VehiculoPasajero> getListaVehiculosPasajero() {
        return listaVehiculosPasajero;
    }

    public void setListaVehiculosPasajero(List<VehiculoPasajero> listaVehiculosPasajero) {
        this.listaVehiculosPasajero = listaVehiculosPasajero;
    }

    public void agregarVehiculoCarga(VehiculoCarga vehiculo) {
        if (vehiculo != null) {
            listaVehiculosAsociados.add(vehiculo);
        }
    }
    public void agregarVehiculoPasajero(VehiculoPasajero vehiculo) {
        if (vehiculo != null) {
            listaVehiculosPasajero.add(vehiculo);
        }
    }
    public void mostrarVehiculos() {
        System.out.println("Vehículos de " + nombre + ":");
        for (VehiculoCarga vehiculo : listaVehiculosAsociados) {
            System.out.println("- " + vehiculo.getPlaca() + " (" + vehiculo.getModelo() + ")");
        }
    }
}