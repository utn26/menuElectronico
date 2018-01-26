package clases;

import java.util.*;

public class Menu
{
    private ArrayList<Producto> menuParaTodos; ;
    private ArrayList<Producto> mVegetariano;
    private ArrayList<Producto> mCeliaco;
    private ArrayList<Producto> mVYC;
    private ArrayList<Producto> comidas;
    private ArrayList<Producto> bebidas;
    private ArrayList<Producto> postres;
	final int COMIDA = 1;
	final int BEBIDA = 2;
	final int POSTRE = 3;
    
    public Menu()
    {
    	menuParaTodos = new ArrayList<Producto>();
    	Producto coca_cola = new Producto();
    	coca_cola.setNombre("coca cola");
    	coca_cola.setPrecio(50f);
    	coca_cola.setTipo(BEBIDA);
    	coca_cola.setId_producto(0001);
    	coca_cola.setCeliaco(true);
    	coca_cola.setVegetariano(true);
    	coca_cola.setMaridaje(menuParaTodos);
    	menuParaTodos.add(coca_cola);
    	//Producto(int id, String nom, float prec, boolean veg, boolean cel, ArrayList<Producto> marid,int tip 
    	Producto sprite = new Producto(0002,"sprite", 50f, true, true,menuParaTodos,BEBIDA);
    	menuParaTodos.add(sprite);
    	Producto glaciar = new Producto(0003, "glaciar", 26f, true, true, menuParaTodos, BEBIDA);
    	menuParaTodos.add(glaciar);
    	Producto fanta = new Producto(0004, "fanta", 50f, true, true, menuParaTodos, BEBIDA);
    	menuParaTodos.add(fanta);
    	Producto levite = new Producto(0005, "levite", 26f, true, true, menuParaTodos, BEBIDA);
    	menuParaTodos.add(levite);
    	
    	Producto cerveza = new Producto(0005, "cerveza", 26f, true, false, menuParaTodos, BEBIDA);
    	menuParaTodos.add(cerveza);
    	Producto milanesa = new Producto(0006,"milanesa" ,120f ,false ,false, menuParaTodos,COMIDA );
    	menuParaTodos.add(milanesa);
    	Producto tofu = new Producto(0007, "tofu", 120f, true, true, menuParaTodos,COMIDA);
    	menuParaTodos.add(tofu);
    	Producto sopaDeVerduras = new Producto(8, "sopa de verduras",100f ,true ,true,menuParaTodos,COMIDA );
    	menuParaTodos.add(sopaDeVerduras);
    	Producto milanesaDeSoja = new Producto(9, "milanesa de soja",120f ,true ,false,menuParaTodos,COMIDA );
    	menuParaTodos.add(milanesaDeSoja);
    	Producto helado = new Producto(11, "helado",100f ,true ,true,menuParaTodos,POSTRE );
    	menuParaTodos.add(helado);
    	Producto lemonPie = new Producto(12, "Lemon Pie",100f ,true ,true,menuParaTodos,POSTRE );
    	menuParaTodos.add(lemonPie);
    	Producto pastaFrola = new Producto(13, "pasta frola",100f ,true ,false,menuParaTodos,POSTRE );
    	menuParaTodos.add(pastaFrola);
    	Producto bife = new Producto(14, "bife",150f ,false ,true,menuParaTodos,COMIDA );
    	menuParaTodos.add(bife);
    	
    }
    
    // este metodo te devuelve el menu vegetariano
    public ArrayList<Producto> menuVegetariano()
    {
    	mVegetariano = new ArrayList<Producto>();
    	
    	for(Producto p:menuParaTodos) 
    	{
    		if(p.isVegetariano())
    		{
    				mVegetariano.add(p);
    		}
    	}	
    	
    	return mVegetariano;
    }
    
 // este metodo te devuelve el menu celiaco
    public ArrayList<Producto> menuCeliaco()
    {
    	mCeliaco = new ArrayList<Producto>();
    	
    	for(Producto p:menuParaTodos) 
    	{
    		if(p.isCeliaco())
    		{
    				mCeliaco.add(p);
    		}
    	}	
    	
    	return mCeliaco;
    }
    
    
    // este metodo te devuelve el menu vegetariano y celiaco
    public ArrayList<Producto> menuVYC()
    {
    	mVYC = new ArrayList<Producto>();
    	
    	for(Producto p:menuParaTodos) 
    	{
    		if(p.isCeliaco()&&p.isVegetariano())
    		{
    				mVYC.add(p);
    		}
    	}	
    	
    	return mVYC;
    }
   // este metodo dado una lista de productos devuelve una lista de comidas
    public ArrayList<Producto> getComidas(ArrayList<Producto> productos)
    {
    	comidas = new  ArrayList<Producto>();
    	for(Producto p:productos) 
    	{
    		if(p.getTipo() == COMIDA)
    		{
    				comidas.add(p);
    		}
    	}	
    	return comidas;
    }
 // este metodo dado una lista de productos devuelve una lista de bebidas
    public ArrayList<Producto> getBebidas(ArrayList<Producto> productos)
    {
    	bebidas = new  ArrayList<Producto>();
    	for(Producto p:productos) 
    	{
    		if(p.getTipo() == BEBIDA)
    		{
    				bebidas.add(p);
    		}
    	}	
    	return bebidas;
    }
    
    // este metodo dado una lista de productos devuelve una lista de Postres
    public ArrayList<Producto> getPostres(ArrayList<Producto> productos)
    {
    	postres = new  ArrayList<Producto>();
    	for(Producto p:productos) 
    	{
    		if(p.getTipo() == POSTRE)
    		{
    				postres.add(p);
    		}
    	}	
    	return postres;
    }
    
    
    
    public ArrayList<Producto> getMenu()
    {
    	return menuParaTodos;
    }
}
