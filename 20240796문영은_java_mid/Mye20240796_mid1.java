package 과제;

import java.util.Random;
import java.util.Scanner;

public class Mye20240796_mid1  { 
   

    public static void main(String[] args) { 

        Scanner scanner = new Scanner(System.in); 
        Random random = new Random(); 

        System.out.println("가위바위보 하자!");
        System.out.println("가위, 바위, 보 중에 하나를 내줘!");
        System.out.println("게임을 그만하고 싶으면 '끝'을 입력해줘.");

        
        String[] moves = {"가위", "바위", "보"};
      

   
        int playerLastMoveIndex = -1;
        int roundNum = 0; 

      
        while (true) {
            roundNum++; 
            System.out.println("\n---  " + roundNum + " 번째 판! ---");

         
            String userMoveString = null; 
            int userMoveIndex = -1; 
            boolean isValidInput = false;
          
            while (!isValidInput) {
                System.out.print("무엇을 낼까? (가위/바위/보/끝): ");
                userMoveString = scanner.nextLine().trim(); 

               
                if (userMoveString.equals("끝")) { 
                }

               
                for (int i = 0; i < moves.length; i++) {
                    if (moves[i].equals(userMoveString)) {
                        userMoveIndex = i; 
                        isValidInput = true;
                        break; 
                    }
                }

            
                if (!isValidInput) {
                    System.out.println("가위 바위 보 끝이 아닌 다른말을 입력한거같아 ㅜㅜ");
                }
            }

            
            if (userMoveString.equals("끝")) {
                System.out.println("다음에도 같이 놀자!");
                break; 
            }

           
            int computerMoveIndex;

           
            if (playerLastMoveIndex == -1) {
                System.out.println("첫 판이 제일 중요하지!");
                computerMoveIndex = random.nextInt(3); 
            } else { 
                System.out.println("너 전에 '" + moves[playerLastMoveIndex] + "'냈지?");

               
                int counterMoveIndex = (playerLastMoveIndex + 1) % 3;

               
                if (random.nextDouble() < 0.7) { 
                    System.out.println(" 흠... 이걸로 널 이겨주마! ");
                    computerMoveIndex = counterMoveIndex; 
                } else { 
                    System.out.println("이건 몰랐지?");
                    computerMoveIndex = random.nextInt(3); 
                }
            }

            String computerMoveString = moves[computerMoveIndex]; 
            String userMoveStringResult = moves[userMoveIndex];

            System.out.println(" 너: " + userMoveStringResult + ",  나: " + computerMoveString);

            
            int gameResult = (userMoveIndex - computerMoveIndex + 3) % 3;

            
            switch (gameResult) {
                case 0: 
                    System.out.println("통했다!");
                    break; 
                case 1: 
                    System.out.println("졌다! ㅜㅜ");
                    break; 
                case 2: 
                    System.out.println("이겼다!");
                    break; 
              
                default:
                    System.out.println("뭔가 잘못된 결과가 나왔는데?");
                    break;
            }

           
            playerLastMoveIndex = userMoveIndex;

        } 

        scanner.close();
    } 
} 