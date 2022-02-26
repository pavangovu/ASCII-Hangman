import java.util.Scanner;
import static java.lang.System.*;
import java.io.IOException;
import java.io.File;

public class Hangman
{
   public String guess="",letterUsed="";
   public String[] output;
   public int count=0,lives=6,stage=0,level=0,round=0,note=0,grow=0,noChange=0,winner=0,step=0;
   public char difficulty=' ';
   
   public Hangman()
   {
   }
   
   public void Introduction()
   {
      Scanner keyboard=new Scanner(System.in);
      System.out.println("__________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________");
      System.out.println("\nWelcome to Pavan's HANGMAN GAME.");
      System.out.print("\nStrike the return key to continue.");
      keyboard.nextLine();
      System.out.println("__________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________");
      System.out.println("\nBefore proceeding, make your output window as tall and wide as possible.");
      System.out.print("\nStrike the return key to continue.");
      keyboard.nextLine();
   }
    
   public void Difficulty()
   {
      Scanner keyboard=new Scanner(System.in);
      System.out.println("__________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________");
      System.out.print("\n(a)Beginner\n(b)Advanced");
      System.out.print("\n\nChoose your level from above by typing the corresponding letter: ");
      difficulty=keyboard.next().charAt(0);
   }
	
   public void Instructions()
   {
      Scanner keyboard=new Scanner(System.in);
      System.out.println("__________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________");
      System.out.println("\nUse your keyboard to guess the letters of the word that is given.");
      System.out.println("Filling in all blanks before the entire guy is hung counts as a win.");
      System.out.println("If the guy is hung before the whole word is guessed, you lose.");
   }
   
   public void Continue()
   {
      Scanner keyboard=new Scanner(System.in);
      System.out.print("\nStrike the return key to continue.");
      keyboard.nextLine();
   }
   
   public String randomWord()throws IOException
   {
      Scanner file = new Scanner(new File("words.dat"));
      String word="";
      if(difficulty=='a')
      {
         level=846;
         stage=0;
      }
      if(difficulty=='b')
      {
         level=1846;
         stage=847;
      }
      for(int scroll=0;scroll<=Math.random( )*level+stage;scroll++)
      {
         word=file.nextLine();
      }
      return word;
   }
   
   public void printBlanks()throws IOException
   {
      guess=randomWord();
      String[] display=new String[guess.length()];
      drawNoose();
      for(int item=0; item<(guess.length());item++)
      {
         display[item]="__ ";
      }
      System.out.print("\n");
      for(int item=0; item<(guess.length());item++)
      {
         System.out.print(display[item]);
      }
      System.out.println("");
      output=display;
      //System.out.print("\n\nFor developer only: "+guess);
   }
   
   public void drawSomething()
   {
      switch(lives)
      {
         case 6:drawNoose();
            break;
         case 5:drawHead();
            break;
         case 4:drawBody();
            break;
         case 3:drawLeftArm();
            break;
         case 2:drawRightArm();
            break;
         case 1:drawLeftFoot();
            break;
         case 0:drawRightFoot();
            break;
      }
   }
   
   public String writeMessage()
   {
      String message="";
      switch(note)
      {
         case 1:
            message= "Great guess!";noChange=1;
            break;
         case 2:
            message= "Sorry, that is incorrect.";grow+=1;
            break;
         case 3:
            message= "That letter was already used.";noChange=1;
            break;
         case 4:
            message= "Game over.";
            break;
         case 5:
            message= "Congratulations. You win!";winner=1;
            break;
      }
      return message;
   }
   
   public String whatGrew()
   {
      String writing="";
      //DEVELOPER OPTION
      /*if(winner==1)
         writing="You guessed the whole word before the entire guy was hung!";
      else
      {
         if(noChange==1)
         {
            writing="The guy did not change.";
         }
         else
         {
            switch(grow)
            {
               case 1:
                  writing= "The guy \"grew\" a head.";
                  break;
               case 2:
                  writing= "The guy \"grew\" a body.";
                  break;
               case 3:
                  writing= "The guy \"grew\" an arm.";
                  break;
               case 4:
                  writing= "The guy \"grew\" another arm.";
                  break;
               case 5:
                  writing= "The guy \"grew\" a leg.";
                  break; 
               case 6:
                  writing= "The guy \"grew\" another leg.";
                  break;
               case 7:
                  writing= "The entire guy was hung.";
                  break;   
               case 0:
                  writing= " ";
                  break;  
            }
         }
      }*/
      return writing;
   }
   
   public void drawNoose()
   {
      System.out.println("__________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________");
      System.out.println("________");
      System.out.println("[] //  :");
      System.out.println("[]//   :");
      System.out.println("[]/    ");
      System.out.println("[]               "+writeMessage());
      System.out.println("[]               "+whatGrew());
      System.out.println("[]");
      System.out.println("[]_________");
      System.out.println("[]_________|");
   }
   
