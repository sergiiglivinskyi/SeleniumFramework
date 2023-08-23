package testcases;

import org.testng.annotations.Test;

public class NestedLoopsTest extends BaseTest{

    @Test
    public void nestedLoop() {
        for(int i = 0; i < 11; i++) {
            System.out.println("outer value: " + i);
            System.out.println("------------------------------------");
            for(int j = 100; j < 111; j++) {
                System.out.println("inner value: " + j);
            }
            System.out.println("====================================");
        }
    }

    @Test
    public void multidimensionalArray() {
        int[][] multidimensionalArray = new int[4][5];
        multidimensionalArray[0][0] = 1;
        multidimensionalArray[0][1] = 2;
        multidimensionalArray[1][0] = 11;

        int value = 1;
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 5; j++) {
                multidimensionalArray[i][j] = value;
                System.out.print(multidimensionalArray[i][j] + " | ");
                value++;
            }
            System.out.println();
        }
    }

    @Test
    public void schedule() {
        int rows = 4;
        int columns = 8;
        String[][] days = new String[rows][columns];

        for(int i = 0; i < rows; i++) {
            days[i][0] = "Week " + (i+1) + ": ";
            System.out.print(days[i][0]);
            for(int j = 1; j < columns; j++) {
                days[i][j] = "Day " + j + " | ";
                System.out.print(days[i][j]);
            }
            System.out.println();
        }

    }

    @Test
    public void Players() {
        playersPage.openWebsite();
        playersPage.clickAgree();
        playersPage.playersInfo();
        playersPage.printData();
    }
}