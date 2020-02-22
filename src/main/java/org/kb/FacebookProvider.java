package org.kb;

import java.util.Arrays;
import java.util.List;

public class FacebookProvider {
    public List<Character> getFriends(String fullName) throws InterruptedException {
        Thread.sleep(5000);
        return Arrays.asList(new Character("znajomy", "królika", 10, null));
    }
}
