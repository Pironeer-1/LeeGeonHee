package game;


import player.*;
import enemy.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private Enemy enemy;
    private List<Player> playerList = new ArrayList<>();

    public void setPlayers() {
        Scanner sc = new Scanner(System.in);
        System.out.println("플레이어 인원을 정하세요: ");
        int playerCount = sc.nextInt();

        for (int i = 0; i < playerCount; i++) {
            Player player = new Player();
            player.setStatus();
            playerList.add(player);
        }
    }

    public void setEnemy() {
        int playerCount = playerList.size();
        enemy = new Enemy(playerCount);
        System.out.println("적의 체력: " + enemy.getHp());
    }

    public boolean turnCheck() {
        playerList.removeIf(player-> player.getHp() <= 0); //체력이 0 이하면 제거
        return !playerList.isEmpty() && enemy.getHp() > 0;
    }

    public Player selectTargetPlayer() {
        Random random = new Random();
        int targetIndex = random.nextInt(playerList.size());
        return playerList.get(targetIndex);
    }

    public void game() {
        setPlayers();
        setEnemy();

        while (turnCheck()) {
            for (int i = 0; i < playerList.size() ; i++) {
                Player player = playerList.get(i);
                System.out.println((i+1) + "번 플레이어의 차례입니다.");

                takePlayerTurn(player, i);
                if (enemy.getHp() == 0) {
                    System.out.println("적을 물리쳤습니다!");
                    break;
                }
            }

            EnemyAction enemyAction = new EnemyAction(enemy);

            if (turnCheck()) {
                Player targetPlayer = selectTargetPlayer();
                int targetIndex = playerList.indexOf(targetPlayer);
                System.out.println("적의 차례입니다.");
                enemyAction.attack(targetPlayer, targetIndex);
            }
        }
        if (enemy.getHp() <= 0) {
            System.out.println("축하합니다! 적을 물리쳤습니다!");
        } else {
            System.out.println("모든 플레이어가 패배했습니다.");
        }
    }
    private void takePlayerTurn(Player player, int playerIndex) {
        Scanner sc = new Scanner(System.in);
        PlayerAction playerAction = new PlayerAction(player);
        System.out.println("행동을 선택하세요. (1: 일반 공격, 2: 마법 공격, 3: 체력 회복, exit: 종료)");

        while (true) {
            String input = sc.next();
            if (input.equals("exit")) {
                System.out.println("게임을 종료합니다.");
                System.exit(0);
            }

            try {
                int action = Integer.parseInt(input);
                switch (action) {
                    case 1:
                        //일반 공격
                        playerAction.basicAttack(enemy);
                        return;
                    case 2:
                        //마법 공격
                        int damage = player.getAp() * 2 - enemy.getApDefence();
                        enemy.decreaseHp(damage);
                        System.out.println("마법 공격으로 적에게 " + damage + "의 데미지를 입혔습니다.");
                        return;
                    case 3:
                        //체력 회복
                        int healAmount = new Random().nextInt(6) + 5;
                        player.setHp(player.getHp() + healAmount);
                        System.out.println("체력을 " + healAmount + "만큼 회복했습니다. 현재 체력: " + player.getHp());
                        return;
                    default:
                        System.out.println("올바른 숫자를 입력하세요.");
                    }
                } catch (NumberFormatException e) {
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.game();
    }
}
