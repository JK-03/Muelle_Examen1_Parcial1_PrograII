/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lógica;

import javax.swing.JOptionPane;

/**
 *
 * @author jenniferbueso
 */
public final class BarcoPesquero extends Barco {
    private int pecesCapturados;
    private TipoPesquero tipoBarco;
    
    public BarcoPesquero(String nombre, TipoPesquero tipoBarco) {
        super(nombre);
        this.tipoBarco = tipoBarco;
        pecesCapturados = 0;
    }
    
    @Override
    public void agregarElemento() {
        pecesCapturados++;
        JOptionPane.showMessageDialog(null, "¡Elemento agregado exitosamente! \nElemento Actuales: " + pecesCapturados, "Elemento Agregado", JOptionPane.INFORMATION_MESSAGE);
    }
    
    @Override
    public double vaciarCobrar() {
        double total = pecesCapturados * tipoBarco.price;
        pecesCapturados = 0;
        return total;
    }
    
    @Override
    public double precioElemento() {
        return tipoBarco.price;
    }
    
    @Override
    public String toString() {
        return super.toString() + "\nBarco con Carga de: " + tipoBarco + "\nPeces Capturados: " + pecesCapturados;
    }
}
