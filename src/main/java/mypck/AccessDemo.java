package mypck;

public class AccessDemo {
    int myDefaultVariable = 10; // default
    private double myPrivateVariable = 20;
    protected String myProtectedVariable = "ABC";
    public boolean myPublicVariable = false;
}

class AccessDemoMain{
    public static void main(String[] args) {
        AccessDemo a = new AccessDemo();
        a.myDefaultVariable = 30; // default member within a same package
        a.myPrivateVariable = 30; // private member is not accessible outside class
        a.myProtectedVariable= "XYZ" ; // protected member with a same package
        a.myPublicVariable = true; // can access the public variable
    }
}