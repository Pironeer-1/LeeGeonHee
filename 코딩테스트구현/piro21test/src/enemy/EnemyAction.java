package enemy;

import player.Player;

import java.util.Random;

public class EnemyAction {
    private Enemy enemy;

    public EnemyAction(Enemy enemy) {
        this.enemy = enemy;
    }

    public void healSelf() {
        int healingAmount = 7;
        if (enemy.getHp() + healingAmount > enemy.getMaxHp()) {
            enemy.setHp(enemy.getHp());
            System.out.println("적이 회복했지만 이미 최대 체력입니다.\n");
        } else {
            enemy.setHp(enemy.getHp()+ healingAmount);
            System.out.println("적이 " + healingAmount + "만큼 체력을 회복했습니다. 현재 체력: " + enemy.getHp() + "\n");
        }
    }

    public void basicAttack(Player player, int playerIndex) {
        player.decreaseHp(enemy.getAd());
        System.out.println((playerIndex + 1) + "번 유저에게 " + enemy.getAd() + "의 데미지를 입혔습니다. 남은 체력: " + player.getHp());
    }

    public void attack(Player player, int playerIndex) {
        Random random = new Random();
        int action = random.nextInt(10) + 1;

        if (action == 1) {
            System.out.println("적은 움직이지 않고 있습니다.\n");
        } else if (action >= 2 && action <= 8 ) {
            basicAttack(player, playerIndex);
        } else {
            healSelf();
        }
    }
}
