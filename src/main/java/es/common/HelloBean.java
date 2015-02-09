package es.common;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import java.io.Serializable;

import java.util.Calendar;
import java.util.Date;
 
@ManagedBean
@SessionScoped

public class HelloBean implements Serializable {
 
	private static final long serialVersionUID = 1L;
 
	private String name;
	private int edad;
	private Date fecha;
	
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
}