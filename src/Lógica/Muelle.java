/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lógica;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author jenniferbueso
 */
public class Muelle {
    private ArrayList<Barco> barcos;
    private String tipoCarga, barcoLabel, nombreAgregar;
    private int limitePasajeros;
    private double precioBoleto;
    private BarcoPesquero barcoPesquero;
    private BarcoPasajero barcoPasajero;
    
    public Muelle() {
        barcos = new ArrayList<>();
    }

    public void setTipoCarga(String tipoCarga) {
        this.tipoCarga = tipoCarga;
    }

    public void setLimitePasajeros(int limitePasajeros) {
        this.limitePasajeros = limitePasajeros;
    }

    public void setPrecioBoleto(double precioBoleto) {
        this.precioBoleto = precioBoleto;
    }

    public void setNombreAgregar(String nombreAgregar) {
        this.nombreAgregar = nombreAgregar;
    }
    
    public String getBarcoLabel() {
        return barcoLabel;
    }

    public BarcoPesquero getBarcoPesquero() {
        return barcoPesquero;
    }

    public BarcoPasajero getBarcoPasajero() {
        return barcoPasajero;
    }
    
    
    public Barco buscarBarco(String nombre) {
        for (Barco barcoNombre : barcos) {
            if (barcoNombre.getNombre().equals(nombre)) {
                if (barcoNombre instanceof BarcoPasajero) {
                    barcoLabel = "Pasajero";
                    barcoPasajero = (BarcoPasajero) barcoNombre;
                } else if (barcoNombre instanceof BarcoPesquero) {
                    barcoLabel = "Pesquero";
                    barcoPesquero = (BarcoPesquero) barcoNombre;
                }
                return barcoNombre;
            }
        }
        return null;
    }
    
    public void agregarBarco(String tipo) {
        if (buscarBarco(nombreAgregar) != null) {
            JOptionPane.showMessageDialog(null, "El barco ya existe.", "Barco Existente", JOptionPane.ERROR_MESSAGE);
            return;
        } else {
            switch (tipo.toUpperCase()) {
                case "PESQUERO":
                    if (tipoCarga.equals("PEZ")) {
                        BarcoPesquero barcoPesquero = new BarcoPesquero(nombreAgregar, TipoPesquero.PEZ);
                        barcos.add(barcoPesquero);
                        JOptionPane.showMessageDialog(null, "¡Barco Agregado Exitosamente!", "Barco Agregado", JOptionPane.INFORMATION_MESSAGE);
                    } else if (tipoCarga.equals("CAMARÓN")) {
                        BarcoPesquero barcoPesquero = new BarcoPesquero(nombreAgregar, TipoPesquero.CAMARON);
                        barcos.add(barcoPesquero);
                        JOptionPane.showMessageDialog(null, "¡Barco Agregado Exitosamente!", "Barco Agregado", JOptionPane.INFORMATION_MESSAGE);
                    } else if (tipoCarga.equals("LANGOSTA")) {
                        BarcoPesquero barcoPesquero = new BarcoPesquero(nombreAgregar, TipoPesquero.LANGOSTA);
                        barcos.add(barcoPesquero);
                        JOptionPane.showMessageDialog(null, "¡Barco Agregado Exitosamente!", "Barco Agregado", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Tipo de barco pesquero no válido.", "Barco Inválido", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                    
                case "PASAJERO":
                    BarcoPasajero barcoPasajero = new BarcoPasajero(nombreAgregar, limitePasajeros, precioBoleto);
                    barcos.add(barcoPasajero);
                    JOptionPane.showMessageDialog(null, "¡Barco Agregado Exitosamente!", "Barco Agregado", JOptionPane.INFORMATION_MESSAGE);
                    break;
                    
                default: 
                    JOptionPane.showMessageDialog(null, "Tipo de barco inválido.", "Barco Inválido", JOptionPane.ERROR_MESSAGE);
                    break;
            }
        }
    }
    
    public void agregarElemento(String nombre) {
        Barco barcoEncontrado = buscarBarco(nombre);
        if (barcoEncontrado != null) {
            if (barcoEncontrado instanceof BarcoPasajero) {
                ((BarcoPasajero) barcoEncontrado).agregarElemento();
            } else if (barcoEncontrado instanceof BarcoPesquero) {
                ((BarcoPesquero) barcoEncontrado).agregarElemento();
            }
        } else {
            JOptionPane.showMessageDialog(null, "El barco '" + nombre + "' no existe.", "Barco Inexistente", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public double vaciarBarco(String nombre) {
        Barco barcoEncontrado = buscarBarco(nombre);
        if (barcoEncontrado != null) {
           return barcoEncontrado.vaciarCobrar();
        }
        return 0.00;
    }
    
    public String barcosDesde(int year) {
        return barcosDesde(new StringBuilder(), year, 0);
    }

    private String barcosDesde(StringBuilder pasajerosInfo, int year, int index) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/YYYY");
        if (index < barcos.size()) {
            Barco barco = barcos.get(index);
            if (barco.getFechaCiruculacion().get(Calendar.YEAR) >= year) {
                pasajerosInfo.append(barco.getNombre() + " - " + formato.format(barco.getFechaCiruculacion().getTime()) + "\n");
            }
            return barcosDesde(pasajerosInfo, year, index + 1);
        }
        return pasajerosInfo.toString();
    }
}
