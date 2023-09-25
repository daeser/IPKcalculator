import java.text.DecimalFormat;
import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.text.MutableAttributeSet;

public class Main {
	Scanner sc;
	Vector<String> MataPelajaran;
	Vector<Integer> SKS;
	Vector<Double> NilaiUTS ;
	Vector<Double> NilaiAssignment;
	Vector<Double> NilaiUAS;
	Vector<Double> NilaiAkhir;
	Vector<Double> PemTugas;
	Vector<Double> PemUTS;
	Vector<Double> PemUAS;
	Vector<Double> TotalNilai;
	
	Vector<Double> HasilNilai;
	Vector<String> MutuNilai;

	public Main() {
		sc = new Scanner(System.in);
		MataPelajaran = new Vector<>();
		SKS = new Vector<>();
		NilaiUTS = new Vector<>();
		NilaiAssignment = new Vector<>();
		NilaiUAS = new Vector<>();
		NilaiAkhir = new Vector<>();
		PemTugas = new Vector<>();
		PemUTS = new Vector<>();
		PemUAS = new Vector<>();
		TotalNilai = new Vector<>();
		HasilNilai = new Vector<>();
		MutuNilai = new Vector<>();
	}
	
	void run() {
		int choose;
		do {
		Menu();
		choose = scanInt();
		
		switch (choose) {
		case 1:
			InsertName();
			break;
		case 2:
			SettingPembagian();
			break;
		case 3:
			SortNilai();
			break;
		case 4:
			ViewScore();
			break;
			
		case 5:
			IPK();
			break;
		case 6:
			ViewMutu();
			break;
		case 7:
			System.out.println("Terima kasih !");
			break;
		default:
			System.out.println("Tolong pilih salah satu dari menu");
			break;
			}
		} while (choose != 7);
	}
	
//====================================================	
	void ViewMutu() {
		System.out.println(" ");
		System.out.println("+----------------------------------------------------------+");
		System.out.println("| Alphabetical Value | Beban | Score Akhir |   Deskripsi   |");
		System.out.println("+----------------------------------------------------------+");
		System.out.println("|          A         |   4   |  90 - 100   |   High        |");
		System.out.println("|          A-        |  3.67 |  85 - 89    | Distinction   |");
		System.out.println("|          B+        |  3.33 |  80 - 84    |               |");
		System.out.println("+--------------------+-------+-------------+---------------+");
		System.out.println("|          B         |  3    |  75 - 79    | Distinction   |");
		System.out.println("|          B-        |  2.5  |  70 - 74    |               |");
		System.out.println("+--------------------+-------+-------------+---------------+");
		System.out.println("|          C         |  2    |  65 - 69    |     Pass      |");
		System.out.println("+--------------------+-------+-------------+---------------+");
		System.out.println("|          D         |  1    |  50 - 64    |  Near Pass    |");
		System.out.println("+--------------------+-------+-------------+---------------+");
		System.out.println("|          E         |  0    |  0 - 49     |     Fail      |");
		System.out.println("+--------------------+-------+-------------+---------------+");
		System.out.println(" ");
		System.out.println("Tekan Enter Untuk Kembali Ke Menu...");
		sc.nextLine();
	}
	
//====================================================	
	void Menu() {
		System.out.println("Binus IPK Generator");
		System.out.println("===============");
		System.out.println("1. Masukkan Mata Pelajaran");
		System.out.println("2. Atur Pembagian Nilai");
		System.out.println("3. Sortir Nilai");
		System.out.println("4. Lihat Nilai Yang Telah Terinput");
		System.out.println("5. Lihat IPK");
		System.out.println("6. Lihat List Mutu Nilai");
		System.out.println("7. Exit");
		System.out.print("Pilih >> ");
	}
	
//====================================================
	static int search(Vector<String> test, String x)
    {
		{
		if (x.length() < 1 ||x.length() > 30) {
			return 420;
		}
		if (test.isEmpty()) {
			
        int n = test.size();
        for (int i = 0; i < n; i++) 
		        {
		            if (test.get(i).equals(x) != false)
		                return i;
		        }
        	return -1;
		}
		return -1;}
    }
	
//=========================================================
		static int searcht(Vector<String> test, String x)
	    {
			if (test.equals(x)) {
			}else {
	        int n = test.size();
	        for (int i = 0; i < n; i++) 
	        	{
	            if (test.get(i).equals(x) != false)
	                return i;
	        	}
			}
			return -3;
	    }
		
//=========================================================	
	void InsertName() {
		String Mapel = "";
		int SKS1;
		double Nilai, UTS, UAS;
		int s = 0;
		int z = 0;
		
		do {
		System.out.print("Nama Mata Pelajaran [1 - 30 huruf]: ");
		Mapel = sc.nextLine();
		s = search(MataPelajaran, Mapel);
		z = searcht(MataPelajaran, Mapel);
				if (s == 420) {
					System.out.println("Tidak Dapat Lebih Dari 30 Huruf");
					System.out.println("Dan Tidak Dapat Lebih Sedikit Dari 1 Huruf");
					}
				if (z >= 0) {
					System.out.println("Sudah Ada Nilai Tersebut Di Dalam List");
					}
				if (s <= -1 && z <= -1) {
					MataPelajaran.add(Mapel);
					}
		} while (Mapel.length() < 1 || Mapel.length() > 30 && s == 420 || z >= 0);
		
		do {
			System.out.print("Masukkan SKS (1 - 10): ");
			SKS1 = scanInt();
		} while (SKS1 <= 0 || SKS1 >= 11);
		
		do {
			System.out.print("Masukkan Nilai Tugas (0 - 100): ");
			Nilai = scanDouble();
		} while (Nilai < 0 || Nilai >= 101);
		
		do {
			System.out.print("Masukkan Nilai UTS (0 - 100): ");
			UTS = scanDouble();	
		} while (UTS < 0 || UTS >= 101);	
		
		do {
			System.out.print("Masukkan Nilai UAS (0 - 100): ");
			UAS = scanDouble();
		} while (UAS < 0 || UAS >= 101);
		
		double TotNilai = UTS + UAS + Nilai;
		double TotTugas = 0; 
		double TotUAS = 0;
		double TotUTS = 0;
		double HasilSemuas = 0;
		NilaiUTS.add(UTS);
		NilaiUAS.add(UAS);
		NilaiAssignment.add(Nilai);
		SKS.add(SKS1);
		PemTugas.add(TotTugas);
		PemUAS.add(TotUAS);
		PemUTS.add(TotUTS);
		HasilNilai.add(HasilSemuas);
		TotalNilai.add(TotNilai);
		System.out.println(" ");
		System.out.println("Nilai telah terinput");
		System.out.println("Tolong Setting Nilai Anda !");
		System.out.println("Tekan Enter Untuk Kembali Ke Menu...");
		sc.nextLine();
	}
	
//====================================================
	void SettingPembagian() {
		if (MataPelajaran.isEmpty()) {
			System.out.println("+----------------------------------+");
			System.out.println("| Tolong Masukkan 1 Mata Pelajaran |");
			System.out.println("+----------------------------------+");
		}else {
		ViewScore ();
		String pilih = "";
		int c = 0;
		
		do {
		System.out.print("Nama dari Nilai Mata Pelajaran Yang ingin diatur : ");
		pilih = sc.nextLine();
		c = searcht(MataPelajaran, pilih);
		} while (c <= -1);
		
		double totalsemua = 0;
		double tempUTS,tempTugas, tempUAS, TotUTS, TotTugas, TotUAS;
		do {
			System.out.println("Tolong Masukan Pembagian Nilai Anda");
			System.out.println("+--------------------------------------+");
			System.out.println("| Contoh = UTS 30%, Tugas 20%, UAS 50% |");
			System.out.println("+-------------------------------------------------------+");
			System.out.println("| Jika Proses Terulang, total semua nilai tidaklah 100% |");
			System.out.println("+-------------------------------------------------------+");
				do {
				System.out.print("Pembagian Nilai Tugas (0 - 100): ");
					tempTugas = scanDouble();
					TotTugas = tempTugas / 100;
				} while (tempTugas < 0 || tempTugas > 100);
				
				do {
					System.out.print("Pembagian Nilai UTS (0 - 100): ");
					tempUTS = scanDouble();
					TotUTS = tempUTS / 100;
				} while (tempUTS < 0 || tempUTS > 100);
				
				do {
					System.out.print("Pembagian Nilai UAS (0 - 100): ");
					tempUAS = scanDouble();
					TotUAS = tempUAS / 100;
				} while (tempUAS < 0 || tempUTS > 100);
				
			totalsemua = TotTugas + TotUTS + TotUAS;
			System.out.println("Total Pembagian Anda : " + totalsemua + " / 1.0 " + " atau " + (tempTugas + tempUAS + tempUTS) + "%" + " / " + "100.0%");
			System.out.println(" ");
			} while (totalsemua != 1);
		PemTugas.set(c, TotTugas);
		PemUAS.set(c, TotUAS);
		PemUTS.set(c, TotUTS);
		
		double HasilSemua = ((NilaiAssignment.get(c)*TotTugas) + (NilaiUTS.get(c)*TotUTS) + (NilaiUAS.get(c) * TotUAS));
		HasilNilai.set(c, HasilSemua);
			if (MutuNilai.isEmpty()) {
				MutuNilai.add("A");
				
				System.out.println("Hasil");
				System.out.println("===========================");
				System.out.println("Mata Pelajaran 	      : " + pilih);
				System.out.println("Pembagian Nilai Tugas : " + PemTugas.get(c));
				System.out.println("Pembagian Nilai	UTS   : " + PemUTS.get(c));
				System.out.println("Pembagian Nilai UAS   : " + PemUAS.get(c));
				System.out.println("===========================");
				System.out.println(" ");
				System.out.println("Tekan Enter Untuk Kembali ke menu...");
				sc.nextLine();
			}else {
				
			System.out.println("Hasil");
			System.out.println("===========================");
			System.out.println("Mata Pelajaran 	      : " + pilih);
			System.out.println("Pembagian Nilai Tugas : " + PemTugas.get(c));
			System.out.println("Pembagian Nilai	UTS   : " + PemUTS.get(c));
			System.out.println("Pembagian Nilai UAS   : " + PemUAS.get(c));
			System.out.println("===========================");
			System.out.println(" ");
			System.out.println("Tekan Enter Untuk Kembali ke menu...");
			sc.nextLine();
				}
		}
	}
	
//====================================================
	
