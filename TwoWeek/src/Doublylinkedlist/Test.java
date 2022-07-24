package Doublylinkedlist;

public class Test {
    public static void main(String[] args) {
        Lianbiao<String>s1=new Lianbiao<>();


        s1.insert("姿态");
        s1.insert("水晶哥");
        s1.insert("勒特me");
        s1.insert(1,"尖勾");
        for(Object s:s1){
            System.out.println(s);
        }

        System.out.println("------------------------------");

        //获取
        String getResult=s1.gets(1);
        System.out.println("获取的索引1的结果为："+getResult);
        System.out.println("_______________________");
        //目前链表
        System.out.println("目前链表：");
        for(Object s:s1){
            System.out.println(s);
        }
        System.out.println("_______________________");
        //删除
        String removeResult=s1.remove(0);
        System.out.println("删除元素是:"+removeResult);

        System.out.println("清空后的元素个数为"+s1.lLenght());
        //目前链表
        System.out.print("目前链表：           ");
        for(Object s:s1){
            System.out.println(s);
        }


        System.out.println("_______________________");
        System.out.println("第一个元素是"+s1.getFirst());

        System.out.println("最后个元素是"+s1.getLast());
        System.out.println("_______________________");

        //反转链表
        s1.reverse();
        System.out.println("目前链表:");
        for(Object s:s1){
            System.out.println(s);
        }
        //清空
        System.out.println("清空");
        s1.clear();
        System.out.println("目前链表:");
        for(Object s:s1){
            System.out.println(s);
        }
    }

}

