package player;

import java.util.Scanner;

public class Player {
    private int hp = 50;
    private int ad = 10;
    private int ap = 5;

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAd() {
        return ad;
    }

    public void setAd(int ad) {
        this.ad = ad;
    }

    public int getAp() {
        return ap;
    }

    public void setAp(int ap) {
        this.ap = ap;
    }

    public void printStatus() {
        System.out.println("체력: " + this.hp + ", 공격력: " + this.ad + ", 마법력: " + this.ap);
    }

    public void setStatus() {
        int point = 13;
        Scanner sc = new Scanner(System.in);

        System.out.println("------------------------------------------------------------------------------");
        System.out.println(point + "만큼의 스테이터스를 추가합니다. 체력, 공격력, 마법력 순으로 입력하세요\n" +
                "(1 포인트 당 체력 = 3, 공격력 = 1, 마법력 = 1 증가)\n");
        System.out.println("플레이어의 기본 스탯은 체력: 50, 공격력: 10, 마법력: 5입니다.\n");

        while (true) {
            try{
                System.out.println("체력, 공격력, 마법력을 입력하세요 (공백으로 구분): ");
                int hpPoints = sc.nextInt();
                int adPoints = sc.nextInt();
                int apPoints = sc.nextInt();

                if((hpPoints + adPoints + apPoints) == point) {
                    this.hp += hpPoints * 3;
                    this.ad += adPoints;
                    this.ap += apPoints;
                    System.out.println("체력: " + hp + ", 공격력: " + ad + ", 마법력: " + ap);
                    break;
                } else {
                    System.out.println("입력한 능력치의 총합이 " + point + "와 같아야 합니다. 다시 입력해주세요.");
                }
            } catch (Exception e) {
                System.out.println("hp, ad, ap는 정수로 입력해야 합니다. 다시 입력해주세요.");
                sc.nextLine();
            }
        }
    }
    public void decreaseHp(int damage) {
        this.hp = Math.max(this.hp - damage, 0);
    }

}
