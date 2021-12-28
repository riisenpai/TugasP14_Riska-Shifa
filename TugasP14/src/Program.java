import java.util.InputMismatchException;
import java.util.Scanner;

import com.mysql.cj.protocol.Resultset;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;

public class Program {

    static Connection conn;
    public static void main(String[] args) throws Exception {
        
        Scanner terimaInput = new Scanner (System.in);
		String pilihanUser;
		boolean isLanjutkan = true;
        String url = "jdbc:mysql://localhost:3306/minimarket";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url,"root","");
			System.out.println("Class Driver ditemukan");
			
			while (isLanjutkan) {
				System.out.println("\n------------------");
				System.out.println("Database Minimarket");
				System.out.println("------------------");
				System.out.println("1. Lihat Data Transaksi");
				System.out.println("2. Tambah Data Transaksi");
				System.out.println("3. Ubah Data Transaksi");
				System.out.println("4. Hapus Data Transaksi");
				System.out.println("5. Cari Data Transaksi");
				
				System.out.print("\nPilihan anda (1/2/3/4/5): ");
				pilihanUser = terimaInput.next();
				
				switch (pilihanUser) {
				case "1":
					lihatdata();
					break;
				case "2":
					tambahdata();
					break;
				case "3":
					ubahdata();
					break;
				case "4":
					hapusdata();
					break;
				case "5":
					caridata();
					break;
				default:
					System.err.println("\nInput anda tidak ditemukan\nSilakan pilih [1-5]");
				}
				
				System.out.print("\nApakah Anda ingin melanjutkan [y/n]? ");
				pilihanUser = terimaInput.next();
				isLanjutkan = pilihanUser.equalsIgnoreCase("y");
			}
			System.out.println("\nBye.... Selamat Berjumpa Kembali!!!");
        }
		catch(ClassNotFoundException ex) {
			System.err.println("Driver Error");
			System.exit(0);
		}
		catch(SQLException e){
			System.err.println("Tidak berhasil koneksi");
		}
        Transaksi transaksi1 = new Transaksi();
        // transaksi1.NoFaktur();
        // transaksi1.Kasir();
        // transaksi1.NamaBarang();
        // transaksi1.HargaBarang();
        // transaksi1.Jumlah();
        // transaksi1.SubTotal ();
        // transaksi1.Discount ();
        // transaksi1.TotalHarga ();
        

        // System.out.println("\n==========Struk Pembayaran==========");
        // System.out.println("No. Faktur\t : " + transaksi1.noFaktur);
        // transaksi1.Tanggal();
        // System.out.println("Kasir\t\t : " + transaksi1.kasir);
        // System.out.println("------------------------------------");
        // System.out.println("Nama Barang\t : " + transaksi1.namaBarang);
        // System.out.println("Harga Barang\t : " + transaksi1.hargaBarang);
        // System.out.println("Jumlah\t\t : " + transaksi1.jumlah);
        // System.out.println("Sub Total\t : " + transaksi1.subTotal);
        // System.out.println("Discount\t : " + transaksi1.discount);
        // System.out.println("Total Harga\t : " + transaksi1.totalHarga);
    }

    private static void lihatdata() throws SQLException {
        String text1 = "\n===Daftar Seluruh Data Transaksi===";
        System.out.println(text1.toUpperCase());
                        
        String sql ="SELECT * FROM transaksi";
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery(sql);
        
        while(result.next()){
            System.out.print("\nNo. Faktur\t: ");
            System.out.print(result.getString("no_faktur"));
            System.out.print("\nTanggal\t\t: ");
            System.out.print(result.getString("tanggal"));
            System.out.print("\nKasir\t\t: ");
            System.out.print(result.getString("kasir"));
            System.out.print("\nNama Barang\t: ");
            System.out.print(result.getString("nama_barang"));
            System.out.print("\nHarga Barang\t: ");
            System.out.print(result.getInt("harga_barang"));
            System.out.print("\nJumlah\t\t: ");
            System.out.print(result.getInt("jumlah"));
            System.out.print("\nSub Total\t: ");
            System.out.print(result.getInt("subtotal"));
            System.out.print("\nDiscount\t: ");
            System.out.print(result.getInt("discount"));
            System.out.print("\nTotal Harga\t: ");
            System.out.print(result.getInt("total_harga"));
            System.out.print("\n");
        }
    }

    private static void tambahdata() throws SQLException{
		String text2 = "\n===Tambah Data Transaksi===";
		System.out.println(text2.toUpperCase());
		
		// Scanner terimaInput = new Scanner (System.in);
				
		try {
		
		// System.out.print("No. BP\t: ");
		// int nobp = terimaInput.nextInt();
		// System.out.print("Nama\t: ");
		// String nama = terimaInput.next();
		// System.out.print("Alamat\t: ");
		// String alamat = terimaInput.next();

        Transaksi transaksi1 = new Transaksi();
        transaksi1.NoFaktur();
        transaksi1.Kasir();
        transaksi1.NamaBarang();
        transaksi1.HargaBarang();
        transaksi1.Jumlah();
        transaksi1.SubTotal ();
        transaksi1.Discount ();
        transaksi1.TotalHarga ();
		
		String sql = "INSERT INTO transaksi (no_faktur, tanggal, kasir, nama_barang, harga_barang, jumlah, subtotal, discount, total_harga) VALUES ('"+transaksi1.noFaktur+"','"+transaksi1.Tanggal()+"','"+transaksi1.kasir+"','"+transaksi1.namaBarang+"','"+transaksi1.hargaBarang+"','"+transaksi1.jumlah+"','"+transaksi1.subTotal+"','"+transaksi1.discount+"','"+transaksi1.totalHarga+"')";
					
        Statement statement = conn.createStatement();
        statement.execute(sql);
        System.out.println("Berhasil input data");
	
	    } catch (SQLException e) {
	        System.err.println("Terjadi kesalahan input data");
	    } catch (InputMismatchException e) {
	    	System.err.println("Masukkan inputan yang valid");
	   	}
	}

    private static void ubahdata() throws SQLException{
		String text3 = "\n===Ubah Data Transaksi===";
		System.out.println(text3.toUpperCase());
		
		Scanner terimaInput = new Scanner (System.in);
		
		try {
            lihatdata();

            Transaksi transaksi1 = new Transaksi();

            System.out.print("Masukkan No. Faktur Transaksi yang akan diubah!! \n");
            //String noFaktur = terimaInput.nextLine();
            transaksi1.NoFaktur();
            
            String sql = "SELECT * FROM transaksi WHERE no_faktur = " +transaksi1.noFaktur;
            
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            
            if(result.next()){
                
                System.out.print("Kasir ["+result.getString("kasir")+"]\t: ");
                // String kasir = terimaInput.nextLine();
                transaksi1.Kasir();
                
                System.out.print("Nama Barang ["+result.getString("nama_barang")+"]\t: ");
                //String namaBarang = terimaInput.nextLine();
                transaksi1.NamaBarang();

                System.out.print("Harga Barang ["+result.getInt("harga_barang")+"]\t: ");
                //Integer hargaBarang = terimaInput.nextInt();
                transaksi1.HargaBarang();
                
                System.out.print("Jumlah ["+result.getInt("jumlah")+"]\t: ");
                //Integer jumlah = terimaInput.nextInt();
                transaksi1.Jumlah();

                System.out.print("Sub Total ["+result.getInt("subtotal")+"]\t: ");
                transaksi1.SubTotal ();
                System.out.print(transaksi1.subTotal + "\n");
                
                System.out.print("Discount ["+result.getInt("discount")+"]\t: ");
                //Integer discount = terimaInput.nextInt();
                transaksi1.Discount ();
                System.out.print(transaksi1.discount + "\n");

                System.out.print("Total Harga ["+result.getInt("total_harga")+"]\t: ");
                //Integer totalHarga = terimaInput.nextInt();
                transaksi1.TotalHarga ();
                System.out.print(transaksi1.totalHarga + "\n");
                
                   
                sql = "UPDATE transaksi SET kasir='"+transaksi1.kasir+"',nama_barang= '"+transaksi1.namaBarang+"',harga_barang= '"+transaksi1.hargaBarang+"', jumlah= '"+transaksi1.jumlah+"',subtotal= '"+transaksi1.subTotal+"',discount= '"+transaksi1.discount+"',total_harga= '"+transaksi1.totalHarga+"' WHERE no_faktur='"+transaksi1.noFaktur+"'";
                //System.out.println(sql);

                if(statement.executeUpdate(sql) > 0){
                    System.out.println("Berhasil memperbaharui data Transaksi (No. Faktur "+transaksi1.noFaktur+")");
                }
            }
            statement.close();        
        } catch (SQLException e) {
            System.err.println("Terjadi kesalahan dalam mengedit data");
            System.err.println(e.getMessage());
        }
	}

    private static void hapusdata() {
		String text4 = "\n===Hapus Data Transaksi===";
		System.out.println(text4.toUpperCase());
		
		Scanner terimaInput = new Scanner (System.in);
		
		try{
	        lihatdata();
	        System.out.print("Ketik No. Faktur Transaksi yang akan Anda Hapus : ");
	        String noFaktur= terimaInput.nextLine();
	        
	        String sql = "DELETE FROM transaksi WHERE no_faktur = "+ noFaktur;
	        Statement statement = conn.createStatement();
	        //ResultSet result = statement.executeQuery(sql);
	        
	        if(statement.executeUpdate(sql) > 0){
	            System.out.println("Berhasil menghapus data Transaksi (No. Faktur "+noFaktur+")");
	        }
	   }catch(SQLException e){
	        System.out.println("Terjadi kesalahan dalam menghapus data transaksi");
	        }
	}

    private static void caridata () throws SQLException {
		String text5 = "\n===Cari Data Transaksi===";
		System.out.println(text5.toUpperCase());
		
		Scanner terimaInput = new Scanner (System.in);
				
		System.out.print("Masukkan Nama Barang : ");
        
		String keyword = terimaInput.nextLine();
        Statement statement = conn.createStatement();
        String sql = "SELECT * FROM transaksi WHERE nama_barang LIKE '%"+keyword+"%'";
        ResultSet result = statement.executeQuery(sql); 
                
        while(result.next()){
        	System.out.print("\nNo. Faktur\t: ");
            System.out.print(result.getString("no_faktur"));
            System.out.print("\nTanggal\t: ");
            System.out.print(result.getString("tanggal"));
            System.out.print("\nKasir\t: ");
            System.out.print(result.getString("kasir"));
            System.out.print("\nNama Barang\t: ");
            System.out.print(result.getString("nama_barang"));
            System.out.print("\nHarga Barang\t: ");
            System.out.print(result.getInt("harga_barang"));
            System.out.print("\nJumlah\t: ");
            System.out.print(result.getInt("jumlah"));
            System.out.print("\nSub Total\t: ");
            System.out.print(result.getInt("subtotal"));
            System.out.print("\nDiscount\t: ");
            System.out.print(result.getInt("discount"));
            System.out.print("\nTotal Harga\t: ");
            System.out.print(result.getInt("total_harga"));
            System.out.print("\n");
        }
	}
    
}

