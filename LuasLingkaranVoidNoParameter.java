import java.util.Scanner;
public class LuasLingkaranVoidNoParameter {

    static void luasLingkaran() {
        Scanner input = new Scanner(System.in);
        double phi = 3.14;

        System.out.print("Masukkan jari-jari: ");
        double r = input.nextDouble();

        double luas = phi * r * r;
        System.out.println("Luas lingkaran = " + luas);
    }

    public static void main(String[] args) {
        luasLingkaran();
    }
}

