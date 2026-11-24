import java.util.Scanner;

public class LuasLingkaranReturnNoParameter26 {
    static double luasLingkaran() {
        Scanner input = new Scanner(System.in);
        double phi = 3.14;

        System.out.print("Masukkan jari-jari: ");
        double r = input.nextDouble();

        double luas = phi * r * r;
        return luas;
    }

    public static void main(String[] args) {
        double L = luasLingkaran();
        System.out.println("Luas lingkaran = " + L);
    }
}