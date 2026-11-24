import java.util.Scanner;

public class RekapLaundryDinamis26 { 

    static void inputData(int[][] data, String[] layanan) {
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < data.length; i++) {
            System.out.println("\nInput berat cucian (kg) untuk layanan " + layanan[i] + ":");
            for (int j = 0; j < data[i].length; j++) {
                System.out.print("  Hari ke-" + (j + 1) + ": ");
                data[i][j] = input.nextInt();
            }
        }
    }

    static void tampilTabel(int[][] data, String[] layanan, int[] harga) {
        int jmlHari = data[0].length;
        System.out.println("\n==================== TABEL REKAP BERAT CUCIAN (KG) ====================");
        System.out.printf("%-15s %-12s", "Layanan", "Harga/kg");
        for (int j = 0; j < jmlHari; j++) {
            System.out.printf("%-12s", "Hari ke-" + (j + 1));
        }
        System.out.println("\n-----------------------------------------------------------------------");

        for (int i = 0; i < layanan.length; i++) {
            System.out.printf("%-15s Rp%-10d", layanan[i], harga[i]);
            for (int j = 0; j < jmlHari; j++) {
                System.out.printf("%-12d", data[i][j]);
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
        System.out.println("Total Pendapatan Keseluruhan: Rp" + totalPendapatanKeseluruhan);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan jumlah layanan: ");
        int jmlLayanan = input.nextInt();
        System.out.print("Masukkan jumlah hari: ");
        int jmlHari = input.nextInt();
        input.nextLine(); 

        String[] layanan = new String[jmlLayanan];
        int[] harga = new int[jmlLayanan];
        int[][] data = new int[jmlLayanan][jmlHari];

        for (int i = 0; i < jmlLayanan; i++) {
            System.out.print("\nMasukkan nama layanan ke-" + (i + 1) + ": ");
            layanan[i] = input.nextLine();
            System.out.print("Masukkan harga per kg untuk " + layanan[i] + ": ");
            harga[i] = input.nextInt();
            input.nextLine(); 
        }

        inputData(data, layanan);
        
        tampilTabel(data, layanan, harga);

        System.out.println("\n--- Total Berat Per Layanan ---");
        for (int i = 0; i < layanan.length; i++) {
            System.out.println(layanan[i] + ": " + totalPerLayanan(data, i) + " kg");
        }

        tampilLayananTertinggi(data, layanan);

        int idxSibuk = hariTersibuk(data);
        System.out.println("Hari tersibuk: Hari ke-" + (idxSibuk + 1) + " (indeks " + idxSibuk + ")");

        tampilPendapatan(data, layanan, harga);
    }
}