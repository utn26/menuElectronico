package Ventanas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import clases.Menu;
import clases.Producto;

//este es el marco Princitali
public class PanelPrincipal extends JFrame implements ActionListener
{
	//vista 1
	
	
	private JPanel panelNorte;
	private JPanel panelSur;
	private JPanel cardPanel;
		//panel bienvenida
	private PanelBienvenida bienvenida;
	private CardLayout cl;
	private int actual = 0;
	private PanelMenu menu;
	private PanelMenu menuCeliaco;
	private PanelMenu menuVegetariano;
	private PanelMenu menuCyV;
	private Menu listaDeProductos = new Menu();
	
	//Haciendo....
	private PanelPreConfirmacion preConfirmacion;
	
	//..
	private final String menuParaTodos = "1";
	private final String pantallaPreConfirmacion = "2";
	 JButton siguiente = new JButton("siguiente"); 
	 JButton anterior = new JButton("anterior");
	 JButton botonInicio = new JButton("inicio");
	 JButton realizarPedido = new JButton("realizar pedido");
	 
	ArrayList<Producto> prodCeliacos = listaDeProductos.menuCeliaco();
	ArrayList<Producto> prodVegetarianos = listaDeProductos.menuVegetariano();
	ArrayList<Producto> prodCyV = listaDeProductos.menuVYC();
	
	public PanelPrincipal()
	{ 
		cardPanel = new JPanel();
		cl = new CardLayout();
		cardPanel.setLayout(cl);
		panelNorte = new JPanel();
		panelSur = new JPanel();
		
		bienvenida = new PanelBienvenida();
		
		
		listaDeProductos = new Menu();
		
		
		cardPanel.add(bienvenida,"0");

		
		panelNorte.add(botonInicio);
    	panelSur.add(siguiente);
    	panelSur.add(realizarPedido);
    	panelSur.add(anterior);
    	realizarPedido.setVisible(false);
    	anterior.setVisible(false);
		
    	
		
		setVisible(true);
		setSize(400,400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		realizarPedido.addActionListener(new EscuchaRealizarPedido());
		anterior.addActionListener(new EscuchaAnterior());
		siguiente.addActionListener(this);
					
		botonInicio.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						actual=0;
						cl.show(cardPanel,""+actual);
						siguiente.setVisible(true);
						realizarPedido.setVisible(false);
						anterior.setVisible(false);
					}
				}
	    );
		
		
		//aca dispoemos los paneles en el borderLayout
		getContentPane().add(panelNorte, BorderLayout.NORTH);
		getContentPane().add(cardPanel, BorderLayout.CENTER);
		getContentPane().add(panelSur,BorderLayout.SOUTH);
	}
		
	public void actionPerformed(ActionEvent e)
	{
		actual = 1;
		if(bienvenida.celiacos.isSelected() && bienvenida.vegetarianos.isSelected())
		{
			
			menu = new PanelMenu(listaDeProductos.getComidas(prodCyV),listaDeProductos.getBebidas(prodCyV),listaDeProductos.getPostres(prodCyV));
			
	
		}
			else if(bienvenida.celiacos.isSelected()&&(bienvenida.vegetarianos.isSelected()==false) )
			{
				
				menu = new PanelMenu(listaDeProductos.getComidas(prodCeliacos),listaDeProductos.getBebidas(prodCeliacos),listaDeProductos.getPostres(prodCeliacos));
						}	
				else if(bienvenida.vegetarianos.isSelected()&&(bienvenida.celiacos.isSelected()==false))
				{
				
					menu = new PanelMenu(listaDeProductos.getComidas(prodVegetarianos),listaDeProductos.getBebidas(prodVegetarianos),listaDeProductos.getPostres(prodVegetarianos));
					
					
				}
					else	
					{	
						
						menu = new PanelMenu(listaDeProductos.getComidas(listaDeProductos.getMenu()),listaDeProductos.getBebidas(listaDeProductos.getMenu()),listaDeProductos.getPostres(listaDeProductos.getMenu()));
					
					}
						
					
						
		cardPanel.add(menu, "1");
		cl.show(cardPanel,menuParaTodos);
		
		if(actual>0){
			siguiente.setVisible(false);
		}
		if(actual!=1)
		{
			realizarPedido.setVisible(false);
		}else
			{
			realizarPedido.setVisible(true);
			}
		anterior.setVisible(true);
		
	}
	
	class EscuchaRealizarPedido implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			//este switch elije el numero de panel y carga el precio a la siguiente ventana
			switch(actual)
			{
				case 1:
					preConfirmacion = new PanelPreConfirmacion(menu.getPrecio());
					break;
				case 2:	
					preConfirmacion = new PanelPreConfirmacion(menuCeliaco.getPrecio());
					break;
				case 3:
					preConfirmacion = new PanelPreConfirmacion(menuVegetariano.getPrecio());
					break;
				case 4:
					preConfirmacion = new PanelPreConfirmacion(menuCyV.getPrecio());
					break;
			}
			actual++;
			cardPanel.add(preConfirmacion,pantallaPreConfirmacion);
			cl.show(cardPanel,pantallaPreConfirmacion);
			if(actual!=1)
			{
				realizarPedido.setVisible(false);
			}else
				{
				realizarPedido.setVisible(true);
				}
			
			//...
		}
	}
	class EscuchaAnterior implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			//este switch elije el numero de panel y carga el precio a la siguiente ventana
			actual = actual - 1;
			
			cl.show(cardPanel,""+(actual));
			
			if(actual!=1)
			{
				realizarPedido.setVisible(false);
			}else
				{
				realizarPedido.setVisible(true);
				}
			if(actual==0)
			{
				siguiente.setVisible(true);
			}
			if(actual<1)
			{
				anterior.setVisible(false);
			}
			//...
		}
	}
	
	
}
