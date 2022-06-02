package devmultitask.teste1;

public class Poligono {
	
	public int lados;
	
	public int getLados() {
		return lados;
	}
	
	public Poligono() {
		this.lados = 1;
	}
	
	public Poligono(int lados) {
		super();
		this.lados = lados;
	}

	@Override
	public String toString() {
		return "Poligono [lados=" + lados + "]";
	}

}
