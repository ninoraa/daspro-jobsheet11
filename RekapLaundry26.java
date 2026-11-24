 import java.util.Scanner;

public class RekapLaundry26 {
   
    static void inputData(int[][] data, String[] layanan, String[] hari) {
        Scanner input = new Scanner(System.in);

        for (int i = 0; i < layanan.length; i++) {
            System.out.println("\nInput berat cucian (kg) untuk layanan " + layanan[i] + ":");
            for (int j = 0; j < hari.length; j++) {
                System.out.print("  Hari " + hari[j] + ": ");
                data[i][j] = input.nextInt();
            }
        }
    }

    static void tampilTabel(int[][] data, String[] layanan, int[] harga, String[] hari) {
        System.out.println("\n==================== TABEL REKAP BERAT CUCIAN (KG) ====================");
        System.out.printf("%-15s %-12s", "Layanan", "Harga/kg");
        for (String h : hari) {
            System.out.printf("%-8s", h);
        }
        System.out.println("\n-----------------------------------------------------------------------");

        for (int i = 0; i < layanan.length; i++) {
            System.out.printf("%-15s Rp%-10d", layanan[i], harga[i]);
            for (int j = 0; j < hari.length; j++) {
                System.out.printf("%-8d", data[i][j]);
            }
            System.out.println();
        }
        System.out.println("=======================================================================");
    }

    static int totalPerLayanan(int[][] data, int idxLayanan) {
        int total = 0;
        for (int j = 0; j < data[idxLayanan].length; j++) {
            total += data[idxLayanan][j];
        }
        return total;
    }

    static void tampilLayananTertinggi(int[][] data, String[] layanan) {
        int idxMax = 0;
        int maxBerat = totalPerLayanan(data, 0);

        for (int i = 1; i < layanan.length; i++) {
            int totalSekarang = totalPerLayanan(data, i);
            if (totalSekarang > maxBerat) {
                maxBerat = totalSekarang;
                idxMax = i;
            }
        }
        System.out.println("\nLayanan dengan total berat cucian tertinggi: " + layanan[idxMax] + " (" + maxBerat + " kg)");
    }

    static int hariTersibuk(int[][] data) {
        int idxHariMax = 0;
        int maxBeratHari = 0;

        for (int j = 0; j < data[0].length; j++) {
            int totalHari = 0;
            for (int i = 0; i < data.length; i++) {
                totalHari += data[i][j];
            }
            if (j == 0 || totalHari > maxBeratHari) {
                maxBeratHari = totalHari;
                idxHariMax = j;
            }
        }
        return idxHariMax;
    }

    static void tampilPendapatan(int[][] data, String[] layanan, int[] harga) {
        System.out.println("\n--- Rincian Pendapatan Layanan ---");
        long totalPendapatanKeseluruhan = 0;

        for (int i = 0; i < layanan.length; i++) {
            int totalBerat = totalPerLayanan(data, i);
            long pendapatanLayanan = (long) totalBerat * harga[i];
            totalPendapatanKeseluruhan += pendapatanLayanan;
            System.out.println(layanan[i] + " (" + totalBerat + " kg x Rp" + harga[i] + ") = Rp" + pendapatanLayanan);
        }
        System.out.println("Total Pendapatan Selama 6 Hari: Rp" + totalPendapatanKeseluruhan);
    }

    public static void main(String[] args) {
        String[] layanan = {"Cuci Kering", "Cuci Setrika", "Setrika Saja", "Express"};
        int[] harga = {6000, 8000, 5000, 12000};
        String[] hari = {"Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu"};
        int[][] data = new int[layanan.length][hari.length];

        // Memanggil seluruh fungsi
        inputData(data, layanan, hari);
        tampilTabel(data, layanan, harga, hari);

        System.out.println("\n--- Total Berat Per Layanan ---");
        for (int i = 0; i < layanan.length; i++) {
            System.out.println(layanan[i] + ": " + totalPerLayanan(data, i) + " kg");
        }

        tampilLayananTertinggi(data, layanan);

        int idxSibuk = hariTersibuk(data);
        System.out.println("Hari tersibuk: " + hari[idxSibuk] + " (indeks " + idxSibuk + ")");

        tampilPendapatan(data, layanan, harga);
    }
}

