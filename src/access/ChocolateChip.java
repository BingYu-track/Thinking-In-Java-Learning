package access;

import access.dessert.Cookie;

public class ChocolateChip extends Cookie{
    public ChocolateChip(){
        System.out.println("ChocolateChip constructor");
    }

    public void chomp(){
        bite();//无法调用继承自Cookie的bite方法，因为bite方法存在包访问权限,非同包的子类无法访问
    }

    public static void main(String[] args){

    }
}
