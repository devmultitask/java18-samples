package devmultitask.teste1;

public class PatternMatchingComSwitch {

	@SuppressWarnings("preview")
	static void testePoligono(Poligono poligono) {
		
		System.out.println("-> Testando: "+poligono);
	    switch (poligono) {
	        case null:
	        	System.out.println("Nulo");
	            break;
	        case Triangulo t:
	            System.out.println("Triângulo equilátero, escaleno ou isósceles");
	            break;
	        case Retangulo r:
	            if (r.isQuadrado()) {
	            	System.out.println("Quadrado");
	            } else {
	            	System.out.println("Retangulo irregular");
	            }
	            break;
	        default:
	            System.out.println("Polígono com mais de 4 lados");
	    }
	}
	
	public static void main(String[] args) {
		 
		 System.out.println("=== testePoligono(null);");
		 testePoligono(null); 
		 
		 System.out.println("\n=== testePoligono(new Triangulo());");
		 testePoligono(new Triangulo());
		 
		 System.out.println("\n=== testePoligono(ladosDiferentes);");
		 Retangulo ladosDiferentes = new Retangulo();
		 testePoligono(ladosDiferentes);
		 
		 System.out.println("\n=== testePoligono(ladosIguais);");
		 Retangulo ladosIguais = new Retangulo();
		 ladosIguais.quadrado=true;
		 testePoligono(ladosIguais);
		 
		 System.out.println("\n=== testePoligono(retanguloEstranho);");
		 Poligono retanguloEstranho = new Poligono();
		 retanguloEstranho.lados= 10;
		 testePoligono(retanguloEstranho); 
 
	}
 
}
