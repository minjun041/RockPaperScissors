public class Score {
    private int win;
    private int lose;
    private int draw;
    private int streak;      // 현재 연승
    private int bestStreak;  // 최고 연승

    public void addWin() {
        win++;
        streak++;
        if (streak > bestStreak) bestStreak = streak;
    }

    public void addLose() {
        lose++;
        streak = 0;
    }

    public void addDraw() {
        draw++;
        streak = 0;
    }

    public int getWin() { return win; }
    public int getLose() { return lose; }
    public int getDraw() { return draw; }
    public int getStreak() { return streak; }
    public int getTotal() { return win + lose + draw; }

    public void printScore() {
        System.out.println("===== 현재 전적 =====");
        System.out.println("총 게임 수 : " + getTotal() + "판");
        System.out.printf("승: %d  패: %d  무: %d%n", win, lose, draw);
        if (getTotal() > 0) {
            System.out.printf("승률: %.1f%%%n", (win * 100.0) / getTotal());
        }
        System.out.println("현재 연승: " + streak + "연승");
        System.out.println("최고 연승: " + bestStreak + "연승");
        System.out.println();
    }
}