package org.kb;

import java.util.List;

public class Character {

    public String firstName;
    public String lastName;
    public int hp;
    public int maxHp;
    private FacebookProvider facebookProvider;
    private Weapon weapon;

    public Character(String firstName, String lastName, int maxHp, FacebookProvider facebookProvider, Weapon weapon){
        this.firstName = firstName;
        this.lastName = lastName;
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.facebookProvider = facebookProvider;
        this.weapon = weapon;
    }
    public String getFullName(){
        return firstName + " " + lastName;
    }

    public void attack(Character other) throws Exception {
        if(!other.isAlive()){
            if (this.weapon == null){
                  other.hp--;
            } else {
                other.hp -= this.weapon.getDamage();
            }
            throw new Exception("Character is dead");
        }


    }

    public boolean isAlive() {
        return hp > 0;
    }
    public void attackFriends() throws Exception {
        facebookProvider.getFriends(getFullName());
        List<Character> friends = facebookProvider.getFriends(getFullName());
        for (Character friend:friends){
            attack(friend);
            System.out.println("I attacked " + friend.getFullName());
        }
    }


}