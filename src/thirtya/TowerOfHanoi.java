package thirtya;

import java.util.Scanner;

public class TowerOfHanoi {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("How many disks? (0 to end)");
        int disks = input.nextInt();
        solveHanoi(disks, 'A', 'B', 'C');
        input.close();
    }

    public static void solveHanoi(int disks, char startpeg, char endpeg, char auxpeg) {
        if (disks == 1) {
            System.out.println("Move disk 1 from peg " + startpeg + " to " + endpeg);
            return;
        }
        solveHanoi(disks - 1, startpeg, auxpeg, endpeg);
        System.out.println("Move disk " + disks + " from peg " + startpeg + " to " + endpeg);
        solveHanoi(disks - 1, endpeg, startpeg, auxpeg);
    }
}
