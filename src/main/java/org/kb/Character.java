package org.kb;

import java.util.List;

public class Character {

    public String firstName;
    public String lastName;
    public int hp;
    public int maxHp;
    private FacebookProvider facebookProvider;

    public Character(String firstName, String lastName, int maxHp, FacebookProvider facebookProvider){
        this.firstName = firstName;
        this.lastName = lastName;
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.facebookProvider = facebookProvider;
    }
    public String getFullName(){
        return firstName + " " + lastName;
    }

    public void attack(Character other) throws Exception {
        if(!other.isAlive()){
            throw new Exception("Character is dead");
        }
        other.hp--;
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