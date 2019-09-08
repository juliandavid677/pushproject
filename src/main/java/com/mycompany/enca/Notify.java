/*
 * Clase para almacenar la accion de notificacion
 */
package com.mycompany.enca;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import org.primefaces.push.annotation.OnMessage;
import org.primefaces.push.annotation.PushEndpoint;
import org.primefaces.push.impl.JSONEncoder;

/**
 * @author Julián Parra 
 * @author Germán García
 */
@PushEndpoint("/notify")
public class Notify implements Serializable{
    
   @OnMessage(encoders = {JSONEncoder.class})
    public FacesMessage mensaje(FacesMessage mensajeNotificacion){
        return mensajeNotificacion;
    }
    
    public Notify(){
    }
}
