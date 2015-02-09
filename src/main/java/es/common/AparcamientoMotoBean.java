package es.common;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

@ManagedBean(name="aparcamientoMoto")
@SessionScoped

public class AparcamientoMotoBean implements Serializable{

	 
		
		private DataSource ds;
	 
		//if resource injection is not support, you still can get it manually.
		public AparcamientoMotoBean(){
			try {
				Context ctx = new InitialContext();
				ds = (DataSource)ctx.lookup("java:comp/env/jdbc/myoracle");
			} catch (NamingException e) {
				e.printStackTrace();
			}
	 
		}
	 
		//connect to DB and get customer list
		public List<AparcamientoMoto> getApmList() throws SQLException{
	 
			if(ds==null){
				throw new SQLException("Can't get data source");}
	 
			//get database connection
			Connection con = ds.getConnection();
	 
			if(con==null)
				throw new SQLException("Can't get database connection");
	 
			PreparedStatement ps 
				= con.prepareStatement(
				   "SELECT * FROM APARCAMIENTOSMOTOS"); 
	 
			//get customer data from database
			ResultSet result =  ps.executeQuery();
	 
			List<AparcamientoMoto> list = new ArrayList<AparcamientoMoto>();
	 
			while(result.next()){
				AparcamientoMoto apm = new AparcamientoMoto();
				apm.setDescripcion(result.getString("descripcion"));
				apm.setIcon(result.getString("icono"));
				apm.setId(result.getInt("id"));
				apm.setLastUpdated(result.getString("last_update"));
				apm.setLatitud(result.getDouble("latitud"));
				apm.setLongitud(result.getDouble("longitud"));
				apm.setPlazas(result.getInt("plazas"));
				apm.setTitle(result.getString("titulo"));
				
				 
				//store all data into a List
				list.add(apm);
			}
	 
			return list;
		}
}
