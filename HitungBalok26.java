import java.util.Scanner;

public class HitungBalok26 {
    static int hitungLuas(int pjg, int lb) {
        int Luas = pjg * lb;
        return Luas;
    }

    static int hitungVolume(int tinggi, int a, int b) {
        int volume = hitungLuas(a, b) * tinggi;
        return volume;
    }

    static int hitungLuasPermukaanBalok(int p, int l, int t) {
        return 2 * (hitungLuas(p, l) + hitungLuas(p, t) + hitungLuas(l, t));
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        for (int i = 1; i <= 3; i++) {
            System.out.println("=== Balok ke-" + i + " ===");
            System.out.print("Panjang: ");
            int p = input.nextInt();
            System.out.print("Lebar: ");
            int l = input.nextInt();
            System.out.print("Tinggi: ");
            int t = input.nextInt();

            System.out.println("Luas permukaan: " + hitungLuasPermukaanBalok(p, l, t));
            System.out.println("Volume: " + hitungVolume(t, p, l));
        }

        input.close();   
    }
}