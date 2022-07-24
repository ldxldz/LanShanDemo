import java.util.Scanner;

public class Number {
    public static void work(int total, int temp_max, int left, String ans)
    {//total是输入的待分解的目标，temp_max是当前已分解中最大的一项
//left是当前未分解完剩下的，ans是已选择的项组合成的字符串
        String copy_ans=ans;//复制一份，保证递归调用时的ans与上一次调用work时的ans一样
        if (left == 0)//如果不剩
        {
            if(ans.length()==2)//如果ans为"+n"型
                return;
            removeCharAt(ans,0);//否则去掉ans最前面的'+'
            System.out.println(ans);
            return;
        }
        if (left < temp_max )//如果不够取
        {
            return;
        }
        for (int i = temp_max; i <= left; i++)//每次不能取超过式子中最大项，在剩下的里面分类递归
        {
            ans=copy_ans;//保证递归调用时的ans与上一次调用work时的ans一样
            ans = ans + "+"+'0'+String.valueOf(i);
            ;//选取数字拼接到最后
            work(total, i, left - i, ans);//递归
        }
    }

    public static String removeCharAt(String s, int pos) {
        return s.substring(0, pos) + s.substring(pos + 1);
    }
    public  static void main(String args[])
    {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        work(n, 1, n, "");
    }
}
