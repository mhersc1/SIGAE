package web.mb;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name="msg")
@ViewScoped
public class MessageView implements Serializable{
	
	public void showMessage(int option){	
		FacesContext context=FacesContext.getCurrentInstance();
		switch (option) {
		//********************	Ingreso Query		******************************
		case 1://Query válida
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Query válida",":éxito:"));
			break;
		case 2://Query no válida
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Query no válida","Ingrese Query válida."));
			break;
		case 3://Configuracion válida
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Configuracion válida","Exito"));		
			break;
		case 4://Configuracion No válida
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Configuración erronea","La configuración no es válida"));		
			break;
		case 5://Configuracion Ventana Transformado
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Carácter no válido","Ingrese cácacter válido."));		
			break;			
		default:
			break;
		}
	}

}
