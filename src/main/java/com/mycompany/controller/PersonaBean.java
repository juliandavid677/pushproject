/*
 * Clase para almacenar la lista de personas
 */
package com.mycompany.controller;

import com.mycompany.enca.DatoPersona;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * @author Julián Parra 
 * @author Germán García
 */
@ManagedBean
@SessionScoped
public class PersonaBean implements Serializable{

    /**
     * Creacion de la lista
     */
    private List<DatoPersona> personaLista;
    /**
     * Metodo Constructor
     */
    public PersonaBean() {
        personaLista = new ArrayList<>();
    }
    /**
     * get de la lista personaLista
     * @return 
     */
    public List<DatoPersona> getPersonaLista() {
        return personaLista;
    }
    /**
     * set de la lista personaLista
     * @param personaLista
     */
    public void setPersonaLista(List<DatoPersona> personaLista) {
        this.personaLista = personaLista;
    }
    
}
