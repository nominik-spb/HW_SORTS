import java.io.*;
import java.util.Arrays;

public class Main {

    public static final int STR_TEAM = 10;

    public static void main(String[] args) throws IOException {
        int[][] teams = {
                {45, 31, 24, 22, 20, 17, 14, 13, 12, 10},
                {31, 18, 15, 12, 10, 8, 6, 4, 2, 1},
                {51, 30, 10, 9, 8, 7, 6, 5, 2, 1}

        };

        int[] nationalTeam = mergeAll(teams);
        System.out.println(Arrays.toString(nationalTeam)); // [51, 45, 31, 31, 30, 24, 22, 20, 18, 17]
    }

    /**
     * Метод для слияния всех команд в одну национальную
     */
    public static int[] mergeAll(int[][] teams) {

        int[] mergeTeam = team(0, teams);
        int i = 1;
        while (i < teams.length) {
            int[] team = team(i, teams);
            mergeTeam = merge(mergeTeam, team);
            i++;
        }
        return mergeTeam;
    }

    /**
     * Метод для слияния двух команд в одну
     */
    public static int[] merge(int[] teamA, int[] teamB) {
        int a = 0;  // счетчик по массиву A
        int b = 0;  // счетчик по массиву B
        int i = 0;  // счетчик по итоговому массиву
        int[] merge = new int[STR_TEAM];
        while (i < merge.length && (a < teamA.length || b < teamB.length)) {
            if (b == teamB.length || (a < teamA.length && teamA[a] >= teamB[b])) {
                merge[i] = teamA[a];
                a++;
            } else {
                merge[i] = teamB[b];
                b++;
            }
            i++;
        }
        return merge;
    }

    // вспомогательный метод извлечение строки массива teams в одномерный массив
    public static int[] team(int numTeam, int[][] teams) {
        int l = teams[numTeam].length;
        int[] team = new int[l];
        int i = 0;
        for (i = 0; i < l; i++) {
            team[i] = teams[numTeam][i];
        }
        return team;
    }
}