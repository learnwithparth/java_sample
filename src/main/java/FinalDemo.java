public final class FinalDemo { // should not be changed

    final int myVariable = 10; // constant

    final void myMethod(){ // constant, overriding is not possible
        // myVariable = 20; //error
    }
}

//class SubClass extends FinalDemo{
//    void myMethod(){  // error - overriding is not possible
//
//    }
//}
