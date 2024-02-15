/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lógica;
/**
 *
 * @author jenniferbueso
 */
public enum TipoPesquero {
    PEZ(100.0), CAMARON(200.0), LANGOSTA(300.0);
    public final double price;
    
    TipoPesquero(double price) {
        this.price = price;
    }
}
