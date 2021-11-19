package learnJava.lambda;

interface SomeFunc2{
	double func(int[] arr) throws EmptyArrayException;
}
class EmptyArrayException extends Exception{
	public EmptyArrayException(String msg) {
		super(msg);
	}
}
class Sample {
	int v1;
	static int func() {
		System.out.println(this);
		return 2;
	}
}
public class LambdaException  {

	
	public static void main(String[] args) throws EmptyArrayException{
		// TODO Auto-generated method stub
		int a = 5;
		SomeFunc2 ob = (arr) -> {
			
			if(arr.length == 0) {
				throw new EmptyArrayException("len is 0");
			}
			double sum = 0;
			for(int i = 0;i < arr.length;i++) {
				sum += arr[i];
			}
			return sum/arr.length;
		};
		Sample s = new Sample();
		s.func();
		System.out.println(ob.func(new int[0]));
		
		
	}

}
