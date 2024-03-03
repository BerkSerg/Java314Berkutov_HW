package hw23_lists.livecirclegame;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class LiveCircleGame {
    private static final String WRONG_LETTERS = "ьъё";

    public static void main(String[] args) {
        LinkedList<String> players = new LinkedList<>();
        List<String> saidWords = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // Заполнение списка участников
        System.out.println("Введите имена участников игры, для завершения введите (точку):");
        String name;
        while (!(name = scanner.nextLine()).equalsIgnoreCase(".")) {
            players.add(name);
        }

        if (players.size() < 2) {
            System.out.println("Нужно больше игроков для этой игры!");
            return;
        }

        // Игровой процесс
        System.out.println("Игра начинается!");
        String lastWord = "";

        while (players.size() > 1) {
            boolean isPlayerExpel = false;
            String currentPlayer = players.poll(); // Получаем текущего игрока и убираем его из списка
            String inputWord;

            // Просим текущего игрока назвать слово, начинающееся с последней буквы предыдущего слова
            char lastLetter = ' ';
            if (lastWord.isEmpty()) {
                System.out.println(currentPlayer + ", назовите слово:");
            } else {
                lastLetter = lastWord.charAt(lastWord.length() - 1);
                if (WRONG_LETTERS.contains(String.valueOf(lastLetter))) {
                    lastLetter = lastWord.charAt(lastWord.length() - 2);
                }
                System.out.println(currentPlayer + ", назовите слово, начинающееся с буквы \"" + lastLetter + "\":");
            }

            // Проверяем правильность введенного слова
            int attempt = 3;
            while (true) {
                if (attempt == 0) {
                    isPlayerExpel = true;
                    break;
                }
                inputWord = scanner.nextLine().toLowerCase();
                if (saidWords.contains(inputWord)) {
                    System.out.println("Слово уже называлось");
                    attempt--;
                    continue;
                }
                if (lastWord.isEmpty() || inputWord.charAt(0) == lastLetter) {
                    saidWords.add(inputWord);
                    lastWord = inputWord; // Обновляем последнее слово
                    break;
                } else {
                    System.out.println("Неверное слово!");
                    attempt--;
                    if (attempt > 0) {
                        System.out.println("Попробуйте еще раз:");
                    }
                }
            }

            // Добавляем текущего игрока в конец списка
            if (isPlayerExpel) {
                System.out.println(currentPlayer + " выбывает из игры");
            } else {
                players.addLast(currentPlayer);
            }

        }

        // Победитель
        System.out.println("Поздравляем " + players.poll() + ", " + lastWord + " - это последнее слово в игре!");
        scanner.close();
    }
}

