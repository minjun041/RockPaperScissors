import java.util.Random;
import java.util.Scanner;

public class Game {
    private Scanner sc = new Scanner(System.in);
    private Random random = new Random();
    private Score score = new Score();

    // 컴퓨터 선택 (0=가위, 1=바위, 2=보)
    private int computerChoice() {
        return random.nextInt(3);
    }

    // 숫자를 한글로 변환
    private String toKorean(int choice) {
        switch (choice) {
            case 0: return "✌ 가위";
            case 1: return "✊ 바위";
            case 2: return "✋ 보";
            default: return "알 수 없음";
        }
    }

    // 승패 판정 (1=승, 0=무, -1=패)
    private int judge(int player, int computer) {
        if (player == computer) return 0;
        if ((player == 0 && computer == 2) ||
            (player == 1 && computer == 0) ||
            (player == 2 && computer == 1)) {
            return 1;
        }
        return -1;
    }

    // 한 판 실행
    public void play() {
        System.out.println("------- 가위바위보 -------");
        System.out.println("1. 가위  2. 바위  3. 보");
        System.out.print("선택: ");

        int player;
        try {
            player = Integer.parseInt(sc.nextLine()) - 1;
        } catch (NumberFormatException e) {
            System.out.println("⚠️ 1, 2, 3 중에서 입력하세요.\n");
            return;
        }

        if (player < 0 || player > 2) {
            System.out.println("⚠️ 1, 2, 3 중에서 입력하세요.\n");
            return;
        }

        int computer = computerChoice();

        System.out.println();
        System.out.println("나       : " + toKorean(player));
        System.out.println("컴퓨터   : " + toKorean(computer));
        System.out.println();

        int result = judge(player, computer);
        if (result == 1) {
            System.out.println("🎉 이겼습니다!");
            score.addWin();
            if (score.getStreak() >= 3) {
                System.out.println("🔥 " + score.getStreak() + "연승 중!");
            }
        } else if (result == -1) {
            System.out.println("😢 졌습니다...");
            score.addLose();
        } else {
            System.out.println("🤝 비겼습니다!");
            score.addDraw();
        }
        System.out.println();
    }

    // 전적 출력
    public void printScore() {
        score.printScore();
    }

    // 전적 초기화
    public void resetScore() {
        score = new Score();
        System.out.println("✅ 전적이 초기화되었습니다.\n");
    }
}