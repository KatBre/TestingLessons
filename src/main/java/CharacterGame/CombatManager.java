package CharacterGame;

import java.util.List;

public class CombatManager {

    private FacebookProvider facebookProvider;

    public CombatManager(FacebookProvider facebookProvider) {

        this.facebookProvider = facebookProvider;
    }

    public void executeCombat(Character first, Character second) throws Exception {
        while (first.isAlive() && second.isAlive()) {
            if (first.isAlive()) {
                first.attack(second);
            }
            if (second.isAlive()) {
                second.attack(first);
            }
        }
        if (first.isAlive()) {
            first.maxHp += 2;
            healFriends(first.getFullName());
            first.heal();
        } else {
            second.maxHp += 2;
            healFriends(second.getFullName());
            second.heal();
        }
    }

    public void healFriends(String fullName) throws Exception {
        List<Character> friends = facebookProvider.getFriends(fullName);
        for (Character friend : friends) {
            friend.heal();
            System.out.println("I healed " + friend.getFullName());
        }
    }
}
