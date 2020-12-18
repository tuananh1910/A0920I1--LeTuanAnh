package _10_Danh_Sach.Bai_Tap.ArrrayList;

public class main {
    public static void main(String[] args) {
        MyList<Integer> list = new MyList<Integer>();
        list.add(0,4);
        list.add(1,5);
        list.add(2,6);
        list.add(3,7);
        System.out.println(list.get(2));
        System.out.println("size = " + list.size());
        System.out.println(list.get(1));
        list.remove(1);

        System.out.println("size ="+list.size());
        System.out.println(list.contains(6));
        System.out.println(list.contains(5));
        System.out.println(list.contains(7));
        System.out.println(list.get(1));
        System.out.println(list.get(0));
        System.out.println(list.indexOf(7));
        list.clear();
    }
}