	void SortNilai() {
		int pilih = 0;
		
		if (MataPelajaran.isEmpty()) {
			System.out.println("+----------------------------------+");
			System.out.println("| Tolong Masukkan 1 Mata Pelajaran |");
			System.out.println("+----------------------------------+");
		}else {
			
		do {
			System.out.println("Menu Sorting (Menurut ASCII Untuk Nama)");
			System.out.println("=============");
			System.out.println("1. Sortir dari Nama [Ascending]");
			System.out.println("2. Sortir dari Nama [Descending]");
			System.out.println("3. Sortir dari Nilai [Ascending]");
			System.out.println("4. Sortir dari Nilai [Descending]");
			System.out.println("5. Exit");
			System.out.print("Pilih >> ");
			pilih = scanInt();
			switch (pilih) {
						case 1:
							for (int i = 0; i < MataPelajaran.size(); i++) {
								for (int j = i+1; j < MataPelajaran.size(); j++) {
									String MataPelajaranTemp = MataPelajaran.get(i);
									String MataPelajaranTemp2 = MataPelajaran.get(j);
									char R = MataPelajaranTemp.charAt(0);
									char L = MataPelajaranTemp2.charAt(0);
									if (R > L) {
										String MataPelajaranTempA = MataPelajaran.get(i);
										int SKSTempA = SKS.get(i);
										double UTSTempA = NilaiUTS.get(i);
										double UASTempA = NilaiUAS.get(i);
										double TugasTempA = NilaiAssignment.get(i);
										double Tugas = PemTugas.get(i);
										double UAS = PemUAS.get(i);
										double UTS = PemUTS.get(i);
										double TotNilai = TotalNilai.get(i);
										double Hasil = HasilNilai.get(i);
										
										MataPelajaran.set(i, MataPelajaran.get(j));
										SKS.set(i, SKS.get(j));
										NilaiUTS.set(i, NilaiUTS.get(j));
										NilaiUAS.set(i, NilaiUAS.get(j));
										NilaiAssignment.set(i, NilaiAssignment.get(j));
										PemTugas.set(i, PemTugas.get(j));
										PemUAS.set(i, PemUAS.get(j));
										PemUTS.set(i, PemUTS.get(j));
										TotalNilai.set(i, TotalNilai.get(j));
										HasilNilai.set(i, HasilNilai.get(j));
										
										MataPelajaran.set(j, MataPelajaranTempA);
										SKS.set(j, SKSTempA);
										NilaiUTS.set(j, UTSTempA);
										NilaiUAS.set(j, UASTempA);
										NilaiAssignment.set(j, TugasTempA);
										PemTugas.set(j, Tugas);
										PemUAS.set(j, UAS);
										PemUTS.set(j, UTS);
										TotalNilai.set(j, TotNilai);
										HasilNilai.set(j, Hasil);
										
									}
								}
							}
							System.out.println("Berhasil Tersortir Berdasarkan Nama (Ascending)");
							System.out.println("===============================================");
							System.out.println("Tabel Terbaru : ");
							ViewScore();
							System.out.println("Tekan Enter Untuk Kembali...");
							sc.nextLine();
							
							break;
						case 2:
							for (int i = 0; i < MataPelajaran.size(); i++) {
								for (int j = i+1; j < MataPelajaran.size(); j++) {
									String MataPelajaranTemp = MataPelajaran.get(i);
									String MataPelajaranTemp2 = MataPelajaran.get(j);
									char R = MataPelajaranTemp.charAt(0);
									char L = MataPelajaranTemp2.charAt(0);
									if (R < L) {
										String MataPelajaranTempA = MataPelajaran.get(i);
										int SKSTempA = SKS.get(i);
										double UTSTempA = NilaiUTS.get(i);
										double UASTempA = NilaiUAS.get(i);
										double TugasTempA = NilaiAssignment.get(i);
										double Tugas = PemTugas.get(i);
										double UAS = PemUAS.get(i);
										double UTS = PemUTS.get(i);
										double TotNilai = TotalNilai.get(i);
										double Hasil = HasilNilai.get(i);
										
										MataPelajaran.set(i, MataPelajaran.get(j));
										SKS.set(i, SKS.get(j));
										NilaiUTS.set(i, NilaiUTS.get(j));
										NilaiUAS.set(i, NilaiUAS.get(j));
										NilaiAssignment.set(i, NilaiAssignment.get(j));
										PemTugas.set(i, PemTugas.get(j));
										PemUAS.set(i, PemUAS.get(j));
										PemUTS.set(i, PemUTS.get(j));
										TotalNilai.set(i, TotalNilai.get(j));
										HasilNilai.set(i, HasilNilai.get(j));
										
										MataPelajaran.set(j, MataPelajaranTempA);
										SKS.set(j, SKSTempA);
										NilaiUTS.set(j, UTSTempA);
										NilaiUAS.set(j, UASTempA);
										NilaiAssignment.set(j, TugasTempA);
										PemTugas.set(j, Tugas);
										PemUAS.set(j, UAS);
										PemUTS.set(j, UTS);
										TotalNilai.set(j, TotNilai);
										HasilNilai.set(j, Hasil);
										
									}
								}
							}
							System.out.println("Berhasil Tersortir Berdasarkan Nama (Descending)");
							System.out.println("===============================================");
							System.out.println("Tabel Terbaru : ");
							ViewScore();
							System.out.println("Tekan Enter Untuk Kembali...");
							sc.nextLine();
							
							break;
						case 3:
							for (int i = 0; i < MataPelajaran.size(); i++) {
								for (int j = i+1; j < MataPelajaran.size(); j++) {
									 if (TotalNilai.get(i) > TotalNilai.get(j) ) {
										 String MataPelajaranTempA = MataPelajaran.get(i);
											int SKSTempA = SKS.get(i);
											double UTSTempA = NilaiUTS.get(i);
											double UASTempA = NilaiUAS.get(i);
											double TugasTempA = NilaiAssignment.get(i);
											double Tugas = PemTugas.get(i);
											double UAS = PemUAS.get(i);
											double UTS = PemUTS.get(i);
											double TotNilai = TotalNilai.get(i);
											double Hasil = HasilNilai.get(i);
											
											MataPelajaran.set(i, MataPelajaran.get(j));
											SKS.set(i, SKS.get(j));
											NilaiUTS.set(i, NilaiUTS.get(j));
											NilaiUAS.set(i, NilaiUAS.get(j));
											NilaiAssignment.set(i, NilaiAssignment.get(j));
											PemTugas.set(i, PemTugas.get(j));
											PemUAS.set(i, PemUAS.get(j));
											PemUTS.set(i, PemUTS.get(j));
											TotalNilai.set(i, TotalNilai.get(j));
											HasilNilai.set(i, HasilNilai.get(j));
											
											MataPelajaran.set(j, MataPelajaranTempA);
											SKS.set(j, SKSTempA);
											NilaiUTS.set(j, UTSTempA);
											NilaiUAS.set(j, UASTempA);
											NilaiAssignment.set(j, TugasTempA);
											PemTugas.set(j, Tugas);
											PemUAS.set(j, UAS);
											PemUTS.set(j, UTS);
											TotalNilai.set(j, TotNilai);
											HasilNilai.set(j, Hasil);
									}
								}
							}
							System.out.println("Berhasil Tersortir Berdasarkan Nilai (Ascending)");
							System.out.println("===============================================");
							System.out.println("Tabel Terbaru : ");
							ViewScore();
							System.out.println("Tekan Enter Untuk Kembali...");
							sc.nextLine();
							break;
						case 4:
							for (int i = 0; i < MataPelajaran.size(); i++) {
								for (int j = i+1; j < MataPelajaran.size(); j++) {
									 if (TotalNilai.get(i) < TotalNilai.get(j) ) {
										 String MataPelajaranTempA = MataPelajaran.get(i);
											int SKSTempA = SKS.get(i);
											double UTSTempA = NilaiUTS.get(i);
											double UASTempA = NilaiUAS.get(i);
											double TugasTempA = NilaiAssignment.get(i);
											double Tugas = PemTugas.get(i);
											double UAS = PemUAS.get(i);
											double UTS = PemUTS.get(i);
											double TotNilai = TotalNilai.get(i);
											double Hasil = HasilNilai.get(i);
											
											MataPelajaran.set(i, MataPelajaran.get(j));
											SKS.set(i, SKS.get(j));
											NilaiUTS.set(i, NilaiUTS.get(j));
											NilaiUAS.set(i, NilaiUAS.get(j));
											NilaiAssignment.set(i, NilaiAssignment.get(j));
											PemTugas.set(i, PemTugas.get(j));
											PemUAS.set(i, PemUAS.get(j));
											PemUTS.set(i, PemUTS.get(j));
											TotalNilai.set(i, TotalNilai.get(j));
											HasilNilai.set(i, HasilNilai.get(j));
											
											MataPelajaran.set(j, MataPelajaranTempA);
											SKS.set(j, SKSTempA);
											NilaiUTS.set(j, UTSTempA);
											NilaiUAS.set(j, UASTempA);
											NilaiAssignment.set(j, TugasTempA);
											PemTugas.set(j, Tugas);
											PemUAS.set(j, UAS);
											PemUTS.set(j, UTS);
											TotalNilai.set(j, TotNilai);
											HasilNilai.set(j, Hasil);
									}
								}
							}
							System.out.println("Berhasil Tersortir Berdasarkan Nilai (Descending)");
							System.out.println("===============================================");
							System.out.println("Tabel Terbaru : ");
							ViewScore();
							System.out.println("Tekan Enter Untuk Kembali...");
							sc.nextLine();
							break;
						case 5:
							System.out.println("Sedang Kembali ke Menu...");
							System.out.println(" ");
							break;
						default:
							System.out.println("Tolong pilih salah satu dari opsi");
							break;
						}
					} while (pilih != 5);
		}
	}
	
//====================================================
	void IPK () {
		if (MutuNilai.isEmpty()) {
			System.out.println("+----------------------------------+");
			System.out.println("|     Tolong Atur 1 Pelajaran !    |");
			System.out.println("+----------------------------------+");
		}else {
			
			DecimalFormat df = new DecimalFormat("#.00"); 
			String format = "| %-2d | %-30s | %-3d | %-11s | %-9s | %-9s | %-15s | %-21s | %-10s |%n";
			System.out.format("+----+--------------------------------+-----+-------------+-----------+-----------+-----------------+-----------------------+------------+%n");
			System.out.format("| No |          Mata Pelajaran        | SKS | Nilai Tugas | Nilai UTS | Nilai UAS | Nilai Rata-Rata | Hasil Pembagian Nilai | Mutu Nilai |%n");
			System.out.format("+----+--------------------------------+-----+-------------+-----------+-----------+-----------------+-----------------------+------------+%n");
			for (int i = 0; i < MataPelajaran.size(); i++) {
				double temptugas = NilaiAssignment.get(i);
				double tempUTS = NilaiUTS.get(i);
				double tempUAS = NilaiUAS.get(i);
				double tempTotal = TotalNilai.get(i) / 3;
				double tempHNilai = HasilNilai.get(i);
				String Mutu = "";
				if (tempHNilai < 0 || tempHNilai > 49.99 != true) {
					Mutu = "E";
				}else if (tempHNilai < 50 || tempHNilai > 64.99 != true) {
					Mutu = "D";
				} else if (tempHNilai < 65 || tempHNilai > 69.99 != true) {
					Mutu = "C";
				}else if (tempHNilai < 70 || tempHNilai > 74.99  != true) {
					Mutu = "B-";
				}else if (tempHNilai < 75 || tempHNilai > 79.99  != true){
					Mutu = "B";
				}else if (tempHNilai < 80 || tempHNilai > 84.99 != true) {
					Mutu = "B+";
				}else if (tempHNilai < 85 || tempHNilai > 89.99 != true) {
					Mutu = "A-";
				}else if (tempHNilai < 90 || tempHNilai > 100 != true) {
					Mutu = "A";
				}
				String tugas = df.format(temptugas);
				String UTS = df.format(tempUTS);
				String UAS = df.format(tempUAS);
				String Hnilai = df.format(tempHNilai);
				String total = df.format(tempTotal);
				System.out.format(format ,(i+1) , MataPelajaran.get(i) , SKS.get(i),temptugas, UTS, UAS, total , Hnilai, Mutu);
			}
			System.out.format("+----+--------------------------------+-----+-------------+-----------+-----------+-----------------+-----------------------+------------+%n");
			System.out.println("+-------------------------------------------+");
			System.out.println("| Nilai IPK = Bobot Nilai x SKS / Total SKS |");
			System.out.println("+-------------------------------------------+");
			double IPKas = 0;
			double IPKax = 0;
			int SKSas = 0;
			
			for (int i = 0; i < MataPelajaran.size(); i++) {
				double tempHNilai = HasilNilai.get(i);
				String Mutu = "";
				double Weight = 0;
				int SKS1 = SKS.get(i);
				
				
				if (tempHNilai < 0 || tempHNilai > 49.99 != true) {
					Mutu = "E";
				}else if (tempHNilai < 50 || tempHNilai > 64.99 != true) {
					Mutu = "D";
				} else if (tempHNilai < 65 || tempHNilai > 69.99 != true) {
					Mutu = "C";
				}else if (tempHNilai < 70 || tempHNilai > 74.99  != true) {
					Mutu = "B-";
				}else if (tempHNilai < 75 || tempHNilai > 79.99  != true){
					Mutu = "B";
				}else if (tempHNilai < 80 || tempHNilai > 84.99 != true) {
					Mutu = "B+";
				}else if (tempHNilai < 85 || tempHNilai > 89.99 != true) {
					Mutu = "A-";
				}else if (tempHNilai < 90 || tempHNilai > 100 != true) {
					Mutu = "A";
				}
				if (Mutu.equals("E")) {
					Weight = 0;
				}else if (Mutu.equals("D")) {
					Weight = 1;
				}else if (Mutu.equals("C")) {
					Weight = 2;
				}else if (Mutu.equals("B-")) {
					Weight = 2.5;
				}else if (Mutu.equals("B")) {
					Weight = 3;
				}else if (Mutu.equals("B+")) {
					Weight = 3.33;
				}else if (Mutu.equals("A-")) {
					Weight = 3.67;
				}else if (Mutu.equals("A")) {
					Weight = 4;
				}
				
				SKSas += SKS1;
				IPKas = ((Weight*SKS1));
				IPKax += IPKas;	
			}
			double tempKax;
			tempKax = (IPKax / SKSas);
			String Kax = df.format(tempKax);
			System.out.println("Total SKS : " + SKSas);
			System.out.println("IPK : " + Kax);
			System.out.println(" ");
			System.out.println("Tekan Enter Untuk Kembali Ke Menu...");
			sc.nextLine();
		}
			
	}
//====================================================
	void ViewScore() {
		if (MataPelajaran.isEmpty()) {
			System.out.println("+----------------------------------+");
			System.out.println("| Tolong Masukkan 1 Mata Pelajaran |");
			System.out.println("+----------------------------------+");
		}else if (MutuNilai.isEmpty()) {
			DecimalFormat df = new DecimalFormat("#.00"); 
			String format = "| %-2d | %-30s | %-3d | %-11s | %-9s | %-9s | %-15s |%n";
			System.out.format("+----+--------------------------------+-----+-------------+-----------+-----------+-----------------+%n");
			System.out.format("| No |          Mata Pelajaran        | SKS | Nilai Tugas | Nilai UTS | Nilai UAS | Nilai Rata-Rata |%n");
			System.out.format("+----+--------------------------------+-----+-------------+-----------+-----------+-----------------+%n");
			for (int i = 0; i < MataPelajaran.size(); i++) {
				double temptugas = NilaiAssignment.get(i);
				double tempUTS = NilaiUTS.get(i);
				double tempUAS = NilaiUAS.get(i);
				double tempTotal = TotalNilai.get(i) / 3;
				double tempHNilai = HasilNilai.get(i); 
				String tugas = df.format(temptugas);
				String UTS = df.format(tempUTS);
				String UAS = df.format(tempUAS);
				String Hnilai = df.format(tempHNilai);
				String total = df.format(tempTotal);
				System.out.format(format ,(i+1) , MataPelajaran.get(i) , SKS.get(i),temptugas, UTS, UAS, total);
			}
			System.out.format("+----+--------------------------------+-----+-------------+-----------+-----------+-----------------+%n");
		}else {
			
		DecimalFormat df = new DecimalFormat("#.00"); 
		String format = "| %-2d | %-30s | %-3d | %-11s | %-9s | %-9s | %-15s | %-21s | %-10s |%n";
		System.out.format("+----+--------------------------------+-----+-------------+-----------+-----------+-----------------+-----------------------+------------+%n");
		System.out.format("| No |          Mata Pelajaran        | SKS | Nilai Tugas | Nilai UTS | Nilai UAS | Nilai Rata-Rata | Hasil Pembagian Nilai | Mutu Nilai |%n");
		System.out.format("+----+--------------------------------+-----+-------------+-----------+-----------+-----------------+-----------------------+------------+%n");
		for (int i = 0; i < MataPelajaran.size(); i++) {
			double temptugas = NilaiAssignment.get(i);
			double tempUTS = NilaiUTS.get(i);
			double tempUAS = NilaiUAS.get(i);
			double tempTotal = TotalNilai.get(i) / 3;
			double tempHNilai = HasilNilai.get(i);
			String Mutu = "";
			if (tempHNilai < 0 || tempHNilai > 49.99 != true) {
				Mutu = "E";
			}else if (tempHNilai < 50 || tempHNilai > 64.99 != true) {
				Mutu = "D";
			} else if (tempHNilai < 65 || tempHNilai > 69.99 != true) {
				Mutu = "C";
			}else if (tempHNilai < 70 || tempHNilai > 74.99  != true) {
				Mutu = "B-";
			}else if (tempHNilai < 75 || tempHNilai > 79.99  != true){
				Mutu = "B";
			}else if (tempHNilai < 80 || tempHNilai > 84.99 != true) {
				Mutu = "B+";
			}else if (tempHNilai < 85 || tempHNilai > 89.99 != true) {
				Mutu = "A-";
			}else if (tempHNilai < 90 || tempHNilai > 100 != true) {
				Mutu = "A";
			}
			String tugas = df.format(temptugas);
			String UTS = df.format(tempUTS);
			String UAS = df.format(tempUAS);
			String Hnilai = df.format(tempHNilai);
			String total = df.format(tempTotal);
			System.out.format(format ,(i+1) , MataPelajaran.get(i) , SKS.get(i),temptugas, UTS, UAS, total , Hnilai, Mutu);
		}
		System.out.format("+----+--------------------------------+-----+-------------+-----------+-----------+-----------------+-----------------------+------------+%n");
	}
}
	
//====================================================
	
	double scanDouble() {
		String test = sc.nextLine();
		double pilih = 0;
			
		try {
			pilih = Double.parseDouble(test);
		} catch (Exception e) {
			System.out.println("Input harus angka");
			}
		return pilih;	
	}
	
	int scanInt() {
		int pilih;
		try {
			pilih = sc.nextInt();
		} catch (Exception e) {
			System.out.println("Input harus angka");
			pilih = Integer.MIN_VALUE;
		}
		sc.nextLine();
		return pilih;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main main = new Main();
		main.run();
	}
}
