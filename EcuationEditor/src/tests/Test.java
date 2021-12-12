package tests;

import model.Funtion;

public class Test {

	private Funtion funcion;
	
	public Test() {
		funcion = new Funtion("x^6", -5, 10);
	}
	
	public void star() {
		funcion.calculateData();
		
		for(int i=0; i<funcion.getData().length; i++) {
		    System.out.println(funcion.getData()[i]);
			//System.out.println(funcion.getFuntion());
	    }
	}

}