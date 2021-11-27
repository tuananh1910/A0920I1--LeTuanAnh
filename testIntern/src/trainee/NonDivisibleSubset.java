package trainee;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class NonDivisibleSubset {
    public static int nonDivisibleSubset(int k, List<Integer> s) {
        int[]c = new int[k];

        for(int i=0;i<s.size();i++){
            s.set(i,s.get(i)%k);
            c[s.get(i)]++;
        }

        int ans=0;
        ans+=(c[0]>0)?1:0;
        System.out.println(ans);
        for(int i=1;i<=k-i;i++){
            if(i<k-i) {
                ans+=Math.max(c[i],c[k-i]);
                System.out.println(ans);
            } else {
                ans+=(c[i]>0)?1:0;
                System.out.println(c[i]);
                System.out.println(ans);
            }
        }

        return ans;

    }

    public static void main(String[] args) {
        List<Integer> s = new ArrayList<>();
//        s.add(278);
//        s.add(576);
//        s.add(496);
//        s.add(727);
//        s.add(410);
//        s.add(124);
//        s.add(338);
//        s.add(149);
//        s.add(209);
//        s.add(702);
//        s.add(282);
//        s.add(718);
//        s.add(771);
//        s.add(575);
//        s.add(436);

        s.add(1);
        s.add(7);
        s.add(2);
        s.add(4);
        int size = nonDivisibleSubset(3, s);
        System.out.println("size:"+size);
    }
}
