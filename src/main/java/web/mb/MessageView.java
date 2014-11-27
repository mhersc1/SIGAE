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
		case 1://Query v�lida
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Query v�lida",":�xito:"));
			break;
		case 2://Query no v�lida
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Query no v�lida","Ingrese Query v�lida."));
			break;
		case 3://Configuracion v�lida
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Configuracion v�lida","Exito"));		
			break;
		case 4://Configuracion No v�lida
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Configuraci�n erronea","La configuraci�n no es v�lida"));		
			break;
		case 5://Configuracion Ventana Transformado
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Car�cter no v�lido","Ingrese c�cacter v�lido."));		
			break;			
		default:
			break;
		}
	}

}
