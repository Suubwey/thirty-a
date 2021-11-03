package thirtya;

import java.util.Scanner;

public class TowerOfHanoi {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // input scanner to get the amount of disks the user has
        System.out.println("Number of Disks: ");
        int disks = input.nextInt();
        // the three pegs will be labelled A B and C
        solveHanoi(disks, 'A', 'B', 'C');
        // this is the initial call to the function that will set off the recursive iterations.
        input.close();
    }

    public static void solveHanoi(int disks, char startpeg, char endpeg, char auxpeg) {
        // when the disk number becomes one, it prints the solving step for that one disk
        if (disks == 1) {
            System.out.println("Move disk 1 from peg " + startpeg + " to " + endpeg);
            return;
        }
        // the divide part of the divide and conquer algorithm, this function call to itself simplifies the problem down to fewer disks
        solveHanoi(disks - 1, startpeg, auxpeg, endpeg);
        // these two lines will move disks from peg to peg, switching between using the auxiliary peg and the end peg.
        System.out.println("Move disk " + disks + " from peg " + startpeg + " to " + endpeg);
        solveHanoi(disks - 1, endpeg, startpeg, auxpeg);
    }
}
