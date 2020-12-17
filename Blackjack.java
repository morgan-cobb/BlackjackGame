import java.util.Random;
import java.util.Scanner;
public class Blackjack
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        P1Random rnd = new P1Random();

        //Variables
        //I declared all of my variables here to try and make the code somewhat clearer
        int playerScore;
        int dealerScore;
        boolean play = true;
        int x=0;
        int dWins =0; //dWins stands for Dealer wins
        int pWins =0; //pWins stands for Player wins
        int tie =0;
        int gamesPlayed = 1;
        float percentage;
        String card;

        while (play)
        {
            //implemented this loop so it would start a new game and count the number of games played
            gamesPlayed = dWins+ pWins + tie + 1;
            System.out.println("\nSTART GAME #" + gamesPlayed);
            //deal the first card
            x = rnd.nextInt(13)+1;

            //This part is a bit tedious but I needed to figure out how to print the card rank while still being able to add the values together
            //at first I had them all as ints but I needed them to be strings to print the rank
            if(x==1)
            {
                card = "ACE";
            }
            else if(x==11)
            {
                card = "JACK";
                x = 10;
            }
            else if(x==12)
            {
                card = "QUEEN";
                x = 10;
            }
            else if(x==13)
            {
                card = "KING";
                x = 10;
            } //I didnt have to change the vales of x after this because they are already the value that they need to be
            else if(x==2)
            {
                card ="2";
            }
            else if(x==3)
            {
                card ="3";
            }
            else if(x==4)
            {
                card ="4";
            }
            else if(x==5)
            {
                card = "5";
            }
            else if(x==6)
            {
                card ="6";
            }
            //again this was a bit tedious but necessary
            else if(x==7)
            {
                card = "7";
            }
            else if(x==8)
            {
                card = "8";
            }
            else if(x==9)
            {
                card ="9";
            }
            else
            {
                card="10";
            }

            //Now I can print the name of the card as a string rather than an int
            System.out.println("\nYour card is a " + card + "!");
            playerScore = x;
            System.out.println("Your hand is:" + playerScore);
            boolean gameGoing = true;
            //this while loop helps keep track of the end of each game
            while(gameGoing)
            {
                //Print Menu
                System.out.println("\n 1.Get another card \r\n 2.Hold hand \r\n 3.Print statistics \r\n 4.Exit");
                System.out.println("Choose an option: ");
                //the switch implements the menu option the user chose
                int menu = scan.nextInt();
                switch (menu)
                {
                    case 1://Get Another card
                        x = rnd.nextInt(13) + 1;
                        if(x==1)
                        {
                            card = "ACE";
                        }
                        else if(x==11)
                        {
                            card = "JACK";
                            x = 10;
                        }
                        else if(x==12)
                        {
                            card = "QUEEN";
                            x = 10;
                        }
                        else if(x==13)
                        {
                            card = "KING";
                            x = 10;
                        }
                        else if(x==2)
                        {
                            card ="2";
                        }
                        else if(x==3)
                        {
                            card ="3";
                        }
                        //im sure that there is an easier way to print the card number without having to initialize them all
                        //but I couldn't necessarily figure out the shortcut so I just did it all
                        else if(x==4)
                        {
                            card ="4";
                        }
                        else if(x==5)
                        {
                            card = "5";
                        }
                        else if(x==6)
                        {
                            card ="6";
                        }
                        else if(x==7)
                        {
                            card = "7";
                        }
                        else if(x==8)
                        {
                            card = "8";
                        }
                        else if(x==9)
                        {
                            card ="9";
                        }
                        //I used an else her because there wer no other card values left to initialize
                        else
                        {
                            card="10";
                        }
                        System.out.println("Your card is a " + card + "!");
                        playerScore += x;
                        System.out.println("Your hand is:" + playerScore);
                        if (playerScore > 21) {
                            //if the player's score is greater than 21
                            System.out.println("You exceeded 21! You lose.");
                            dWins++;
                            gameGoing=false;
                            break;
                        } else if (playerScore == 21) {
                            //if the players score is equal to 21
                            System.out.println("BLACKJACK! You win!");
                            pWins++;
                            gameGoing=false;
                            break;
                        } else
                            //if the player wins or loses the current game is terminated and a new one starts
                            //but if no one wins, the menu is printed out again and the user continues
                            break;
                    case 2: //Hold Hand
                        dealerScore = rnd.nextInt(11) + 16;
                        System.out.println("Dealer's hand:" + dealerScore + "\nYour hand is:" + playerScore);
                        if ((dealerScore > playerScore) && (dealerScore <= 21)) {
                            //if the dealer's score is greater than the player's score and still less than 21
                            System.out.println("Dealer wins!");
                            dWins++;
                            gameGoing=false;
                        } else if (dealerScore > 21) { //if he dealers score is greater than 21
                            System.out.println("You win!");
                            pWins++;
                            gameGoing=false;
                        } else if (dealerScore == playerScore) { //this prints out a tie
                            System.out.println("It's a tie! No one wins!");
                            tie++;
                            gameGoing=false;
                        } else {
                            System.out.println("You win!");
                            pWins++;
                            gameGoing=false;
                        }
                        break;
                    case 3: //Print Statistics
                        gamesPlayed = dWins + pWins + tie;
                        System.out.println("Number of Player wins:" + pWins + "\nNumber of Dealer wins:" + dWins + "\nNumber of tie games:" + tie);
                        System.out.println("Total # of games played is:" + gamesPlayed);
                        percentage = ((pWins*100.0f)/gamesPlayed);
                        System.out.println("Percentage of Player wins:"+ percentage + "%");
                        break;
                    case 4: //exit
                        play = false;
                        return;
                    default: //error
                        //If the user does not choose the correct menu option
                        System.out.println("Invalid input! \n Please enter an integer value between 1 and 4.");
                        break;
                 }
            }
        }
    }
}
  