   public void drawHead()
   {
      System.out.println("__________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________");
      System.out.println("________");
      System.out.println("[] //  :");
      System.out.println("[]//   :");
      System.out.println("[]/    O");
      System.out.println("[]               "+writeMessage());
      System.out.println("[]               "+whatGrew());
      System.out.println("[]");
      System.out.println("[]_________");
      System.out.println("[]_________|");
   }
   
   public void drawBody()
   {
      System.out.println("__________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________");
      System.out.println("________");
      System.out.println("[] //  :");
      System.out.println("[]//   :");
      System.out.println("[]/    O");
      System.out.println("[]     |         "+writeMessage());
      System.out.println("[]               "+whatGrew());
      System.out.println("[]");
      System.out.println("[]_________");
      System.out.println("[]_________|");
   }
   
   public void drawLeftArm()
   {
      System.out.println("__________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________");
      System.out.println("________");
      System.out.println("[] //  :");
      System.out.println("[]//   :");
      System.out.println("[]/    O");
      System.out.println("[]    /|          "+writeMessage());
      System.out.println("[]                "+whatGrew());
      System.out.println("[]");
      System.out.println("[]_________");
      System.out.println("[]_________|");
   }
   
   public void drawRightArm()
   {
      System.out.println("__________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________");
      System.out.println("________");
      System.out.println("[] //  :");
      System.out.println("[]//   :");
      System.out.println("[]/    O");
      System.out.println("[]    /|\\         "+writeMessage());
      System.out.println("[]                "+whatGrew());
      System.out.println("[]");
      System.out.println("[]_________");
      System.out.println("[]_________|");
   }
   
   public void drawLeftFoot()
   {
      System.out.println("__________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________");
      System.out.println("________");
      System.out.println("[] //  :");
      System.out.println("[]//   :");
      System.out.println("[]/    O");
      System.out.println("[]    /|\\        "+writeMessage());
      System.out.println("[]   _/          "+whatGrew());
      System.out.println("[]");
      System.out.println("[]_________");
      System.out.println("[]_________|");
   }
   
   public void drawRightFoot()
   {
      System.out.println("__________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________");
      System.out.println("________");
      System.out.println("[] //  :");
      System.out.println("[]//   :");
      System.out.println("[]/    O");
      System.out.println("[]    /|\\         You ran out of tries.");
      System.out.println("[]   _/ \\_        "+writeMessage());
      System.out.println("[]                ");
      System.out.println("[]_________");
      System.out.print("[]_________|");
   }
   
   public void guessLetter(int value)
   {  
      noChange=0;
      winner=0;
      round+=value;
      Scanner keyboard=new Scanner(System.in);
      char Letter=' ';
      if(round>1)
         System.out.print("\nLetters You've Used: ["+letterUsed+"]");
      System.out.print("\nTries Remaining: ["+lives+"]");
      System.out.print("\nGuess letter: ");
      Letter=keyboard.next().charAt(0);
      if((int)Letter<97)
      Letter=(char)((int)Letter+32);
      if(letterUsed.indexOf(Letter)>=0)
         note=3;
      
      else if(guess.indexOf(Letter)<0)
      {
         lives-=1;
         if(lives==0)
            note=4;
         else
            note=2;
         if(letterUsed.indexOf(Letter)<0)
         {
            if(round==1)
               letterUsed=Letter+"";
            else
               letterUsed=letterUsed+", "+Letter;
         }
      }
      for(int position=0; position<guess.length();position++)
      {
         if(guess.charAt(position)==Letter&&output[position].charAt(0)!=Letter)
         {  
            output[position]=Letter+" ";
            note=1;
            count++;
            if(count==output.length)
               note=5;
            if(letterUsed.indexOf(Letter)<0)
            {
               if(round==1)
                  letterUsed=Letter+"";
               else
                  letterUsed=letterUsed+", "+Letter;
            }
         }
      }
      System.out.print("\n");
      drawSomething();
      System.out.print("\n");
      if(lives!=0)
      {
         for(String item:output)
         {
            System.out.print(item);
         }
      }
      System.out.println("");
   
   }
   
   public boolean ifLeft()
   {
      if(count==output.length)
         return false;
      if(lives==0)
      {  
         System.out.println("The word was : "+guess);
         Continue();
         return false;
      }
      
      return true;
   }
   
   public int getStep()
   {
      return step;
   }
   
   public boolean keepPlaying()
   {
      Scanner keyboard=new Scanner(System.in);
      System.out.println("\n__________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________");
      System.out.print("\nDo you want to play again? (Yes or No): ");  
      String answer=keyboard.next(); 
      if(answer.charAt(0)=='y'||answer.charAt(0)=='Y')
      {
         step+=1;
         return true;
      }
      else
      {
         System.out.print("\n");
         System.out.println("__________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________");
         System.out.println("\nThanks for playing!");
         System.out.println("\n__________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________");
         System.exit(0);
      }
      return false;
   }
}
