package chapter4;

public class Chapter4_4_3 {

    public static void main(String[] args) {
        int[] marks = {90, 25, 67, 45, 80};
        for (int i = 0; i < marks.length; i++) {
            if (marks[i] < 60) {
                continue;
            }
            System.out.println((i + 1) + "번 학생 축하합니다. 합격입니다.");
        }
        for (int i =2 ; i<10 ; i++) {
            for (int j =1 ; j<10 ; j++) {
                System.out.print(i + " * " + j + " = " +i*j + " ");
            }
            System.out.println("");
        }
    }
}
