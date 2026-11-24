public class PengunjungCafe26 {

    static void daftarPengunjung(int nomorMeja, String... namaPengunjung) {
        System.out.println("Meja nomor " + nomorMeja + " - Daftar Nama Pengunjung:");
        for (String nama : namaPengunjung) {
            System.out.println("- " + nama);
        }
    }
    static int hitungTotalBelanja(int... harga) {
    int total = 0;
    for (int h : harga) {
        total += h;
    }
    return total;
}

    public static void main(String[] args) {
        daftarPengunjung(1, "Ali", "Budi", "Citra");
        daftarPengunjung(2, "Andi");
        daftarPengunjung(3, "Doni", "Eti", "Fahmi", "Galih");
         System.out.println("Total 1 barang : Rp" + hitungTotalBelanja(15000));
        System.out.println("Total 3 barang : Rp" + hitungTotalBelanja(15000, 20000, 22000));
        System.out.println("Total 5 barang : Rp" + hitungTotalBelanja(15000, 20000, 22000, 12000, 10000));
    }
}