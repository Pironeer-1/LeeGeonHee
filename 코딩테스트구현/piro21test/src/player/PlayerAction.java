package player;

import java.util.Random;
import java.util.Scanner;
import enemy.Enemy;

public class PlayerAction {
    private Player player;
    private Scanner sc;

    public PlayerAction(Player player) {
        this.player = player;
        this.sc = new Scanner(System.in);
    }

    public void checkStatus(Enemy enemy) {
        player.printStatus();
        System.out.println("적: 체력 " + enemy.getHp() + ", 공격력 " + enemy.getAd() + ", 방어력 " + enemy.getAdDefence() + ", 마법방어력 " + enemy.getApDefence() + "\n");

        int damage = player.getAd() - enemy.getAdDefence();
        enemy.decreaseHp(damage);
        System.out.println("일반 공격으로 " + damage + "의 데미지를 주었습니다.\n");
    }

    public void basicAttack(Enemy enemy) {
        Random random = new Random();
        int criticalPoint = random.nextInt(10) + 1;

        int damage = player.getAd() - enemy.getAdDefence();

        if (criticalPoint > 2) {
            enemy.decreaseHp(damage);
            System.out.println("일반 공격으로 " + damage + "의 데미지를 주었습니다.");
        } else {
            damage *= 2;
            enemy.decreaseHp(damage);
            System.out.println("치명타가 적용되어 " + damage + "의 데미지를 주었습니다.");
        }
    }

    public void magicAttack(Enemy enemy) {
        int damage = player.getAp() * 2 - enemy.getApDefence();
        enemy.decreaseHp(damage);
        System.out.println("마법 공격으로 " + damage + "의 데미지를 주었습니다.");
    }

    public void healSelf() {
        Random random = new Random();
        int healPoint = random.nextInt(6) + 5;

        player.setHp(player.getHp() + healPoint);
        System.out.println("체력을 회복합니다. 현재 hp는 " + player.getHp() + "입니다.");
    }

    public void chooseAction(Enemy enemy, int playerIndex) {
        while (true) {
            try {
                System.out.println("------------------------------------------------------------------------------");
                System.out.println((playerIndex + 1) + "번 플레이어의 차례입니다. 행동을 선택하세요. (1: 스테이터스 확인 + 일반 공격, 2: 기본 공격, 3: 마법 공격, 4: 체력 회복, exit: 종료)\n");
                String inputKey = sc.next();

                if (inputKey.equals("exit")) {
                    System.out.println("프로그램을 종료합니다.");
                    System.exit(0);
                }

                int action = Integer.parseInt(inputKey);

                if (action < 1 || action > 4) {
                    System.out.println("1~4 사이의 정수를 입력해주세요.");
                    continue;
                }

                switch (action) {
                    case 1:
                        checkStatus(enemy);
                        break;
                    case 2:
                        basicAttack(enemy);
                        break;
                    case 3:
                        magicAttack(enemy);
                        break;
                    case 4:
                        healSelf();
                        break;
                }
                break;
            } catch (Exception e) {
                System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
                sc.nextLine();
            }
        }
    }
}
