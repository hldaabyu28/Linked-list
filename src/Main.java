import java.util.Scanner;

// Main: menu program pengelolaan daftar buku perpustakaan
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LinkedList daftar = new LinkedList();
        int pilihan = 0;

        do {
            System.out.println("\n===== SISTEM DATA BUKU =====");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Hapus Buku");
            System.out.println("3. Cari Buku");
            System.out.println("4. Lihat Semua Buku");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");

            try {
                pilihan = Integer.parseInt(input.nextLine().trim());
            } catch (NumberFormatException e) {
                pilihan = 0; // input bukan angka
            }

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan Kode Buku: ");
                    String kode = input.nextLine().trim();
                    System.out.print("Masukkan Judul: ");
                    String judul = input.nextLine().trim();
                    System.out.print("Masukkan Penulis: ");
                    String penulis = input.nextLine().trim();
                    System.out.println(daftar.tambah(kode, judul, penulis));
                    break;
                case 2:
                    System.out.println(daftar.hapusTerakhir());
                    break;
                case 3:
                    System.out.print("Masukkan Kode Buku: ");
                    Node hasil = daftar.cari(input.nextLine().trim());
                    if (hasil != null) {
                        System.out.println("Buku ditemukan!");
                        System.out.println("Kode: " + hasil.kodeBuku + " │ Judul: " + hasil.judul
                                + " │ Penulis: " + hasil.penulis);
                    } else {
                        System.out.println("Buku tidak ditemukan.");
                    }
                    break;
                case 4:
                    daftar.tampilkan();
                    break;
                case 5:
                    System.out.println("Terima kasih. Program selesai.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 5);
        input.close();
    }
}
