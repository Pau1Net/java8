import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PortHelperTest {

    @Test
    public void testParseIndexes() {
        String[] indexes = {"1,3-5", "2", "3-4"};
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(1, 3, 4, 5),
                Arrays.asList(2),
                Arrays.asList(3, 4)
        );
        // Здесь мы тестируем, правильно ли парсятся индексы в массивчик
        assertEquals(expected, PortHelper.parseIndexes(indexes));
    }

    @Test
    public void testGetAllPossibleCombinations() {
        List<List<Integer>> sequences = Arrays.asList(
                Arrays.asList(1, 3, 4, 5),
                Arrays.asList(2),
                Arrays.asList(3, 4)
        );

        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(1, 2, 4),
                Arrays.asList(3, 2, 3),
                Arrays.asList(3, 2, 4),
                Arrays.asList(4, 2, 3),
                Arrays.asList(4, 2, 4),
                Arrays.asList(5, 2, 3),
                Arrays.asList(5, 2, 4)
        );

        // Тут мы проверяем наш генератор уникальных комбинашек
        assertEquals(expected, PortHelper.getAllPossibleCombinations(sequences));
    }
}
