import java.util.Scanner;
public class LuasLingkaranMain26 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double phi = 3.14;

        System.out.print("Masukkan jari-jari: ");
        double r = input.nextDouble();

        double luas = phi * r * r;
        System.out.println("Luas lingkaran = " + luas);
    }
}

