package chapter4;

public class Chapter4_1_1 {

    public static void main(String[] args) {
        int money = 2000;
        boolean hasCard = true;
        if (money >= 3000 || hasCard) {
            System.out.println("택시를 타고 가라");
        } else {
            System.out.println("걸어가라");
        }
        // contains 메서드 -> 리스트에 해당 아이템이 있는지 조사하는거
    }
}
