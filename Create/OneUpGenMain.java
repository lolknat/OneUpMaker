package Create;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class OneUpGenMain {
    public static void main(String[] args) {
        //getting inputs
        Scanner sc = new Scanner(System.in);
        System.out.println("Puzzle size: ");
        int size = Integer.parseInt(sc.nextLine());
        System.out.println("Wall qty: ");
        String reply = sc.nextLine();

        //creating puzzle
        OneUpGen puzzle;
        if (reply != null) {
            puzzle = new OneUpGen(size, Integer.parseInt(reply));
        }
        else {
            puzzle = new OneUpGen(size);
        }

        //writing puzzle in file
        System.out.println("Puzzle name: ");
        String fileName = sc.nextLine()+".txt";
        try {
            FileWriter fw = new FileWriter("../"+fileName);
            fw.write(puzzle.toString());
            fw.close();
        }
        catch (IOException e) {
            System.out.println("Error writing file");
            e.printStackTrace();
        }
        sc.close();
    }
}
