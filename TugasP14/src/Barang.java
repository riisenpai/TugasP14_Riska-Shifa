import java.util.Scanner;
public class Barang implements Penjualan  {
    public String namaBarang;
    public int hargaBarang;
    public String noFaktur;
    public int jumlah;
    public int subTotal;
    public int discount;
    public int totalHarga;

    Scanner keyboard = new Scanner(System.in);

    @Override
    public String NamaBarang() {
        System.out.print("Nama Barang \t: ");
        namaBarang = keyboard.nextLine();
        namaBarang = namaBarang.toUpperCase();
        return namaBarang;
    }

    @Override
    public int HargaBarang() {
        System.out.print("Harga Barang \t: ");
        hargaBarang = keyboard.nextInt();
        return hargaBarang;
    }

    @Override
    public String NoFaktur() {
        System.out.print("No faktur \t: ");
        noFaktur = keyboard.nextLine();
        noFaktur=noFaktur.toUpperCase();
        noFaktur=noFaktur.trim();
        return noFaktur;
    }

    @Override
    public int Jumlah() {
        System.out.print("Jumlah Barang \t: ");
        jumlah = keyboard.nextInt();
        return jumlah;
    }

    @Override
    public int SubTotal() {
        subTotal=0;
        System.out.print("Subtotal \t: " + subTotal);
        return subTotal;
    }

    @Override
    public int Discount() {
        discount=0;
        System.out.print("Diskon \t: " + discount);
        return discount;
    }

    @Override
    public int TotalHarga() {
        totalHarga=0;
        System.out.print("Total Harga \t: " + totalHarga);
        return totalHarga;
    }

    

}
