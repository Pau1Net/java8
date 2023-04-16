import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PortHelper {

    // Тут мы парсим индексы в массивчик последовательностей чисел
    public static List<List<Integer>> parseIndexes(String[] indexes) {
        return Arrays.stream(indexes)
                .map(PortHelper::parseIndex)
                .collect(Collectors.toList());
    }

    // Тут мы вытаскиваем все возможные комбинашки чисел
    public static List<List<Integer>> getAllPossibleCombinations(List<List<Integer>> sequences) {
        List<List<Integer>> result = new ArrayList<>();
        getAllCombinationsRecursive(sequences, 0, new ArrayList<>(), result);
        return result;
    }

    // Здесь мы парсим одну строчку индексов в список чисел
    private static List<Integer> parseIndex(String index) {
        Set<Integer> resultSet = new HashSet<>();
        String[] parts = index.split(",");

        for (String part : parts) {
            if (part.contains("-")) {
                String[] range = part.split("-");
                int start = Integer.parseInt(range[0]);
                int end = Integer.parseInt(range[1]);

                // Тут мы пройдемся по всем числам в диапазоне и забацаем их в сет
                for (int i = start; i <= end; i++) {
                    resultSet.add(i);
                }
            } else {
                resultSet.add(Integer.parseInt(part));
            }
        }

        return new ArrayList<>(resultSet);
    }

    // Здесь мы рекурсивно строим уникальные упорядоченные комбинации
    private static void getAllCombinationsRecursive(List<List<Integer>> sequences, int depth, List<Integer> current, List<List<Integer>> result) {
        if (depth == sequences.size()) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Пробег по числам в массиве
        for (Integer num : sequences.get(depth)) {
            current.add(num);
            getAllCombinationsRecursive(sequences, depth + 1, current, result);
            current.remove(current.size() - 1);
        }
    }
}
