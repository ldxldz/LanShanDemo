package Jisuanqi;




public class Test {
    public static void main(String[] args) {
        String list[]= {"1+2+3+4+5+6","(3 + (5 - 2) * 10 / 2 * 3 + 15) * (8 - 4)","55+22+11-66"
        };
        Computer s1 = new Computer();
        for (int i = 0; i < 3; i++) {
            System.out.println("----------");
            System.out.println(s1.cal(list[i]));
        }
    }
}
