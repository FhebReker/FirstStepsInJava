/**
***********************************************
 @Author      : Fardin Abbassi
 @Last Modified: 2022-10-02
 @Description: Inputs a paragraph, then asks to either count all words, count instances of one word, create a new paragraph, or exit the program.

***********************************************
*/
import java.util.Scanner;

public class Scrabble {
    public static void main(String[] args) {
        String key, paragraph, word, temp;
        int index, count, wordCount;
        char menuSelect;
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter paragraph: ");
        paragraph = scanner.nextLine();
        System.out.println();
        
        key = " ";  index = paragraph.indexOf(key);
        count = 0;  wordCount = 0;
        
        while (true){
            System.out.println("Which would you like to do? \n\nEnter new paragraph (Enter 'P') \nSearch for a word (Enter 'W') \nFind word count (Enter 'F') \nExit (Enter 'E')\n");
            temp = scanner.nextLine(); temp = temp.toUpperCase();
            menuSelect = temp.charAt(0);
            System.out.println();

    
            switch(menuSelect){
                
            // Printing paragraph //
                case 'P':
                    System.out.println("Enter paragraph: ");
                    paragraph = scanner.nextLine();
                    System.out.println();
                    
                    index = paragraph.indexOf(key);
                    break;
                    
            // Paragraph printed
    
            // Searching for word
                case 'W':                                                         // This should output where the word occurs
                    System.out.println("Search for a word: ");
                    word = scanner.nextLine();
                    
                    if (paragraph.indexOf(word) != -1){
                        if (paragraph.indexOf(word) == 0 && paragraph.charAt(word.length()) == ' ')
                            wordCount++;
                        if (paragraph.charAt(paragraph.length() - 1) == word.charAt(word.length() - 1))
                            wordCount++;
                        for (int j = 1; j < paragraph.length(); j++){
                            if (paragraph.charAt(paragraph.length() - 1) != word.charAt(word.length() - 1)){
                                if (paragraph.charAt(j - 1) == ' ' && paragraph.charAt(j) == word.charAt(0) && paragraph.charAt(j + word.length()) == ' ')
                                    wordCount++;
                            }
                        }
                    }
                    System.out.println("Times " + word + " appears in paragraph: " + wordCount);
                    System.out.println();
                    break;
            // Word searched
            
            // Finding word count
                case 'F':
                    if (index != -1)
                        word = paragraph.substring(0, index);
                    else;
                        word = paragraph.substring(0);
                    count = 0;  wordCount = 0;
            
                    if (paragraph.charAt(0) != ' ')
                        count++;
            
                    for (int i = 0; i < paragraph.length(); i++){
                        
                        if (paragraph.charAt(i) == ' ' && paragraph.charAt(i+1) != ' ')
                            count++;
                    }
                    System.out.println("Words counted: " + count);
                    System.out.println();
                    break;
            // Found word count  
            
            // Exiting loop
                case 'E':                                              // The program never ends because it always loops back
                    break;
                default:
                    System.out.println("Invalid character, try again.");
            }
        }
    }
}
