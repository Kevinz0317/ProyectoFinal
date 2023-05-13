/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Kevin
 */
public class Sugerencias implements ISugerencias {

    private String nombre;
    private String correoElectronico;
    private String sugerencia;
    private int calificacion;

    public Sugerencias() {
    }

    public Sugerencias(String nombre, String correoElectronico, String sugerencia, int calificacion) {
        this.nombre = nombre;
        this.correoElectronico = correoElectronico;
        this.sugerencia = sugerencia;
        this.calificacion = calificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getSugerencia() {
        return sugerencia;
    }

    public void setSugerencia(String sugerencia) {
        this.sugerencia = sugerencia;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    @Override
    public double calcularPromedio() {
        return 0;
    }

    @Override
    public int cantidadSugerencias() {
        return 0;
    }
}