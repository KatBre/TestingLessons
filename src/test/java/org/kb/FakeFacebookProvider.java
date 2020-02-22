package org.kb;

import java.util.Arrays;
import java.util.List;

public class FakeFacebookProvider extends FacebookProvider {
    @Override
    public List<Character> getFriends(String fullName) throws InterruptedException {
        return Arrays.asList(new Character("znajomy", "królika", 10, null),
                             new Character("marian", "nieznajomy", 10, null));
    }
}
