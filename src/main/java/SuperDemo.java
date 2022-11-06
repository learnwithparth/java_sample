public class SuperDemo {
    int i = 10;
    int j = 30;

    SuperDemo(int i){
        System.out.println("Constructor of super class called");
    }
    void myMethod(){
        System.out.println("Method from super class");
    }
}

class SubClass extends SuperDemo {
    int i = 20;

    SubClass(){
        super(10); // calling super class constructor, must first statement
        System.out.println("Constructor of sub class called");
    }

    void myMethod(){
        System.out.println("Instance variable of subclass "+ i);
        System.out.println("Instance variable of superDemo "+ super.i); // to access variable of superclass
        super.myMethod(); // to access method of the parent class
    }

    public static void main(String[] args) {
        SubClass s = new SubClass();
        s.myMethod();
    }
}
