/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author faranzabe
 */
public class Persona {
    private String DNI;
    private String  Nombre;
    private String Tfno;

    public Persona() {
    }

    public Persona(String DNI, String Nombre, String Tfno) {
        this.DNI = DNI;
        this.Nombre = Nombre;
        this.Tfno = Tfno;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getTfno() {
        return Tfno;
    }

    public void setTfno(String Tfno) {
        this.Tfno = Tfno;
    }

    

    @Override
    public String toString() {
        return "Persona{" + "DNI=" + DNI + ", Nombre=" + Nombre + ", Tfno=" + Tfno + '}';
    }
    
    
}
