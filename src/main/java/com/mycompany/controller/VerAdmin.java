/*
 * Clase para almacenar la lista de notificacion
 */
package com.mycompany.controller;

import com.mycompany.enca.ActionNotify;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * @author Julián Parra 
 * @author Germán García
 */
@ManagedBean
@ApplicationScoped
public class VerAdmin implements Serializable{

    /**
     * Creacion de la lista actionNoti
     */
    private List<ActionNotify> actionNoti;
    /**
     * Metodo Constructor
     */
    public VerAdmin() {
        actionNoti = new ArrayList();
    }
    /**
     * metodo get de actionNoti
     * @return 
     */
    public List<ActionNotify> getActionNoti() {
        return actionNoti;
    }
    /**
     * metodo set de actionNoti
     * @param actionNoti
     */
    public void setActionNoti(List<ActionNotify> actionNoti) {
        this.actionNoti = actionNoti;
    }
    
    
}
