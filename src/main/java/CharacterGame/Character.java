package CharacterGame;

import java.util.List;

public class Character {

    public String firstName;
    public String lastName;
    public int hp;
    public int maxHp;
    @Deprecated
    /**
     * @depracated - nie używać, zostanie usunięte w wersji 2.15
     */
    private FacebookProvider facebookProvider;
    private Weapon weapon;

    public Character(String firstName, String lastName, int maxHp, FacebookProvider facebookProvider, Weapon weapon) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.facebookProvider = facebookProvider;
        this.weapon = weapon;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public void attack(Character other) throws Exception {
        if (other.isAlive()) {
            if (this.weapon != null) {
                other.hp -= this.weapon.getDamage();
            } else {
                other.hp--;
            }
        } else {
            throw new Exception("Character is dead");
        }
        if (other.hp < 0) {
            other.hp = 0;
        }

    }


    public boolean isAlive() {
        return hp > 0;
    }

    public void heal() {
        this.hp = maxHp;
    }


    @Deprecated
    /**
     * @depracated - nie używać, zostanie usunięte w wersji 2.15
     */
    public void attackFriends() throws Exception {
        facebookProvider.getFriends(getFullName());
        List<Character> friends = facebookProvider.getFriends(getFullName());
        for (Character friend : friends) {
            attack(friend);
            System.out.println("I attacked " + friend.getFullName());
        }
    }




}