package learnJava.lambda;

interface SomeFunc<T> {
	T func(T x);
}

public class GenericFuntionalInterface {

	public static void upper(SomeFunc<String> f) {
		System.out.println(f.func("hhh"));
	}
	public static void main(String[] args) {

		/*
		 * SomeFunc<String> ob = s -> { return "success"; };
		 * System.out.println(ob.func(""));
		 */
		SomeFunc<String> ob = (s) -> s.toUpperCase();
		upper(ob);
		
		 }

}
