package BackTracking;

public class Problem001 {
    public static void main(String[] args) {
        Random rand = new Random();
        int number = rand.nextInt(100)+1;
        Scanner sc = new Scanner(System.in);
//        int number =35;

        while(true){
            System.out.println("Please enter a number between 1 and 100");
            int guess=sc.nextInt();
//            int guess=56;
            if(guess==number){
                System.out.println("Congratulations! You win!");
                break;
            }else if(guess<number){
                System.out.println("Sorry, your guess is too low!");
            }else {
                System.out.println("Sorry, your guess is too high!");
            }
        }

    }
}
