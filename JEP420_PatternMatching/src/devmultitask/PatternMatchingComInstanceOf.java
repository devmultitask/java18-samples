package devmultitask;

public class PatternMatchingComInstanceOf {

	public static void main(String[] args) {

		System.out.println(ifAntigo("teste"));
		System.out.println(ifNovo("teste"));

		System.out.println(ifAntigo(111));
		System.out.println(ifNovo(111));

	}

	static String ifAntigo(Object object) {

		String retorno = null;
		if (object instanceof String) {
			String s = (String) object;
			retorno = "é uma String com " + s.length() + " caracteres";
		}
		if (object instanceof Integer) {
			Integer i = (Integer) object;
			retorno = "é um Integer com o valor de " + i.intValue();
		}

		return "["+object+"] "+retorno;
	}

	static String ifNovo(Object object) {

		String retorno = null;
		if (object instanceof String s) {
			retorno = "é uma String com " + s.length() + " caracteres";
		}
		if (object instanceof Integer i) {
			retorno = "é um Integer com o valor de " + i.intValue();
		}

		return "["+object+"] "+retorno;
	}
}
