package learnJava.Generics;

import java.util.ArrayList;

interface MinMax<T extends Comparable<T>>{
	T min();
	T max();
}
class MyClass<T extends Comparable<T>> implements MinMax<T>{
	
	T[] vi;
	MyClass(T[] vi){
		this.vi = vi;
	}
	
	@Override
	public T min() {
		// TODO Auto-generated method stub
		T v = vi[0];
		for(int i = 0;i < vi.length;i++) {
			if(vi[i].compareTo(v) < 0) {
				v = vi[i];
			}
		}
		return v;
	}

	@Override
	public T max() {
		T v = vi[0];
		for(int i = 0;i < vi.length;i++) {
			if(vi[i].compareTo(v) > 0) {
				v = vi[i];
			}
		}
		return v;
	}
	<E extends Number, P> boolean func(P x, E y) {
		
		return y.doubleValue() == 2;
	}
}
class Temp<T, V extends Number>{
	T o;
	V o2;
//	Temp (T o){
//		this.o = o;
//	}
	T get() {
		return o;
	}
//	boolean isSame(Temp<?> ob) {
//		return o == ob.o;
//	}
	void set(T o) {
		this.o = o;
	}
	void set(V o2) {
		this.o2 = o2;
	}
	
	
}
public class SimpleExample {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		
		Temp<Integer,Integer> ob = new Temp<>();
		ArrayList<Integer> arr[] = new ArrayList[30];
	
	}

}
