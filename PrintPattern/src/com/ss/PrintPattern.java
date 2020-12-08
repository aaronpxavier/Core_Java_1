package com.ss;

public class PrintPattern {
    void printStar(int numOfTimes) {
        while (numOfTimes > 0) {
            System.out.print('*');
            --numOfTimes;
        }
        System.out.println();
    }

    void printNum(int num) {
        System.out.println(num + ")");
    }

    void printDashes(int numOfTimes) {
        while (numOfTimes > 0) {
            System.out.print("_ ");
            --numOfTimes;
        }
        System.out.println();
    }

    void printSpaces(int numOfTimes) {
        while(numOfTimes > 0) {
            System.out.print(' ');
            --numOfTimes;
        }
    }

    public static void main(String[] args) {
        PrintPattern printPattern = new PrintPattern();
        final int ROWS = 4;
        final int STAR_ROWS = 4;
        final int LINES_BASE = 9;
        final int MAX_SPACES = 5;
        for(int i = 0; i < ROWS; ++i) {
            printPattern.printNum(i+1);
            if(i % 2 == 1)
                printPattern.printDashes(LINES_BASE + i);
            switch (i) {
                case 0:
                    for(int j = 1; j <= STAR_ROWS; ++j)
                        printPattern.printStar(j);
                    break;
                case 1:
                    for(int j = 4; j > 0; --j)
                        printPattern.printStar(j);
                    break;
                case 2:
                    for(int j = 1, numStars = 1, numOfSpaces = MAX_SPACES; j <= STAR_ROWS; ++j, numStars+=2, --numOfSpaces) {
                        printPattern.printSpaces(numOfSpaces);
                        printPattern.printStar(numStars);
                    }
                    break;
                case 3:
                    for(int j = 1, numStars = 7, numOfSpaces = MAX_SPACES - 3; j <= STAR_ROWS; ++j, numStars-=2, ++numOfSpaces) {
                        printPattern.printSpaces(numOfSpaces);
                        printPattern.printStar(numStars);
                    }
                    break;
            }
            if(i % 2 == 0)
                printPattern.printDashes(LINES_BASE + i);
        }
    }
}
