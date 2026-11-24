
    import java.util.Scanner;

public class BankSampah26 { 

    
    static double[] inputSetoran(int n) {
        Scanner sc = new Scanner(System.in);
        double[] setoran = new double[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Masukkan berat setoran nasabah ke-" + (i + 1) + " (kg): ");
            setoran[i] = sc.nextDouble();
        }
        return setoran;
    }


    static void tampilSetoran(double[] setoran) {
        System.out.println("\n--- Daftar Setoran Sampah ---");
        for (int i = 0; i < setoran.length; i++) {
            System.out.println("Nasabah ke-" + (i + 1) + ": " + setoran[i] + " kg");
        }
    }

    static double totalSetoran(double[] setoran) {
        double total = 0;
        for (int i = 0; i < setoran.length; i++) {
            total += setoran[i];
        }
        return total;
    }

    static double hitungSaldo(double berat, double hargaPerKg) {
        return berat * hargaPerKg;
    }

    static int nasabahTerbanyak(double[] setoran) {
        int indeksMax = 0;
        for (int i = 1; i < setoran.length; i++) {
            if (setoran[i] > setoran[indeksMax]) {
                indeksMax = i;
            }
        }
        return indeksMax;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double hargaPerKg = 3000.0;

        System.out.print("Masukkan jumlah nasabah (N): ");
        int n = sc.nextInt();

        double[] dataSetoran = inputSetoran(n);

        tampilSetoran(dataSetoran);

        System.out.println("\n--- Saldo Setiap Nasabah (Rp3.000/kg) ---");
        for (int i = 0; i < dataSetoran.length; i++) {
            double saldo = hitungSaldo(dataSetoran[i], hargaPerKg);
            System.out.println("Saldo Nasabah ke-" + (i + 1) + ": Rp" + saldo);
        }

        double totalBerat = totalSetoran(dataSetoran);
        System.out.println("\nTotal berat setoran seluruh nasabah: " + totalBerat + " kg");

        int idxTerbanyak = nasabahTerbanyak(dataSetoran);
        System.out.println("Nasabah dengan setoran terbanyak: Nasabah ke-" + (idxTerbanyak + 1) + " (indeks " + idxTerbanyak + ") sebesar " + dataSetoran[idxTerbanyak] + " kg");
    }
}


