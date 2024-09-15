package enemy;

import player.Player;

import java.util.Random;

public class Enemy {
    private int hp;
    private int maxHp;
    private int ad;
    private int adDefence;
    private int apDefence;

    public Enemy(int playerCount) {
        maxHp = 100 * playerCount;
        hp = 100 * playerCount;
        ad = 25;
        adDefence = 7;
        apDefence = 7;
    }
    //적의 체력 감소 메서드
    public void decreaseHp(int damage) {
        this.hp = Math.max(this.hp - damage, 0);
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getHp() {
        return hp;
    }

    public int getAd() {
        return ad;
    }

    public int getAdDefence() {
        return adDefence;
    }

    public int getApDefence() {
        return apDefence;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}
