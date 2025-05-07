/**
***********************************************
 @Author      : Fardin Abbassi
 @Last Modified: 2022-09-26
   @Description: Takes in test number, mark, then evaluates weighted score

***********************************************
*/
  public void WeighedDown(int testNumber, int mark){
        double weightedScore = mark * 0.1;

        // Use comments to indicate the purpose of large chunks of code
        switch (testNumber){   
          case 1: weightedScore = mark * (10 / 100.0);
            System.out.println("A score of " + mark + " on test " + testNumber + " gives a weighted score of " + weightedScore);
                break;
          case 2: weightedScore = mark * (20 / 100.0);
            System.out.println("A score of " + mark + " on test " + testNumber + " gives a weighted score of " + weightedScore);
                break;
          case 3: weightedScore = mark * (20 / 100.0);
             System.out.println("A score of " + mark + " on test " + testNumber + " gives a weighted score of " + weightedScore);
                break;
          case 4: weightedScore = mark * (15 / 100.0);
             System.out.println("A score of " + mark + " on test " + testNumber + " gives a weighted score of " + weightedScore);
                break;
          case 5: weightedScore = mark * (15 / 100.0);
             System.out.println("A score of " + mark + " on test " + testNumber + " gives a weighted score of " + weightedScore);
                break;
          case 6: weightedScore = mark * (20 / 100.0);
             System.out.println("A score of " + mark + " on test " + testNumber + " gives a weighted score of " + weightedScore);
                break;
          default: System.out.println("Not a valid test number!");
        }
}
