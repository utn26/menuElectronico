package menu_electronico;
import java.sql.*;
import java.util.Scanner;
public class Bb
{
	
	public void cargarProductos(int i, String nom, float prec, int cantDeman, String aptoP, int i_men){
	   
		try
		{
		   
		
			//1.creamos la conexion:
			Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/menu_electronico","root","");
			//2.creamos objeto statement
			Statement miStatement = miConexion.createStatement();
			//3.ejecutar sql
			String instruccionSql = "INSERT INTO producto (id, nombre, precio, cantDemandada, aptoPara, id_menu) VALUES ("+i+",'"+nom+"',"+prec+","+cantDeman+",'"+aptoP+"',"+i_men+")";
			//("+i+","+nom+","+prec+","+cantDeman+","+aptoP+","+i_men+")
			miStatement.executeUpdate(instruccionSql);
			
			ResultSet miResultset= miStatement.executeQuery("SELECT* FROM producto");
			//4. leer el resulset
			
			System.out.println("datos:");
			
			while(miResultset.next())
			{
				System.out.println(miResultset.getString("id")+" "+miResultset.getString("nombre")+" "+miResultset.getString("precio")+" "+miResultset.getString("cantDemandada")+" "+miResultset.getString("aptoPara")+" "+miResultset.getString("id_menu"));
			}
		}
		catch(Exception e)
		{
			System.out.println("no se conecto");
			e.printStackTrace();
		}
	}
}
