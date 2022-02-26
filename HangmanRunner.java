import java.util.Arrays;
import java.util.Scanner;
import java.io.IOException;
import java.io.File;
   
public class HangmanRunner
{
   public static void main( String args[] )throws IOException
   {
      boolean play;
      int stage=0;
      do
      { 
         Hangman test=new Hangman(); 
         if(stage==0)  
         { 
            test.Introduction();
         }
         test.Difficulty();
         test.Instructions();
         test.Continue();
         test.printBlanks();
         while(test.ifLeft())
         {
            test.guessLetter(1);
         }  
         play=test.keepPlaying();
         if(test.getStep()>0)
            System.out.print("\n");
         stage+=1;
      }while(play==true);
   }
}
