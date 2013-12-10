


public class MiClase {

	public static void main(String[] args) {
		
		Hilo hilo1 = new Hilo("Pepe");
		hilo1.start();
		
		
		Hilo hilo2 = new Hilo("Maria");
		hilo2.start();
		
		Hilo hilo3 = new Hilo("Miguel");
		hilo3.start();		
	}	
}

class Hilo extends Thread{

	String nombre;
	
	public Hilo(String nombre){
	
	this.nombre = nombre;
	}
	@Override
	public void run() {
		
		for (int i=-5; i < 5; i++){
		
			System.out.println(nombre + "" + i);
		}		
	}
}