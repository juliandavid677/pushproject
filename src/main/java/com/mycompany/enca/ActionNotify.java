/*
 * Clase para almacenar las variables de la notificacion
 */
package com.mycompany.enca;

import java.io.Serializable;

/**
 * @author Julián Parra 
 * @author Germán García
 */
public class ActionNotify implements Serializable{
    /**
     * Variable titulo
     */
    private String titulo;
    /**
     * Variable descripcion
     */
    private String descripcion;
    /**
     * get de la variable titulo
     * @return 
     */
    public String getTitulo() {
        return titulo;
    }
    /**
     * set de la variable titulo
     * @param titulo
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    /**
     * get de la variable descripcion
     * @return 
     */
    public String getDescripcion() {
        return descripcion;
    }
    /**
     * set de la variable descripcion
     * @param descripcion
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    /**
     * Metodo Constructor
     * @param titulo
     * @param descripcion
     */
    public ActionNotify(String titulo, String descripcion) {
        this.titulo = titulo;
        this.descripcion = descripcion;
    }
}
