/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lógica;

import java.util.Calendar;

/**
 *
 * @author jenniferbueso
 */
public abstract class Barco {
    private String nombre;
    private Calendar fechaCiruculacion;
    
    public Barco(String nombre) {
        this.nombre = nombre;
        fechaCiruculacion = Calendar.getInstance();
    }
    
    public final String getNombre() {
        return nombre;
    }
    
    public final Calendar getFechaCiruculacion() {
        return fechaCiruculacion;
    }
    
    @Override
    public String toString() {
        return "Nombre: " + nombre;
    }
    
    public abstract void agregarElemento();
    public abstract double vaciarCobrar();
    public abstract double precioElemento();
}
