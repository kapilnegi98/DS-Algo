/*
you can use only one queue to work as a stack... check class video

*/public class OOPS{
    
    public static class Student{
        String name;
        int age;
        
        public void printDetails(){
            System.out.println(this.name + "[" + this.age + "]" + ".");
        }
        
        //default constructor
        public Student(){
            
        }
        
        //parameterized constructor
        public Student(String n, int a){
            this.name = n;
            this.age = a;
        }
        
        public Student(String name){
            this.name = name;
        }
        
        public Student(int age){
            this.age = age;
        }
    }
    
    
    
    public static void main(String[] args){
       Student s1 = new Student("A", 10);
       Student s2 = new Student("B", 20);
       
       s1.printDetails();
      s2.printDetails();
    }
    
    public static void swap(Student s1, Student s2){
        Student temp = s1;
        s1 = s2;
        s2 = temp;
    }
    
    public static void swap2(Student s1, Student s2){
        String temp = s1.name;
        s1.name = s2.name;
        s2.name = temp;
        
        int t = s1.age;
        s1.age = s2.age;
        s2.age = t;
    }
    
    public static void swap3(Student s1, Student s2){
        String temp = s1.name;
        s1.name = s2.name;
        s2.name = temp;
        
        s1 = new Student();
        int t = s1.age;
        s1.age = s2.age;
        s2.age = t;
    }
    
    public static void swap4(Student s1, Student s2){
        s1 = new Student();
        String temp = s1.name;
        s1.name = s2.name;
        s2.name = temp;
        
        s2 = new Student();
        int t = s1.age;
        s1.age = s2.age;
        s2.age = t;
    }
    
     public static void swap5(Student s1, Student s2){
        String temp = s1.name;
        s1.name = s2.name;
        s2.name = temp;
        
        s2 = new Student();
        int t = s1.age;
        s1.age = s2.age;
        s2.age = t;
        s1 = new Student();
    }
    
}
