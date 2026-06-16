import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        Scanner sc = new Scanner(System.in);

        System.out.println("=====================================");
        System.out.println("       ✌ 가위바위보 게임 ✊✋");
        System.out.println("=====================================\n");

        while (true) {
            System.out.println("------- 메뉴 -------");
            System.out.println("1. 게임 시작");
            System.out.println("2. 전적 보기");
            System.out.println("3. 전적 초기화");
            System.out.println("0. 종료");
            System.out.print("선택: ");

            String input = sc.nextLine();
            System.out.println();

            switch (input) {
                case "1": game.play(); break;
                case "2": game.printScore(); break;
                case "3": game.resetScore(); break;
                case "0":
                    System.out.println("게임을 종료합니다. 👋");
                    return;
                default:
                    System.out.println("⚠️ 잘못된 선택입니다.\n");
            }
        }
    }
}