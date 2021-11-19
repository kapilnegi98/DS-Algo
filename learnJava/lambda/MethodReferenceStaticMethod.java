package learnJava.lambda;

interface Sample2<T>{
	boolean upper(T s1);
}
class SomeClass{
	int k = 5;
	static <T> boolean upperFunc(T s) {
		return true;
	}
	boolean cam(SomeClass obj) {
		return this.k == obj.k;
	}
}
public class MethodReferenceStaticMethod {

//	public static <T> boolean stringOps(Sample2<T> sam, T v1, T v2) {
//		return sam.upper(v1,v2);
//	}
public static <T> boolean check(Sample2<T> sam, T s1) {
	return sam.upper(s1);
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		boolean res = stringOps(SomeClass::cam, new SomeClass(), new SomeClass());
		boolean res = check(SomeClass::upperFunc, "ss");
//		System.out.println(res);
	}

}
