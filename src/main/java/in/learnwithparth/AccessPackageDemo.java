package in.learnwithparth;

import mypck.AccessDemo;

public class AccessPackageDemo {
    public static void main(String[] args) {
        AccessDemo a = new AccessDemo();
        a.myDefaultVariable = 30; // default member within a same package
        a.myPrivateVariable = 30; // private member is not accessible outside class
        a.myProtectedVariable= "XYZ" ; // protected member is not accessible to other package
        a.myPublicVariable = true; // can access the public variable
        SubClass s = new SubClass();

    }
}

class SubClass extends AccessDemo{
    void myMethod(){
        myProtectedVariable = "XYZ"; // protected member is accessible in subclass to other package
    }
}
