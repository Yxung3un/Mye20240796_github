package 과제;

import java.util.Random; 
import java.util.Scanner; 

public class Mye20240796_mid2 { 

   
    static String[] moves = {"가위", "바위", "보"}; 
    static String[] mjpMoves = {"묵", "찌", "빠"};

    public static void main(String[] args) { 
    	
        Scanner scanner = new Scanner(System.in); 
        Random random = new Random(); 

        System.out.println("🤖 안녕! 나랑 초간단 묵찌빠 대결할 준비 됐니?");
        System.out.println("✊✋✌️ 가위, 바위, 보로 먼저 공격권을 정하자!");
        System.out.println("게임을 그만하고 싶으면 언제든 '끝'이라고 입력해줘.");

        int computerScore = 0; 
        int playerScore = 0;
        int targetScore = 3; 

       
        Boolean isComputerAttacker = null;

        
        while (playerScore < targetScore && computerScore < targetScore) {

            
            while (isComputerAttacker == null) {
                System.out.println("\n--- 공격권 쟁탈! 가위, 바위, 보! ---");
                System.out.println("✨ 현재 점수 | 너: " + playerScore + "점, 🤖 나: " + computerScore + "점 ✨");



                int userRpsMoveIndex = getUserMoveIndex(scanner, moves, "가위/바위/보/끝: ");

                
                if (userRpsMoveIndex == -1) { 
                    System.out.println("\n👋 아쉽다! 다음에 또 놀자! 안녕!");
                    scanner.close();
                    return; 
                }

                
                int computerRpsMoveIndex = random.nextInt(3);
                System.out.println("👉 너: " + moves[userRpsMoveIndex] + ", 🤖 나: " + moves[computerRpsMoveIndex]);

                
                int rpsResult = (userRpsMoveIndex - computerRpsMoveIndex + 3) % 3; 
                
                switch (rpsResult) {
                    case 0: 
                        System.out.println("🤝 비겼네! 공격권 다시 가위바위보!");
                        
                        break;
                    case 1: 
                        System.out.println("🎉 네가 가위바위보 이겼어! 이제 네가 공격, 내가 수비!");
                        isComputerAttacker = false;
                        break; 
                    case 2:
                        System.out.println("😭 내가 가위바위보 이겼다! 이제 내가 공격, 네가 수비!");
                        isComputerAttacker = true; 
                        break;
                }
                 
            }

           
            System.out.println("\n=== 묵찌빠 대결! ===");
            System.out.println("✨ 현재 공격: " + (isComputerAttacker ? "🤖 컴퓨터" : "👉 너"));
            System.out.println("(공격자는 '콜'을 외치고 손을 내고, 수비자는 그에 맞춰 손을 내!)");


            
            int userMjpMoveIndex = getUserMoveIndex(scanner, mjpMoves, "묵/찌/빠/끝: "); 

           
             if (userMjpMoveIndex == -1) { 
                System.out.println("👋 안녕!");
                scanner.close();
                return; 
            }


            
            int computerMjpMoveIndex = random.nextInt(3);

            
            int attackerMoveIndex; 
            int defenderMoveIndex; 
            String attackerCall; 

            if (isComputerAttacker) { 
                attackerMoveIndex = computerMjpMoveIndex;
                defenderMoveIndex = userMjpMoveIndex;    
                attackerCall = mjpMoves[attackerMoveIndex];
                System.out.println("🤖 " + attackerCall + "!");

            } else { 
                attackerMoveIndex = userMjpMoveIndex;    
                defenderMoveIndex = computerMjpMoveIndex; 
                attackerCall = mjpMoves[attackerMoveIndex];
                System.out.println("👉 " + attackerCall + "!");
            }


           
            System.out.println("👉 너: " + mjpMoves[userMjpMoveIndex] + ", 🤖 나: " + mjpMoves[computerMjpMoveIndex]);
            


            
            System.out.print("⭐ 결과: ");
            if (attackerMoveIndex == defenderMoveIndex) {
               
                System.out.println((isComputerAttacker ? "🤖 컴퓨터" : "👉 너") + " 승리!");
                if (isComputerAttacker) {
                    computerScore++; 
                } else {
                    playerScore++; 
                }
                
                isComputerAttacker = null; 
            } else {
               
                 System.out.println("➡️ 공수 교대!");
                isComputerAttacker = !isComputerAttacker; 
            }

             

        } 

        
        System.out.println("\n=== 최종 게임 결과! ===");
        System.out.println("✨ 최종 점수 | 너: " + playerScore + "점, 🤖 나: " + computerScore + "점 ✨");

        if (playerScore >= targetScore) {
            System.out.println("🏆 와! 네가 목표 점수 " + targetScore + "점을 먼저 달성했어! 네 승리야! 대단해!");
        } else { 
            System.out.println("😂 헤헤, 이번엔 내가 목표 점수 " + targetScore + "점을 먼저 달성했군! 내 승리다!");
        }

        scanner.close();
    } 


    
    public static int getUserMoveIndex(Scanner scanner, String[] validMoves, String promptMessage) {
        while (true) { 
            System.out.print(promptMessage); 
            String userInput = scanner.nextLine().trim();

            
            if (userInput.equals("끝")) {
                return -1;
            }

           
            for (int i = 0; i < validMoves.length; i++) {
                if (validMoves[i].equals(userInput)) { 
                    return i; 
                }
            }

            
            System.out.println("앗, 잘못 입력했어! 다시 입력해 줘. ('끝'으로 종료 가능)");
        }
    } 
} 