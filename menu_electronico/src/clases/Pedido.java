package clases;

import java.util.LinkedList;

public class Pedido
{
	private int nroPedido;
	private int nroMesa;
	private boolean yaEsta=false;
    private LinkedList productosPedidos;
    
	
    public void llenarPedido()
	{
	//aca se llena la lista de pedido. 	
	}

	
	
	
	
	public int getNroPedido()
	{
		return nroPedido;
	}

	public void setNroPedido(int nroPedido)
	{
		this.nroPedido=nroPedido;
	}

	public int getNroMesa()
	{
		return nroMesa;
	}

	public void setNroMesa(int nroMesa)
	{
		this.nroMesa=nroMesa;
	}

//	public boolean isElaborado()
//	{
//		return elaborado;
//	}
//
//	public void setElaborado(boolean elaborado)
//	{
//		this.elaborado=elaborado;
//	}

	public LinkedList getProductosPedidos()
	{
		return productosPedidos;
	}

	public void setProductosPedidos(LinkedList productosPedidos)
	{
		this.productosPedidos=productosPedidos;
	}
	
	
	
}
