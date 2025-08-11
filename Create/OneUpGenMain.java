package Create;

import java.util.Scanner;

public class OneUpGenMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Puzzle size: ");
        int size = Integer.parseInt(sc.nextLine());
        System.out.println("Wall qty: ");
        String reply = sc.nextLine();
        if (reply != null) {
            OneUpGen puzzle = new OneUpGen(size, Integer.parseInt(reply));
        }
        else {
            OneUpGen puzzle = new OneUpGen(size);
        }
    }
}
