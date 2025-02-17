package co.edu.uniquindio.repaso;

import java.util.ArrayList;
import java.util.List;

public class VehiculoPasajero extends Vehiculo  {
    private int numeroMaximoPasajeros;
    private List<Usuario> listaUsuariosAsociados;

    public VehiculoPasajero(String placa, String modelo, String marca, String color, Propietario propietario, int numeroMaximoPasajeros) {
        super(placa, modelo, marca, color, propietario);
        this.numeroMaximoPasajeros = numeroMaximoPasajeros;
        this.listaUsuariosAsociados = new ArrayList<>();
    }

    public int getNumeroMaximoPasajeros() {
        return numeroMaximoPasajeros;
    }

    public void setNumeroMaximoPasajeros(int numeroMaximoPasajeros) {
        this.numeroMaximoPasajeros = numeroMaximoPasajeros;
    }

    public List<Usuario> getListaUsuariosAsociados() {
        return listaUsuariosAsociados;
    }

    public void setListaUsuariosAsociados(List<Usuario> listaUsuariosAsociados) {
        this.listaUsuariosAsociados = listaUsuariosAsociados;
    }

    @Override
    public String toString() {
        return "VehiculoPasajero{" +
                "numeroMaximoPasajeros=" + numeroMaximoPasajeros +
                ", listaUsuariosAsociados=" + listaUsuariosAsociados +
                '}';
    }
}