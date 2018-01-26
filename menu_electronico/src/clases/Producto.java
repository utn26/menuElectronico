package clases;

import java.util.*;


public class Producto
{
	private int id_producto;
	private String nombre;
	private float precio;
	private boolean vegetariano;
	private boolean celiaco;
	private ArrayList<Producto> maridaje;
	private int tipo;
	
	
	public Producto()
	{
		
	}
	public Producto(int id, String nom, float prec, boolean veg, boolean cel, ArrayList<Producto> marid,int tip ){
		
		id_producto = id;
		nombre = nom;
		precio = prec;
		vegetariano = veg;
		celiaco = cel;
		maridaje = marid;
		tipo = tip;
		
	}
	


	public int getId_producto()
	{
		return id_producto;
	}



	public void setId_producto(int id_producto)
	{
		this.id_producto=id_producto;
	}



	public String getNombre()
	{
		return nombre;
	}



	public void setNombre(String nombre)
	{
		this.nombre=nombre;
	}



	public float getPrecio()
	{
		return precio;
	}



	public void setPrecio(float precio)
	{
		this.precio=precio;
	}



	public boolean isVegetariano()
	{
		return vegetariano;
	}



	public void setVegetariano(boolean vegetariano)
	{
		this.vegetariano=vegetariano;
	}



	public boolean isCeliaco()
	{
		return celiaco;
	}



	public void setCeliaco(boolean celiaco)
	{
		this.celiaco=celiaco;
	}



	public ArrayList<Producto> getMaridaje()
	{
		return maridaje;
	}



	public void setMaridaje(ArrayList<Producto> maridaje)
	{
		this.maridaje=maridaje;
	}



	public int getTipo()
	{
		return tipo;
	}



	public void setTipo(int tipo)
	{
		this.tipo = tipo;
	}
	
	
}
