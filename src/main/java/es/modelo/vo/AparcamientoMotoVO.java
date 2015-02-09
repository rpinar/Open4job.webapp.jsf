package es.modelo.vo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AparcamientoMotoVO {

	private double latitud;
	private double longitud;
	private String title;
	private String icon;
	private String descripcion;
	private String lastUpdated;
	private int plazas;
	private int id;

	public AparcamientoMotoVO(double latitud, double longitud, String title,
			String icon, String descripcion, String lastUpdated, int plazas,
			int id) {

		this.latitud = latitud;
		this.longitud = longitud;
		this.title = title;
		this.icon = icon;
		this.descripcion = descripcion;
		this.lastUpdated = lastUpdated;
		this.plazas = plazas;
		this.id = id;

	}

	public double getLatitud() {
		return latitud;
	}

	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}

	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public int getPlazas() {
		return plazas;
	}

	public void setPlazas(int plazas) {
		this.plazas = plazas;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String toString() {
		return ("AparcamientoMotoVO = [ " + "latitud = " + latitud + ", "
				+ "longitud = " + longitud + ", " + "title = " + title + ", "
				+ "icon = " + icon + ", " + "descripcion = " + descripcion
				+ ", " + "lastUpdate = " + lastUpdated + ", " + " plazas = "
				+ plazas + ", " + "id = " + id + ", ");
	}

	public void borrarArchivoCSV(boolean borrar) {
		if (borrar) {
			File archivo = new File("/var/www/html/aparcamientoMoto.csv");
			archivo.delete();
		}
	}

	public void escribirCSV() {
		File archivo = new File("/var/www/html/aparcamientoMoto.csv");
		String texto = null;

		if (archivo.exists()) {
			texto = "'" + id + "','" + title + "','" + descripcion + "','"
					+ plazas + "','" + lastUpdated + "','" + latitud + "','"
					+ longitud + "','" + icon + "'\n";
		} else {
			texto = "'ID','TITULO','DESCRIPCION','PLAZAS','LAST_UPDATE','LATITUD','LONGITUD','ICONO'\n";
			texto = texto + "'" + id + "','" + title + "','" + descripcion
					+ "','" + plazas + "','" + lastUpdated + "','" + latitud
					+ "','" + longitud + "','" + icon + "'\n";
		}

		try {
			FileWriter fwriter = new FileWriter(archivo, true);
			fwriter.write('\ufeff');
			fwriter.write(texto);
			fwriter.flush();
			fwriter.close();
		} catch (IOException e) {
			Logger.getLogger(AparcamientoMotoVO.class.getName()).log(
					Level.SEVERE, null, e);
		}
	}

}
