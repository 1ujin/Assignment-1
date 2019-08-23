package pacman.score;

import java.util.*;

public class ScoreBoard {
    private int currentScore;
    private Map<String, Integer> scores;

    public ScoreBoard() {
        this.currentScore = 0;
        this.scores = new TreeMap<>();
    }

    public static void main(String[] args) {
        ScoreBoard board = new ScoreBoard();
        board.setScore("Fred", 100);
        board.setScore("fred", 20);
        board.setScore("Fred", 24);
        List<String> scores = board.getEntriesByName();
        System.out.println(scores);

        board = new ScoreBoard();
        board.setScore("Alfie", 100);
        board.setScore("richard", 20);
        board.setScore("Alfie", 24);
        board.setScore("ben", 20);
        scores = board.getEntriesByScore();
        System.out.println(scores);
    }

    public List<String> getEntriesByName() {
        if (!this.scores.isEmpty()) {
            List<Map.Entry<String, Integer>> entriesList = new ArrayList<>(this.scores.entrySet());

            List<String> stringList = new ArrayList<>();
            for (Map.Entry<String, Integer> entry : entriesList) {
                stringList.add(String.format("%s : %d", entry.getKey(), entry.getValue()));
            }
            return stringList;
        }
        return null;
    }

    public List<String> getEntriesByScore() {
        if (!this.scores.isEmpty()) {
            List<Map.Entry<String, Integer>> entriesList = new ArrayList<>(this.scores.entrySet());
            Collections.sort(entriesList, new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    if (o1.getValue() > o2.getValue()) {
                        return -1;
                    // Throw java.lang.NumberFormatException
                    // } else if (o1.getValue() == o2.getValue() && Long.valueOf(o1.getKey()) > Long.valueOf(o2.getKey())) {
                    //     return -1;
                    }
                    return 1;
                }
            });

            List<String> stringList = new ArrayList<>();
            for (Map.Entry<String, Integer> entry : entriesList) {
                stringList.add(String.format("%s : %d", entry.getKey(), entry.getValue()));
            }
            return stringList;
        }
        return null;
    }

    public void setScore(String name, int score) {
        if (name != null && name.matches("^[a-zA-Z]*") && score >= 0) {
            this.scores.put(name, score);
        }
    }

    public void setScores(Map<String, Integer> scores) {
        if (!scores.isEmpty()) {
            // Iterate the scores
            Iterator<Map.Entry<String, Integer>> iterator = scores.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, Integer> score = iterator.next();
                if (score.getValue() >= 0 && score.getKey() != null && score.getKey().matches("^[a-zA-Z]*")) {
                    this.scores.put(score.getKey(), score.getValue());
                }
            }
        }
    }

    public void increaseScore(int additional) {
        if (additional > 0) {
            this.currentScore += additional;
        }
    }

    public int getScore() {
        return currentScore;
    }

    public void reset() {
        this.currentScore = 0;
    }
}
