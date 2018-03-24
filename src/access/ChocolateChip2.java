package access;

import access.cookie2.Cookie;

public class ChocolateChip2 extends Cookie{ //这里的Cookie与子类也不在同一个包中，但bite方法的访问权限是protected，非同包的子类可以访问

    public ChocolateChip2() {
        System.out.println("ChocolateChip2 constructor");
    }

    public void chomp(){
        bite();
    }  //
}
