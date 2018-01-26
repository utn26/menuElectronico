package Ventanas;
import javax.swing.*;

import clases.*;
import clases.Menu;

import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class PanelMenu extends JPanel
{
	private JPanel menu;//panel que contiene a los paneles comidas bebidas y postres
	private JPanel comida;
	private JPanel bebida;
	private JPanel postre;
	
	private JPanel boton_imagen;//este panel va a contener el boton y el nombre en la parte inferior
	private JButton boton;//boton imagen
	private JLabel descripcionBoton;//es el nombre del boton que aparece abajo
	
	private JLabel textoComida;//es el titulo del menu de comidas
	private JLabel textoBebida;//es el titulo del menu de bebidas
	private JLabel textoPostre;//es el titulo del menu de postres
	private JLabel textoMaridaje;//es el texto que mostrara el panel de maridaje
	
	private JPanel panelMaridaje;//este es el panel que mostrara el maridaje 
	
	private JPanel panelDinamico;//este panel va a contener dos paneles que seran dianamicos, que se van a cargar 
	private JPanel panelDinamicoIzquierda;//con el evento de cada boton y a su vez se va  a calcular el monto total
	private JPanel panelDinamicoDerecha;//
	
	private JPanel panelSur;//panel que se ubica en la parte inferior del Panel y que contiene al boton borrar, borrar todo y realizar pedido
	private JButton borrar;        //este boton borra el ultimo producto seleccionado, lo borra del panel iquierdo, 
//	private JButton realizarPedido;//y a su vez se actualiza el monto total del panel derecho, realizar pedido nos envia a la siguiente pantalla.
	private JButton borrarTodo;   //borrar todo borra todos los productos cargados en el panel
	
	private Float montoPedido = 0f;  //monto pedido va a mostrar el monto total de la suma de los productos que seleccionemos
	private Float precioUnitario = 0f;//precio unitario es el precio de un producto el cual lo vamos a obtener re recorrer el menu completo buscandolo mediante su nombre de producto
	private Stack<Float> precios = new Stack<Float>();//es una pila la cual vamos a usar para almacenar los precios unitarios de los productos seleccionados, el cual despues nos servira para calcular el precio de montoPedido 
	private Menu menuCompleto;//menu que vamos a usar para buscar los precios de cada producto seleccionado
	private int contadorDeProductos=-1;//contador que vamos usar para obtener el tamaño de la pila de precios y asi saber si tamaño el cual luego utilizaremos para eliminar el ultimo elemento del panel dinamico derecho
	
	
	//constructor del panelMenu recibe como parametros tres ArrayList los cuales seran los menus de comidas bebidas, ,y postres
	public PanelMenu(ArrayList<Producto> comidas,ArrayList<Producto> bebidas ,ArrayList<Producto> postres )
	{
		//el layout que usamos es el boxLayout el cual nos permite organizar los panees uno abajo de otro o uno a lado de otro
		setLayout(new BorderLayout());//en este caso me intereso a mi ubicar los menus uno abajo del otro separado por titulos
		menu = new JPanel();//aca se van a cargar todos los menus uno abajo de otro
		menu.setLayout(new BoxLayout(menu, BoxLayout.Y_AXIS));
		
		textoComida = new JLabel("Comidas:"); //titulo de menu de comidas
		comida = new JPanel();//menu de comidas
		comida.setLayout(new FlowLayout(FlowLayout.LEFT));
		cargarBotones(comidas, boton_imagen, boton, descripcionBoton, comida);//este metodo recibe un menu(arrayList, imagen de boton, nombre del boton, y un panel de comida) y los carga dinamicamente en el panel de comida
		
		textoBebida = new JLabel("Bebidas:"); 
		bebida = new JPanel();
		bebida.setLayout(new FlowLayout(FlowLayout.LEFT));
		cargarBotones(bebidas, boton_imagen, boton, descripcionBoton, bebida);
		
		textoPostre = new JLabel("Postres:"); 
		postre = new JPanel();
		postre.setLayout(new FlowLayout(FlowLayout.LEFT));
		cargarBotones(postres, boton_imagen, boton, descripcionBoton, postre);
		
		borrar = new JButton("borrar");
//		realizarPedido = new JButton("realizar pedido");
		borrarTodo = new JButton("borrar todo");
		
		borrarTodo.addActionListener(new EscuchaBorrarTodo());
		borrar.addActionListener(new EscuchaBorrar());
		
		panelDinamico = new JPanel();
		panelDinamicoIzquierda = new JPanel();
		panelDinamicoDerecha = new JPanel();
		panelDinamico.setLayout(new BoxLayout(panelDinamico,BoxLayout.X_AXIS));
		panelDinamico.add(panelDinamicoIzquierda);
		panelDinamico.add(panelDinamicoDerecha);
		panelSur = new JPanel();
		panelSur.add(borrar);
		panelSur.add(borrarTodo);

		textoMaridaje = new JLabel("esto es el maridaje");
		panelMaridaje = new JPanel();
		panelMaridaje.add(textoMaridaje);
		
		menu.add(textoComida);
		menu.add(comida);
		menu.add(textoBebida);
		menu.add(bebida);
		menu.add(textoPostre);
		menu.add(postre);
		menu.add(panelDinamico);
		add(menu,BorderLayout.CENTER);
		add(panelMaridaje,BorderLayout.EAST);
		
	}
	
	//este metodo carga dinamicamente los botones:
	private void cargarBotones(ArrayList<Producto> menuRecibido,JPanel boton_iamgen, JButton boton, JLabel descripcionBoton, JPanel comida)
	{
		for(Producto p: menuRecibido)
		{
			boton_imagen = new JPanel();
			boton_imagen.setLayout(new BoxLayout(boton_imagen,BoxLayout.Y_AXIS));
			boton = new JButton(""+p.getPrecio()+" $");
			boton.setName(p.getNombre());
			ImageIcon icono = new ImageIcon("imagenes/"+p.getNombre()+".jpg");
			boton.addActionListener(new EscuchaBoton());
			boton.setIcon(icono);
			
			descripcionBoton = new JLabel(p.getNombre());
			boton_imagen.add(boton);
			boton_imagen.add(descripcionBoton);
			comida.add(boton_imagen);
		}
		
	}
	//esta clase interna lanza los eventos de cada boton clickeado y carga los paneles(panel dinamico derecho y paneldinamico izquierdo) en forma dinamica 
	class EscuchaBoton implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			//obtenemos el nombre del boton que lanzo el evento
			String nombre = ((JButton)e.getSource()).getName();
			//buscamos el precio del boton que lanzo el evento buscandolo en el menu completo
			precioUnitario = buscarPrecio(((JButton)e.getSource()).getName());
			montoPedido = montoPedido +precioUnitario;
			precios.push(precioUnitario);
			precioUnitario = 0f;
			//aca cargamos el nombre del boton en un jlabel
			JLabel nombreBoton = new JLabel(nombre+", ");
			panelDinamicoIzquierda.add(nombreBoton);
			panelDinamicoIzquierda.updateUI();//este metodo refresca el panel
			//cargamos el precio total en un label y lo mostramos
			JLabel precioTotal= new JLabel(""+montoPedido+" $");
			//aca removemos todo los elementos que tenga el panel luego cargamos el precio total y luego lo refrescamos
			panelDinamicoDerecha.removeAll();
			panelDinamicoDerecha.add(precioTotal);
			panelDinamicoDerecha.updateUI();
			System.out.println( ((JButton)e.getSource()).getName());
			contadorDeProductos ++;
		}
	}
	//este evento escucha al boton borrar el cual borrara el ultimo elemento agregado al panelDinamido isquierdo, actualizando ademas elprecio mostrado en el panel dinamico derecho
	class EscuchaBorrar implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			
			panelDinamicoIzquierda.remove(contadorDeProductos);
			panelDinamicoIzquierda.updateUI();
			panelDinamicoDerecha.removeAll();
			float ultimoPrecio=0;
			if(!precios.empty())
			{
				ultimoPrecio = precios.pop();
			}
			montoPedido = montoPedido - ultimoPrecio;
			JLabel precioActualizado = new JLabel(""+montoPedido);
			
			panelDinamicoDerecha.add(precioActualizado);
			panelDinamicoDerecha.updateUI();
			contadorDeProductos --;
			precioUnitario = 0f;
		}
		
	}
	
	//este evento escucha al boton borrar todo y lo que hace es borrar todos los elementos del panel dinamico derecho y el izquierdo acutualizando todos los valores
	class EscuchaBorrarTodo implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			panelDinamicoDerecha.removeAll();
			panelDinamicoIzquierda.removeAll();
			panelDinamicoDerecha.updateUI();
			panelDinamicoIzquierda.updateUI();
			montoPedido = 0f;
			contadorDeProductos = 0;
		}
		
	}
	//dado un nombre busca el precio del producto en el menu completo
	public Float buscarPrecio(String nombre)
	{
		float precio=0;
		menuCompleto = new Menu();
		for(Producto p: (menuCompleto.getMenu()))
		{
			if(p.getNombre().toLowerCase().equals(nombre.toLowerCase()))
			{
				precio = p.getPrecio();
			}
		}
		return precio;
	}
	public String getPrecio()
	{
		return ""+montoPedido;
	}
}
