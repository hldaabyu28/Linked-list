// LinkedList: Single Linked List untuk data buku perpustakaan
public class LinkedList {
    private Node head; // node pertama
    private int size;  // jumlah data

    public static final int MIN_BUKU = 5;
    public static final int MAX_KODE = 5;

    public int getSize() { return size; }
    public boolean isEmpty() { return head == null; }

    // Tambah buku di AKHIR daftar (push). Mengembalikan pesan hasil.
    public String tambah(String kode, String judul, String penulis) {
        // Validasi: kode maksimal 5 karakter dan tidak kosong
        if (kode.isEmpty() || kode.length() > MAX_KODE) {
            return "Gagal: kode buku harus 1-" + MAX_KODE + " karakter!";
        }
        if (judul.isEmpty() || penulis.isEmpty()) {
            return "Gagal: judul dan penulis tidak boleh kosong!";
        }
        // Validasi: kode tidak boleh duplikat
        if (cari(kode) != null) {
            return "Gagal: kode buku sudah digunakan!";
        }
        Node baru = new Node(kode, judul, penulis);
        if (head == null) {
            head = baru;
        } else {
            Node bantu = head;
            while (bantu.next != null) { // telusuri sampai node terakhir
                bantu = bantu.next;
            }
            bantu.next = baru;
        }
        size++;
        return "Data berhasil ditambahkan!";
    }

    // Hapus buku TERAKHIR (pop)
    public String hapusTerakhir() {
        if (head == null) {
            return "Tidak ada data untuk dihapus.";
        }
        Node dihapus;
        if (head.next == null) { // hanya satu node
            dihapus = head;
            head = null;
        } else {
            Node bantu = head;
            while (bantu.next.next != null) { // berhenti di node sebelum terakhir
                bantu = bantu.next;
            }
            dihapus = bantu.next;
            bantu.next = null;
        }
        size--;
        return "Buku terakhir berhasil dihapus: " + dihapus.kodeBuku + " - " + dihapus.judul;
    }

    // Cari buku berdasarkan kode (tidak case-sensitive)
    public Node cari(String kode) {
        Node bantu = head;
        while (bantu != null) {
            if (bantu.kodeBuku.equalsIgnoreCase(kode)) {
                return bantu;
            }
            bantu = bantu.next;
        }
        return null;
    }

    // Tampilkan semua buku sesuai urutan input
    public void tampilkan() {
        if (head == null) {
            System.out.println("Daftar buku masih kosong.");
            return;
        }
        System.out.println("Daftar Buku:");
        Node bantu = head;
        while (bantu != null) {
            System.out.println("Kode: " + bantu.kodeBuku + " │ Judul: " + bantu.judul
                    + " │ Penulis: " + bantu.penulis);
            bantu = bantu.next;
        }
        System.out.println("Total Buku: " + size);
        if (size < MIN_BUKU) {
            System.out.println("(Catatan: data minimal " + MIN_BUKU + " buku, masih kurang "
                    + (MIN_BUKU - size) + ")");
        }
    }
}
