package com.company;
import java.math.BigDecimal;









//public class Main {
//    private int mem = 10;
//    class Inner {
//        private int imem = new Main().mem; // ACCESS1
//    }
//    public static void main(String []s) {
//        System.out.println(new Main().new Inner().imem); // ACCESS2
//    }
//}
class base1 {
    protected int var;
}
interface base2 {
    int var = 0; // #1
}
public class Main {
    public static void main(String args[]) {
        boolean b=true;
        System.out.println(b ? true : false);

    }
}
 class WildCard {
    interface BI {}
    interface DI extends BI {}
    interface DDI extends DI {}
    static class C<T> {}
    static void foo(C<? super DI> arg) {}
    public static void main(String []args) {
        foo(new C<BI>()); // ONE
        foo(new C<DI>()); // TWO
 //       foo(new C<DDI>()); // THREE
        foo(new C()); // FOUR
    }
}









