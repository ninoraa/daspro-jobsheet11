import java.util.Scanner;

public class LuasLingkaranReturnParameter26 {
    static double luasLingkaran(double r) {
        double phi = 3.14;
        double luas = phi * r * r;
        return luas;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan jari-jari: ");
        double jari = input.nextDouble();

        double L = luasLingkaran(jari);
        System.out.println("Luas lingkaran = " + L);
    }
}