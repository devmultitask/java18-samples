package devmultitask;

public class PatternMatchingComSwitch {

	public static void main(String[] args) {

		System.out.println(switchNovo("teste"));

		System.out.println(switchNovo(111));

		System.out.println(switchNovo(222f));

		System.out.println(switchNovo(222.0d));

		System.out.println(switchNovo(null));
		
	} 

	@SuppressWarnings("preview")
	static String switchNovo(Object object) {

		String retorno   = switch (object) {
		    case null      -> "Nulo";
		    case Integer i -> String.format("int %d", i);
		    case Long l    -> String.format("long %d", l);
		    case Double d  -> String.format("double %f", d);
		    case String s  -> String.format("String %s", s);
		    default        -> object.toString();
		};

		return "["+object+"] "+retorno;
	}
}
