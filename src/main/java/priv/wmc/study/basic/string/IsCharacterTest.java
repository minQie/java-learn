package priv.wmc.study.basic.string;

import java.util.function.Predicate;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author Wang Mincong
 * @date 2020-09-22 16:49:21
 */
@Slf4j
public class IsCharacterTest {

    @Test
    public void test() {
        String str = "aA,";

        realLogic(str, characterPredicate1());

        realLogic(str, characterPredicate2());

        realLogic(str, characterPredicate3());
    }

    public void realLogic(String str, Predicate<Character> isCharacterPredicate) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char character = str.charAt(i);
            stringBuilder
                .append(isCharacterPredicate.test(character))
                .append(" ");
        }
        log.info(stringBuilder.toString());
    }

    public Predicate<Character> characterPredicate1() {
        return character -> Character.isLowerCase(character) || Character.isUpperCase(character);
    }

    public Predicate<Character> characterPredicate2() {
//        return character -> (character >= 97 && character <= 122) || (character >= 65 && character <= 92);
        return character -> (character >= 'a' && character <= 'z') || (character >= 'A' && character <= 'Z');
    }

    public Predicate<Character> characterPredicate3() {
        return character -> character.toString().matches("^[a-zA-Z]$");
    }

}
