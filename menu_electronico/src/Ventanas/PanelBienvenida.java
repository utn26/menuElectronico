package Ventanas;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class PanelBienvenida extends JPanel
{
	
	
	 protected JCheckBox celiacos = new JCheckBox("celiacos");
	 protected JCheckBox vegetarianos = new JCheckBox("vegetarianos");
	
	 protected JLabel textoBienvenida = new JLabel("Bienvenido");
	
	public PanelBienvenida()
	{
		
		
			
		//seteamos el gridBagLayout
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		//cambiamos el tamaño y el color al mensaje de bienvenida
		
		textoBienvenida.setForeground(Color.white);
		Font titulo = textoBienvenida.getFont();
		textoBienvenida.setFont(new Font(titulo.getFontName(),titulo.getStyle(),50));
		
//		PanelBienvenida manejador = new PanelBienvenida();
//		celiacos.addItemListener(manejador);
		
		gbc.gridx=0;
		gbc.gridy = 0;
		gbc.gridwidth = 11;
		gbc.gridheight = 2;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.CENTER;
		
		add(this.textoBienvenida,gbc);
		
		gbc.gridx=3;
		gbc.gridy = 3;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.CENTER;
		
		add(this.celiacos,gbc);
		
		gbc.gridx=6;
		gbc.gridy = 3;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.CENTER;
		
		
		add(this.vegetarianos,gbc);
		
		
	}
	
	
	
	
	//esta funcion cambia el fondo del panel
	
	@Override
	public void paintComponent(Graphics g)
	{
		Dimension dim = getSize();
		
		ImageIcon imagen = new ImageIcon(new ImageIcon(getClass().getResource("/menu_electronico/fondo.jpg")).getImage() );
		g.drawImage(imagen.getImage(),0,0,dim.width,dim.height,null);
	}
}
