package CharacterGame;


import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;


public class CharacterTest {
    @Test
    public void NewCharacterWithMaxHp10_HpIs10AndMaxHpIs10() {
        Character character = new Character("Czesiek", "Kowalski", 10, null, null);
        assertThat(character.hp).isEqualTo(10);
        assertThat(character.maxHp).isEqualTo(10);
    }

    @Disabled("Wyłącza test")
    @Test
    public void NewCharacterFullName() {
        Character character = new Character("Czesiek", "Kowalski", 10, null, null);
        assertThat(character.lastName).isEqualTo("Kowalski");
    }

    @Test
    public void attack_oneCharacterAttacksOther_hpIsDecreasedBy1() throws Exception {
        Character first = new Character("Czesiek", "Kowalski", 10, null, null);
        Character second = new Character("Franek", "Kimono", 10, null, null);
        first.attack(second);
        assertThat(second.hp).isEqualTo(9);
        assertThat(second.maxHp).isEqualTo(10);
    }

    @Test
    public void attack_characterWithHp10IsHit9Times_itIsAlive() throws Exception {
        Character first = new Character("Czesiek", "Kowalski", 10, null, null);
        Character second = new Character("Franek", "Kimono", 10, null, null);
        first.attack(second);
        first.attack(second);
        first.attack(second);
        first.attack(second);
        first.attack(second);
        first.attack(second);
        first.attack(second);
        first.attack(second);
        first.attack(second);
        assertThat(second.isAlive()).isTrue();
    }

    @Test
    public void attack_characterWithHp10IsHit10Times_itIsDead() throws Exception {
        Character first = new Character("Czesiek", "Kowalski", 10, null, null);
        Character second = new Character("Franek", "Kimono", 10, null, null);
        first.attack(second);
        first.attack(second);
        first.attack(second);
        first.attack(second);
        first.attack(second);
        first.attack(second);
        first.attack(second);
        first.attack(second);
        first.attack(second);
        assertThat(second.isAlive()).isFalse();
    }

    @Test
    public void attack_characterAlive_toDeadOne() throws Exception {
        Character first = new Character("Czesiek", "Kowalski", 10, null, null);
        Character second = new Character("Franek", "Kimono", 10, null, null);
        first.attack(second);
        first.attack(second);
        first.attack(second);
        first.attack(second);
        first.attack(second);
        first.attack(second);
        first.attack(second);
        first.attack(second);
        first.attack(second);
        first.attack(second);
        assertThat(second.isAlive()).isFalse();
    }

    @Test
    public void deadCharacterIsAttacked_ExceptionIsThrown() throws Exception {
        Character attacker = new Character("attacker", "attacker", 10, null, null);
        final Character dead = new Character("asd", "asd", 1, null, null);
        dead.hp = 0;
        assertThatThrownBy(() -> {
            attacker.attack(dead);
        }).hasMessageContaining("dead");
    }

//    @Test
//    public void exception() throws Exception {
//        throw new Exception("coś nie tak");
//    }

    static Stream<Arguments> attackParameters() {
        return Stream.of(
                arguments(1, true),
                arguments(2, true),
                arguments(9, true),
                arguments(10, false)
        );
    }

    @ParameterizedTest
    @MethodSource("attackParameters")
    public void assdasd(int hits, boolean expectedIsAlive) throws Exception {
        Character first = new Character("Czesiek", "Kowalski", 10, null, null);
        Character second = new Character("Franek", "Kimono", 10, null, null);
        for (int i = 0; i < hits; ++i) {
            first.attack(second);
        }
        assertThat(second.isAlive()).isEqualTo(expectedIsAlive);
    }

    @Test
    public void attackFriends() throws Exception {
        Character attacker = new Character("Czesiek", "Kowalski", 10,
                new FakeFacebookProvider(), null);
        attacker.attackFriends();
    }

    @Test
    public void attackFriendsWithMock() throws Exception {
        FacebookProvider providerMock = mock(FacebookProvider.class);
        when(providerMock.getFriends(anyString())).thenReturn(Arrays.asList(new Character("znajomy", "królika", 10, null, null),
                new Character("marian", "nieznajomy", 10, null, null)));
        Character attacker = new Character("Czesiek", "Kowalski", 10,
                providerMock, null);
        attacker.attackFriends();
    }

    @Test
    public void twoSameCharactersAreNotEqual() {
        Character character1 = new Character("Czesiek", "Kowalski", 10, null, null);
        Character character2 = new Character("Czesiek", "Kowalski", 10, null, null);
        assertThat(character1).isNotEqualTo(character2);
    }

    @Test
    public void twoSameCharacterAreEqualComparingFieldByField() {
        Character character1 = new Character("Czesiek", "Kowalski", 10, null, null);
        Character character2 = new Character("Czesiek", "Kowalski", 10, null, null);
        assertThat(character1).isEqualToComparingFieldByField(character2);
    }

    @Test
    public void colletion_asserts() {
        Character character1 = new Character("Czesiek1", "Kowalski", 10, null, null);
        Character character2 = new Character("Czesiek2", "Kowalski", 10, null, null);
        Character character3 = new Character("Czesiek3", "Kowalski", 10, null, null);
        List<Character> twoCharacters = Arrays.asList(character1, character2);
        assertThat(twoCharacters).contains(character2);
        assertThat(twoCharacters).doesNotContain(character3);
    }

    @Test
    public void createdCharacterHasCorrectHpAndIsAlive() {
        Character alive = new Character("Czesiek1", "Kowalski", 10, null, null);
        Character dead = new Character("Czesiek1", "Kowalski", 0, null, null);
        CharacterAssert.assertThat(alive).isAlive().hasHp(10);
        CharacterAssert.assertThat(alive).hasHp(10).isAlive();
        // CharacterAssert.assertThat(dead).isAlive(); // should fail
    }

    @Test
    public void executeCombat_isOneNotAlive_isTrue() throws Exception {
        Character first = new Character("Czesiek", "Kowalski", 10, null, new Stick());
        Character second = new Character("Franek", "Kimono", 10, null, new Pan());

        CombatManager manager = new CombatManager(new FakeFacebookProvider());
        manager.executeCombat(first, second);

//    System.out.println(first.hp);
//    System.out.println(second.hp);

        assertThat(first.isAlive()).isFalse();
        assertThat(second.isAlive()).isFalse();
    }

    @Test
    public void healFriends_isEvenOneFriendHealed_oneIsHealed() throws Exception {

    }
}