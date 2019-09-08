/*
 * Clase para almacenar las variables de la persona
 */
package com.mycompany.enca;

import java.io.Serializable;

/**
 * @author Julián Parra 
 * @author Germán García
 */
public class DatoPersona implements Serializable{
    /**
     * Variables privadas de persona
     */
    private String nombre;
    private String apellido;
    private Integer cedula;
    private Integer edad;
    private String ocupacion;
    /**
     * Metodo constructor
     * @param nombre
     * @param apellido
     * @param cedula
     * @param edad
     * @param ocupacion
     */
    public DatoPersona(String nombre, String apellido, Integer cedula, Integer edad, String ocupacion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.edad = edad;
        this.ocupacion = ocupacion;
    }
    
    /**
     * get de variable nombre
     * @return 
     */    
    public String getNombre() {
        return nombre;
    }
    /**
     * set de variable nombre
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * get de variable apellido
     * @return 
     */
    public String getApellido() {
        return apellido;
    }
    /**
     * set de variable apellido
     * @param apellido
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    /**
     * get de variable cedula
     * @return 
     */
    public Integer getCedula() {
        return cedula;
    }
    /**
     * set de variable cedula
     * @param cedula
     */
    public void setCedula(Integer cedula) {
        this.cedula = cedula;
    }
    /**
     * get de variable edad
     * @return 
     */
    public Integer getEdad() {
        return edad;
    }
    /**
     * set de variable edad
     * @param edad
     */
    public void setEdad(Integer edad) {
        this.edad = edad;
    }
    /**
     * get de variable ocupacion
     * @return 
     */
    public String getOcupacion() {
        return ocupacion;
    }
    /**
     * set de variable ocupacion
     * @param ocupacion
     */
    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }
    
    
}
