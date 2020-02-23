package org.kb;


import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


import java.util.Arrays;
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
        for (int i = 0; i < hits; ++i){
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
    public void attackFriends_facebookProviderIsCalledForCharactersFullName() throws Exception {
        FacebookProvider providerMock = mock(FacebookProvider.class);
        Character attacker = new Character("Czesiek", "Kowalski", 10,
                providerMock, null);
        attacker.attackFriends();
        verify(providerMock, times(1)).getFriends("Czesiek Kowalski");
        verifyNoMoreInteractions(providerMock);
    }
}