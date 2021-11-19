package StackQueue;

import java.util.ArrayList;
import java.util.List;

public class SQPractice {
	public static void main(String[] args) throws Exception {
	    List<List<Integer>> res = new ArrayList<>();
	    List<Integer> temp = new ArrayList<>();
	    temp.add(1);
	    res.add(temp);
	    temp.add(2);
	    System.out.println(res);
	}
}
