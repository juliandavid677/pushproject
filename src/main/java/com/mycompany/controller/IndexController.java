/*
 * Clase para guardar los metodos del crud
 */
package com.mycompany.controller;

import com.mycompany.enca.ActionNotify;
import com.mycompany.enca.DatoPersona;
import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang3.StringEscapeUtils;
import org.primefaces.event.RowEditEvent;
import org.primefaces.push.EventBus;
import org.primefaces.push.EventBusFactory;

/**
 * @author Julián Parra 
 * @author Germán García
 */

@ManagedBean
@RequestScoped
public class IndexController implements Serializable {

    /**
     * Varialbe para llamar a la clase PersonaBean con ManagedProperty
     */
    @ManagedProperty("#{personaBean}")
    private PersonaBean persona;
    /**
     * Varialbe para llamar a la clase VerAdmin con ManagedProperty
     */
    @ManagedProperty("#{verAdmin}")
    private VerAdmin adminver;
    /**
     * Varialbe privada nombre
     */
    private String nombre;
    /**
     * Varialbe privada apellido
     */
    private String apellido;
    /**
     * Varialbe privada cedula
     */
    private Integer cedula;
    /**
     * Varialbe privada edad
     */
    private Integer edad;

    /**
     * Varialbe get del metodo VerAdmin
     *
     * @return
     */
    public VerAdmin getAdminver() {
        return adminver;
    }

    /**
     * Varialbe set del metodo VerAdmin
     *
     * @param adminver
     */
    public void setAdminver(VerAdmin adminver) {
        this.adminver = adminver;
    }

    /**
     * Varialbe get nombre
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Varialbe set nombre
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Varialbe get apellido
     *
     * @return
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Varialbe set apellido
     *
     * @param apellido
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Varialbe get cedula
     *
     * @return
     */
    public Integer getCedula() {
        return cedula;
    }

    /**
     * Varialbe set cedula
     *
     * @param cedula
     */
    public void setCedula(Integer cedula) {
        this.cedula = cedula;
    }

    /**
     * Varialbe det edad
     *
     * @return
     */
    public Integer getEdad() {
        return edad;
    }

    /**
     * Varialbe set edad
     * @param edad
     */
    public void setEdad(Integer edad) {
        this.edad = edad;
    }
    /**
     * Varialbe get ocupacion
     * @return 
     */
    public String getOcupacion() {
        return ocupacion;
    }
    /**
     * Varialbe set ocupacion
     * @param ocupacion
     */
    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }
    /**
     * Varialbe privada ocupacion
     */
    private String ocupacion;
    /**
     * Varialbe get de la clase PersonaBean
     * @return 
     */
    public PersonaBean getPersona() {
        return persona;
    }
    /**
     * Varialbe set de la clase PersonaBean
     * @param persona
     */
    public void setPersona(PersonaBean persona) {
        this.persona = persona;
    }
    /**
     * FacesContext para sacar la sesion del usuario en el navegador
     */
    FacesContext fCtx = FacesContext.getCurrentInstance();
    HttpSession session = (HttpSession) fCtx.getExternalContext().getSession(false);
    String sessionId = session.getId();

    public IndexController() {
    }
    /**
     * Metodo editar persona
     * @param event
     */
    public void onRowEdit(RowEditEvent event) {
        notificarPush("Datos Modificados", "El cliente " + sessionId + " ha modificado a " + ((DatoPersona) event.getObject()).getNombre());
        adminver.getActionNoti().add(new ActionNotify("Datos Modificados", "El cliente " + sessionId + " ha modificado a " + ((DatoPersona) event.getObject()).getNombre()));
        FacesMessage msg = new FacesMessage("Datos Modificados", ((DatoPersona) event.getObject()).getNombre());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    /**
     * Metodo Cancelar
     * @param event
     */
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edicion Cancelada", ((DatoPersona) event.getObject()).getNombre());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    /**
     * Metodo crear persona
     */
    public void crear() {
        persona.getPersonaLista().add(new DatoPersona(nombre, apellido, cedula, edad, ocupacion));
        notificarPush("Datos Creados", "El cliente " + sessionId + " ha creado a " + nombre + " " + apellido);
        adminver.getActionNoti().add(new ActionNotify("Datos Creados", "El cliente " + sessionId + " ha creado a " + nombre + " " + apellido));
        FacesMessage msg = new FacesMessage("Dato Agregado", "Exito!");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    /**
     * Metodo eliminar persona
     * @param removePersona
     */
    public void eliminar(DatoPersona removePersona) {
        notificarPush("Eliminacion", "El cliente " + sessionId + " ha eliminado a " + removePersona.getNombre());
        adminver.getActionNoti().add(new ActionNotify("Eliminacion", "El cliente " + sessionId + " ha eliminado a " + removePersona.getNombre()));
        persona.getPersonaLista().remove(removePersona);
        FacesMessage msg = new FacesMessage("Dato Eliminado", "Exito!");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    /**
     * metodo del canal de envio de informacion
     * @param titulo
     * @param detalle
     */
    public void notificarPush(String titulo, String detalle) {
        String canal = "/notify";

        EventBus eventBus = EventBusFactory.getDefault().eventBus();
        eventBus.publish(canal, new FacesMessage(StringEscapeUtils.escapeHtml3(titulo), StringEscapeUtils.escapeHtml3(detalle)));
    }
}
