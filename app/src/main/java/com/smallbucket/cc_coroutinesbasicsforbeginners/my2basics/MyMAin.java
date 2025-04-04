package com.smallbucket.cc_coroutinesbasicsforbeginners.my2basics;

public class MyMAin {
    public static void main(String[] args) {
        MyClass.MyObject.f(); // without   @JvmStatic
        MyClass.f(); //with   @JvmStatic
        // note - calling static variable = ClassName.staticVariablename
    }
}
