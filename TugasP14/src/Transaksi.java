import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaksi extends Barang{

    public int subTotal;
    public int discount;
    public int totalHarga;
    public String kasir;
    public String tgl;
   
    @Override
    public int SubTotal() {
        subTotal = hargaBarang * jumlah;
        return subTotal;
    }

    @Override
    public int Discount() {
        Double pengali;
        if (subTotal>10000000){
            pengali=0.09;
        }else if (subTotal>7000000){
            pengali=0.07;
        }else if (subTotal>1000000) {
            pengali=0.05;
        }else if (subTotal>500000){
            pengali=0.03;
        }else{
            pengali = 0.0;
        }
        discount = (int) (subTotal * pengali);
        return discount;
    }

    @Override
    public int TotalHarga() {
        totalHarga = subTotal-discount;
        return totalHarga;
    }

    public String Tanggal(){
        Date today = new Date();
        SimpleDateFormat format = new SimpleDateFormat("E yyyy.MM.dd 'pada' hh:mm:ss a ");
        tgl = format.format(today);
        //System.out.println("Tgl Transaksi\t : " + format.format(today));
        return tgl;
    }

    public String Kasir() {
        System.out.print("Kasir \t\t: ");
        kasir = keyboard.nextLine();
        kasir = kasir.toLowerCase();
        return kasir;
    }
    
}
