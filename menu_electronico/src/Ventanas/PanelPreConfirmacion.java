package Ventanas;

import javax.swing.*;

public class PanelPreConfirmacion extends JPanel
{
	private JLabel informacion;
	
	public PanelPreConfirmacion(String cuenta)
	{
		informacion = new JLabel("Su pedido es de: \n "+cuenta+" $");
		add(informacion);
	}
}
