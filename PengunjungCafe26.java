public class PengunjungCafe26 {

    static void daftarPengunjung(int nomorMeja, String... namaPengunjung) {
        System.out.println("Meja nomor " + nomorMeja + " - Daftar Nama Pengunjung:");
        for (String nama : namaPengunjung) {
            System.out.println("- " + nama);
        }
    }

    public static void main(String[] args) {
        daftarPengunjung(1, "Ali", "Budi", "Citra");
        daftarPengunjung(2, "Andi");
        daftarPengunjung(3, "Doni", "Eti", "Fahmi", "Galih");
    }
}