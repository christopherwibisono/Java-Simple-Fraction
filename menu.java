package menu;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;

public class menu{
	ArrayList<hasil> hs = new ArrayList<hasil>();
	Integer totaldata = 0;
	String inides;
	String inipec;
	String inicamp;
	String tothread;
	public menu() {
		Scanner scan = new Scanner(System.in);
		String menu;
		DecimalFormat df =  new DecimalFormat("#.##");
		int exit = 0;
		do {
			System.out.println("Thank You For Using This Application!");
			System.out.println("Christopher Wibisono - 2301913822");
			System.out.println("Start Menu");
			System.out.println("1. Add Fraction");
			System.out.println("2. Update Fraction");
			System.out.println("3. View Fraction");
			System.out.println("4. Compare Data");
			System.out.println("5. Start Threading");
			System.out.println("0. Exit");
			System.out.print("Input [Menu Choice] : ");
			menu = scan.nextLine();
			if (menu.equals("1"))
			{
				inides = null;
				inipec = null;
				inicamp = null;
				System.out.print("Input [Fraction Type] : ");
				String input = scan.nextLine();
				Fraction fr = new Fraction(input) {};
				inides = fr.hl.substring(0, fr.hl.indexOf("|"));
				inipec = fr.hl.substring(fr.hl.indexOf("|")+1, fr.hl.indexOf(";"));
				inicamp = fr.hl.substring(fr.hl.indexOf(";")+1, fr.hl.length());
				hasil ha = new hasil(inides,inipec,inicamp);
				hs.add(ha);
				totaldata++;
			}
			else if (menu.equals("2"))
			{
				if(totaldata == 0)
				{
					System.out.println("No data available.");
				}
				else
				{
					Integer ctr = 0;
					Integer idx;
					while(ctr != totaldata)
					{
						System.out.println("Data " + (ctr+1));
						System.out.println("Desimal : " + hs.get(ctr).getDesimal());
						System.out.println("Pecahan : " + hs.get(ctr).getPecahan());
						System.out.println("Campuran : " + hs.get(ctr).getCampuran());
						ctr++;
					}
					System.out.print("Data to be updated [index] : ");
					idx = scan.nextInt(); scan.nextLine();
					idx-=1;
					inides = hs.get(idx).getDesimal();
					inipec = hs.get(idx).getPecahan();
					inicamp = hs.get(idx).getCampuran();
					String ubah = (inides + "\n" + inipec + "\n" + inicamp);
					System.out.println("Chosen Data : ");
					System.out.println(ubah);
					System.out.println("Update data menu");
					System.out.println("1. Add");
					System.out.println("2. Subtract");
					System.out.println("3. Multiply");
					System.out.println("4. Divide");
					ubah = (inides + "|" + inipec + ";" + inicamp);
					System.out.print("Input [Menu Choice] : ");
					int pil = scan.nextInt(); scan.nextLine();
					if(pil == 1)
					{
						int option;
						System.out.println("Option 1 : Insert another fraction to update");
						System.out.println("Option 2 : Add the existing fraction to update");
						System.out.print("Your Option : ");
						option = scan.nextInt(); scan.nextLine();
						if (option == 1)
						{
							System.out.print("Add [Fraction Type] : ");
							String tambah = scan.nextLine();
							Fraction fr = new Fraction(tambah) {};
							fr.tambah(fr.hl,ubah);
							inides = fr.hx.substring(0, fr.hx.indexOf("|"));
							inipec = fr.hx.substring(fr.hx.indexOf("|")+1, fr.hx.indexOf(";"));
							inicamp = fr.hx.substring(fr.hx.indexOf(";")+1, fr.hx.length());
							
						}
						else if (option == 2)
						{
							ctr = 0;
							while(ctr != totaldata)
							{
								System.out.println("Data " + (ctr+1));
								System.out.println("Desimal : " + hs.get(ctr).getDesimal());
								System.out.println("Pecahan : " + hs.get(ctr).getPecahan());
								System.out.println("Campuran : " + hs.get(ctr).getCampuran());
								ctr++;
							}
							System.out.print("Choose data to be updated with [index] : ");
							int idxu = scan.nextInt(); scan.nextLine();
							idxu-=1;
							decimal d2 = new decimal();
							d2.add(hs.get(idx).getDesimal(), hs.get(idxu).getDesimal());
							inides = (df.format(d2.has1) + "");
							proper p2 = new proper();
							p2.add(hs.get(idx).getPecahan(), hs.get(idxu).getPecahan());
							inipec = (p2.has2a + "/" + p2.has2b);
							mixed m2 = new mixed();
							m2.add(hs.get(idx).getCampuran(), hs.get(idxu).getCampuran());
							if(m2.has3x > 0)
								inicamp = (m2.has3x + " " + m2.has3a + "/" + m2.has3b);
							else
								inicamp = (m2.has3a + "/" + m2.has3b);
						}
						hs.get(idx).setDesimal(inides);
						hs.get(idx).setPecahan(inipec);
						hs.get(idx).setCampuran(inicamp);
					}
					else if(pil == 2)
					{
						int option;
						System.out.println("Option 1 : Insert another fraction to update");
						System.out.println("Option 2 : Add the existing fraction to update");
						System.out.print("Your Option : ");
						option = scan.nextInt(); scan.nextLine();
						if (option == 1)
						{
							System.out.print("Add [Fraction Type] : ");
							String tambah = scan.nextLine();
							Fraction fr = new Fraction(tambah) {};
							fr.kurang(fr.hl,ubah);
							inides = fr.hx.substring(0, fr.hx.indexOf("|"));
							inipec = fr.hx.substring(fr.hx.indexOf("|")+1, fr.hx.indexOf(";"));
							inicamp = fr.hx.substring(fr.hx.indexOf(";")+1, fr.hx.length());
							
						}
						else if (option == 2)
						{
							ctr = 0;
							while(ctr != totaldata)
							{
								System.out.println("Data " + (ctr+1));
								System.out.println("Desimal : " + hs.get(ctr).getDesimal());
								System.out.println("Pecahan : " + hs.get(ctr).getPecahan());
								System.out.println("Campuran : " + hs.get(ctr).getCampuran());
								ctr++;
							}
							System.out.print("Choose data to be updated with [index] : ");
							int idxu = scan.nextInt(); scan.nextLine();
							idxu-=1;
							decimal d2 = new decimal();
							d2.subtract(hs.get(idx).getDesimal(), hs.get(idxu).getDesimal());
							inides = (df.format(d2.has1) + "");
							proper p2 = new proper();
							p2.subtract(hs.get(idx).getPecahan(), hs.get(idxu).getPecahan());
							inipec = (p2.has2a + "/" + p2.has2b);
							mixed m2 = new mixed();
							m2.subtract(hs.get(idx).getCampuran(), hs.get(idxu).getCampuran());
							if(m2.has3x > 0)
								inicamp = (m2.has3x + " " + m2.has3a + "/" + m2.has3b);
							else
								inicamp = (m2.has3a + "/" + m2.has3b);
						}
						hs.get(idx).setDesimal(inides);
						hs.get(idx).setPecahan(inipec);
						hs.get(idx).setCampuran(inicamp);
					}
					else if(pil == 3)
					{
						int option;
						System.out.println("Option 1 : Insert another fraction to update");
						System.out.println("Option 2 : Add the existing fraction to update");
						System.out.print("Your Option : ");
						option = scan.nextInt(); scan.nextLine();
						if (option == 1)
						{
							System.out.print("Add [Fraction Type] : ");
							String tambah = scan.nextLine();
							Fraction fr = new Fraction(tambah) {};
							fr.kali(fr.hl,ubah);
							inides = fr.hx.substring(0, fr.hx.indexOf("|"));
							inipec = fr.hx.substring(fr.hx.indexOf("|")+1, fr.hx.indexOf(";"));
							inicamp = fr.hx.substring(fr.hx.indexOf(";")+1, fr.hx.length());
							
						}
						else if (option == 2)
						{
							ctr = 0;
							while(ctr != totaldata)
							{
								System.out.println("Data " + (ctr+1));
								System.out.println("Desimal : " + hs.get(ctr).getDesimal());
								System.out.println("Pecahan : " + hs.get(ctr).getPecahan());
								System.out.println("Campuran : " + hs.get(ctr).getCampuran());
								ctr++;
							}
							System.out.print("Choose data to be updated with [index] : ");
							int idxu = scan.nextInt(); scan.nextLine();
							idxu-=1;
							decimal d2 = new decimal();
							d2.multiply(hs.get(idx).getDesimal(), hs.get(idxu).getDesimal());
							inides = (df.format(d2.has1) + "");
							proper p2 = new proper();
							p2.multiply(hs.get(idx).getPecahan(), hs.get(idxu).getPecahan());
							inipec = (p2.has2a + "/" + p2.has2b);
							mixed m2 = new mixed();
							m2.multiply(hs.get(idx).getCampuran(), hs.get(idxu).getCampuran());
							if(m2.has3x > 0)
								inicamp = (m2.has3x + " " + m2.has3a + "/" + m2.has3b);
							else
								inicamp = (m2.has3a + "/" + m2.has3b);
						}
						hs.get(idx).setDesimal(inides);
						hs.get(idx).setPecahan(inipec);
						hs.get(idx).setCampuran(inicamp);
					}
					else if(pil == 4)
					{
						int option;
						System.out.println("Option 1 : Insert another fraction to update");
						System.out.println("Option 2 : Add the existing fraction to update");
						System.out.print("Your Option : ");
						option = scan.nextInt(); scan.nextLine();
						if (option == 1)
						{
							System.out.print("Add [Fraction Type] : ");
							String tambah = scan.nextLine();
							Fraction fr = new Fraction(tambah) {};
							fr.bagi(fr.hl,ubah);
							inides = fr.hx.substring(0, fr.hx.indexOf("|"));
							inipec = fr.hx.substring(fr.hx.indexOf("|")+1, fr.hx.indexOf(";"));
							inicamp = fr.hx.substring(fr.hx.indexOf(";")+1, fr.hx.length());
							
						}
						else if (option == 2)
						{
							ctr = 0;
							while(ctr != totaldata)
							{
								System.out.println("Data " + (ctr+1));
								System.out.println("Desimal : " + hs.get(ctr).getDesimal());
								System.out.println("Pecahan : " + hs.get(ctr).getPecahan());
								System.out.println("Campuran : " + hs.get(ctr).getCampuran());
								ctr++;
							}
							System.out.print("Choose data to be updated with [index] : ");
							int idxu = scan.nextInt(); scan.nextLine();
							idxu-=1;
							decimal d2 = new decimal();
							d2.divide(hs.get(idx).getDesimal(), hs.get(idxu).getDesimal());
							inides = (df.format(d2.has1) + "");
							proper p2 = new proper();
							p2.divide(hs.get(idx).getPecahan(), hs.get(idxu).getPecahan());
							inipec = (p2.has2a + "/" + p2.has2b);
							mixed m2 = new mixed();
							m2.divide(hs.get(idx).getCampuran(), hs.get(idxu).getCampuran());
							if(m2.has3x > 0)
								inicamp = (m2.has3x + " " + m2.has3a + "/" + m2.has3b);
							else
								inicamp = (m2.has3a + "/" + m2.has3b);
						}
						hs.get(idx).setDesimal(inides);
						hs.get(idx).setPecahan(inipec);
						hs.get(idx).setCampuran(inicamp);
					}
					else System.out.println("Invalid input.");
				}
			}
			else if (menu.equals("3"))
			{
				Integer ctr = 0;
				while(ctr != totaldata)
				{
					System.out.println("Data " + (ctr+1));
					System.out.println("Desimal : " + hs.get(ctr).getDesimal());
					System.out.println("Pecahan : " + hs.get(ctr).getPecahan());
					System.out.println("Campuran : " + hs.get(ctr).getCampuran());
					ctr++;
				}
			}
			else if (menu.equals("4"))
			{
				System.out.println("1. Comparing from a new input");
				System.out.println("2. Comparing from existing data");
				System.out.print("Input : ");
				int choose = scan.nextInt(); scan.nextLine();
				if (choose == 1)
				{
					System.out.print("First data to compare [Fraction Type] : ");
					String first = scan.nextLine();
					System.out.print("Second data to compare [Fraction Type] : ");
					String second = scan.nextLine();
					Fraction frst = new Fraction(first) {};
					Fraction scnd = new Fraction(second) {};
					String d1 = frst.hl.substring(0,frst.hl.indexOf('|'));
					String d2 = scnd.hl.substring(0,scnd.hl.indexOf('|'));
					compare(d1,d2,first,second);
				}
				else if (choose == 2 && totaldata >= 1)
				{
					Integer ctr = 0;
					while(ctr != totaldata)
					{
						System.out.println("Data " + (ctr+1));
						System.out.println("Desimal : " + hs.get(ctr).getDesimal());
						System.out.println("Pecahan : " + hs.get(ctr).getPecahan());
						System.out.println("Campuran : " + hs.get(ctr).getCampuran());
						ctr++;
					}
					int firstid;
					do
					{
						try {
							System.out.print("Desired data to compare [index first data] : ");
							firstid = scan.nextInt();
						} catch (Exception e) {
							firstid = -1;
						}
						scan.nextLine();
					} while (firstid > totaldata && firstid < 0);
					String decimal1 = hs.get(firstid-1).getDesimal();
					int secondid;
					do
					{
						try {
							System.out.print("Desired data to compare [index second data] : ");
							secondid = scan.nextInt();
						} catch (Exception e) {
							secondid = -1;
						}
						scan.nextLine();
					} while (secondid > totaldata && secondid < 0);
					String decimal2 = hs.get(secondid-1).getDesimal();
					compare(decimal1, decimal2, decimal1, decimal2);
				}
			}
			else if (menu.equals("5"))
			{
				System.out.println("1. Choose from existing data to start thread");
				System.out.println("2. Input new data to start thread");
				System.out.print("Choose : ");
				int choose = scan.nextInt(); scan.nextLine();
				if (choose == 1)
				{
					if(totaldata == 0)
					{
						System.out.println("No data avaiable.");
						System.out.println("Please input data to start thread");
						System.out.print("Input [fraction type] : ");
						String input = scan.nextLine();
						Fraction ft = new Fraction(input) {};
						tothread = ft.hl.substring(0, ft.hl.indexOf("|"));
					}
					else
					{
						int ctr = 0;
						while(ctr != totaldata)
						{
							System.out.println("Data " + (ctr+1));
							System.out.println("Desimal : " + hs.get(ctr).getDesimal());
							System.out.println("Pecahan : " + hs.get(ctr).getPecahan());
							System.out.println("Campuran : " + hs.get(ctr).getCampuran());
							ctr++;
						}
						System.out.print("Choose Data to thread [index] : ");
						int index = scan.nextInt(); scan.nextLine();
						tothread = hs.get(index-1).getDesimal();
					}
				}
				else if (choose == 2)
				{
					System.out.println("Please input data to start thread");
					System.out.print("Input [fraction type] : ");
					String input = scan.nextLine();
					Fraction ft = new Fraction(input) {};
					tothread = ft.hl.substring(0, ft.hl.indexOf("|"));
				}
				ThreadCooperation tc = new ThreadCooperation();
				tc.Thread(tothread);
				exit = 1;
			}
			else if (menu.equals("0"))
				exit = 1;
		} while (exit != 1);
		scan.close();
	}
	public void compare(String a, String b, String i1, String i2)
	{
		double a1 = Double.parseDouble(a);
		double b1 = Double.parseDouble(b);
		if(Double.compare(a1, b1) > 0)
		{
			System.out.println(i1 + " is larger than " + i2);
		}
		else if(Double.compare(a1, b1) < 0)
		{
			System.out.println(i2 + " is larger than " + i1);
		}
		else if(Double.compare(a1, b1) == 0)
		{
			System.out.println(i1 + " is equal to " + i2);
		}
	}
	public static void main(String[] args) {
		new menu();
	}
}

class hasil {
	String Desimal;
	String Pecahan;
	String Campuran;
	public String getDesimal() {
		return Desimal;
	}
	public void setDesimal(String desimal) {
		Desimal = desimal;
	}
	public String getPecahan() {
		return Pecahan;
	}
	public void setPecahan(String pecahan) {
		Pecahan = pecahan;
	}
	public String getCampuran() {
		return Campuran;
	}
	public void setCampuran(String campuran) {
		Campuran = campuran;
	}
	public hasil(String desimal, String pecahan, String campuran) {
		Desimal = desimal;
		Pecahan = pecahan;
		Campuran = campuran;
	}
	
}


abstract class Fraction {
	menu m;
	DecimalFormat df =  new DecimalFormat("#.##");
	String hl;
	String hx;
	public Fraction() {
		
	}
	public Fraction(String angka) {
		String a,b,c;
		if(angka.contains(".") || angka.contains(","))
		{
			String angkaa;
			if (angka.indexOf(',') >= 0)
				angkaa = angka.substring(0,angka.indexOf(',')) + "." + 
						angka.substring(angka.indexOf(',')+1);
			else angkaa = angka;
			double x = Double.parseDouble(angkaa);
			int g = 0;
			if (angkaa.length() - angkaa.indexOf('.') > 7)
			{
				DecimalFormat f = new DecimalFormat("#.######");
				x = Double.parseDouble(f.format(x));
				g = f.format(x).length();
			}
			else
			{
				g = angkaa.length();
			}
			a = df.format(x);
			proper pr = new proper(angkaa,g,x);
			x = pr.aw;
			double v = pr.v;
			b = ((int)x + "/" + (int)v);
			mixed mi = new mixed(b,x,v);
			hl = (a + "|" + b + ";" + mi.c);
		}
		else if (angka.contains("/") && !angka.contains(" "))
		{
			double j = Double.parseDouble(angka.substring(0, angka.indexOf('/')));
			double k = Double.parseDouble(angka.substring(angka.indexOf('/')+1));
			double temp1 = j; //Highest Common Factor
			double temp2 = k;
			while (k != 0) 
			{
				int r = (int) j % (int) k;
				j = k;
				k = r;
			}
			temp1 = temp1/j;
			temp2 = temp2/j;
			j = temp1;
			k = temp2;
			decimal de = new decimal(j,k);
			double l = de.l;
			b = ((int)j + "/" + (int)k);
			a = df.format(l);
			mixed mi = new mixed(b,j,k);
			hl = (a + "|" + b + ";" + mi.c);
		}
		else if (angka.contains(" ") && angka.contains("/"))
		{
			double e = Double.parseDouble(angka.substring(0, angka.indexOf(' ')));
			double f = Double.parseDouble(angka.substring(angka.indexOf(' '), angka.indexOf('/')));
			double g = Double.parseDouble(angka.substring(angka.indexOf('/')+1));
			double temp1 = f; //Highest Common Factor
			double temp2 = g;
			while (g != 0) 
			{
				int r = (int) f % (int) g;
				f = g;
				g = r;
			}
			temp1 = temp1/f;
			temp2 = temp2/f;
			f = temp1;
			g = temp2;
			mixed md = new mixed(e,f,g);
			e = md.fh;
			f = md.fx;
			g = md.fy;
			if (e > 0)
			c = ((int)e + " " + (int)f + "/" + (int)g);
			else c = ((int)f + "/" + (int)g);
			proper po = new proper(e,f,g);
			f = po.sb;
			g = po.sc;
			b = ((int)f + "/" + (int)g);
			double d = f/g;
			a = df.format(d);
			hl = (a + "|" + b + ";" + c);
		}
		else
		{
			int angka1=Integer.parseInt(angka);
			a = ("" + angka1);
			b = (angka1 + "/1");
			c = b;
			hl = (a + "|" + b + ";" + c);
		}
	}
	public void tambah(String ax,String bx) {
		// kode 1 desimal, kode 2 pecahan, kode 3 campuran
		String ubah1 = ax.substring(0,ax.indexOf('|'));
		String ubah2 = ax.substring(ax.indexOf('|')+1, ax.indexOf(';'));
		String ubah3 = ax.substring(ax.indexOf(';')+1,ax.length());
		String jadi1 = bx.substring(0,bx.indexOf('|'));
		String jadi2 = bx.substring(bx.indexOf('|')+1, bx.indexOf(';'));
		String jadi3 = bx.substring(bx.indexOf(';')+1,bx.length());
		double u = Double.parseDouble(ubah1);
		double v = Double.parseDouble(jadi1);
		decimal d1 = new decimal();
		d1.add(v,u);
		int a = Integer.parseInt(jadi2.substring(0, jadi2.indexOf('/')));
		int b = Integer.parseInt(jadi2.substring(jadi2.indexOf('/')+1,jadi2.length()));
		int c = Integer.parseInt(ubah2.substring(0, ubah2.indexOf('/')));
		int d = Integer.parseInt(ubah2.substring(ubah2.indexOf('/')+1,ubah2.length()));
		proper p1 = new proper();
		p1.add(a, b, c, d);
		String has2 = (p1.has2a + "/" + p1.has2b);
		int e,f,g;
		int h,i,j;
		if (jadi3.equals(jadi2))
		{
			e = 0;
			f = a;
			g = b;
		}
		else
		{
			e = Integer.parseInt(jadi3.substring(0,jadi3.indexOf(' ')));
			f = Integer.parseInt(jadi3.substring(jadi3.indexOf(' ')+1,jadi3.indexOf('/')));
			g = Integer.parseInt(jadi3.substring(jadi3.indexOf('/')+1,jadi3.length()));
			while (e != 0)
			{
				f = f + g;
				e--;
			}
		}
		if(ubah3.equals(ubah2))
		{
			h = 0;
			i = c;
			j = d;
		}
		else
		{
			h = Integer.parseInt(ubah3.substring(0,ubah3.indexOf(' ')));
			i = Integer.parseInt(ubah3.substring(ubah3.indexOf(' ')+1,ubah3.indexOf('/')));
			j = Integer.parseInt(ubah3.substring(jadi3.indexOf('/')+1,ubah3.length()));
			while (h != 0)
			{
				i = i + j;
				h--;
			}
		}
		mixed m1 = new mixed();
		m1.add(e, f, g, h, i, j);
		String has3 = (m1.has3x + " " + m1.has3a + "/" + m1.has3b);
		hx = (df.format(d1.has1) + "|" + has2 + ";" + has3);
	}
	public void kurang(String ax,String bx) {
		// kode 1 desimal, kode 2 pecahan, kode 3 campuran
		String ubah1 = ax.substring(0,ax.indexOf('|'));
		String ubah2 = ax.substring(ax.indexOf('|')+1, ax.indexOf(';'));
		String ubah3 = ax.substring(ax.indexOf(';')+1,ax.length());
		String jadi1 = bx.substring(0,bx.indexOf('|'));
		String jadi2 = bx.substring(bx.indexOf('|')+1, bx.indexOf(';'));
		String jadi3 = bx.substring(bx.indexOf(';')+1,bx.length());
		double u = Double.parseDouble(ubah1);
		double v = Double.parseDouble(jadi1);
		decimal d1 = new decimal();
		d1.subtract(v,u);
		int a = Integer.parseInt(jadi2.substring(0, jadi2.indexOf('/')));
		int b = Integer.parseInt(jadi2.substring(jadi2.indexOf('/')+1,jadi2.length()));
		int c = Integer.parseInt(ubah2.substring(0, ubah2.indexOf('/')));
		int d = Integer.parseInt(ubah2.substring(ubah2.indexOf('/')+1,ubah2.length()));
		proper p1 = new proper();
		p1.subtract(a, b, c, d);
		String has2 = (p1.has2a + "/" + p1.has2b);
		int e,f,g;
		int h,i,j;
		if (jadi3.equals(jadi2))
		{
			e = 0;
			f = a;
			g = b;
		}
		else
		{
			e = Integer.parseInt(jadi3.substring(0,jadi3.indexOf(' ')));
			f = Integer.parseInt(jadi3.substring(jadi3.indexOf(' ')+1,jadi3.indexOf('/')));
			g = Integer.parseInt(jadi3.substring(jadi3.indexOf('/')+1,jadi3.length()));
			while (e != 0)
			{
				f = f + g;
				e--;
			}
		}
		if(ubah3.equals(ubah2))
		{
			h = 0;
			i = c;
			j = d;
		}
		else
		{
			h = Integer.parseInt(ubah3.substring(0,ubah3.indexOf(' ')));
			i = Integer.parseInt(ubah3.substring(ubah3.indexOf(' ')+1,ubah3.indexOf('/')));
			j = Integer.parseInt(ubah3.substring(jadi3.indexOf('/')+1,ubah3.length()));
			while (h != 0)
			{
				i = i + j;
				h--;
			}
		}
		mixed m1 = new mixed();
		m1.subtract(e, f, g, h, i, j);
		String has3 = (m1.has3x + " " + m1.has3a + "/" + m1.has3b);
		hx = (df.format(d1.has1) + "|" + has2 + ";" + has3);
	}
	public void kali(String ax,String bx) {
		// kode 1 desimal, kode 2 pecahan, kode 3 campuran
		String ubah1 = ax.substring(0,ax.indexOf('|'));
		String ubah2 = ax.substring(ax.indexOf('|')+1, ax.indexOf(';'));
		String ubah3 = ax.substring(ax.indexOf(';')+1,ax.length());
		String jadi1 = bx.substring(0,bx.indexOf('|'));
		String jadi2 = bx.substring(bx.indexOf('|')+1, bx.indexOf(';'));
		String jadi3 = bx.substring(bx.indexOf(';')+1,bx.length());
		double u = Double.parseDouble(ubah1);
		double v = Double.parseDouble(jadi1);
		System.out.println(u + v);
		decimal d1 = new decimal();
		d1.multiply(v,u);
		int a = Integer.parseInt(jadi2.substring(0, jadi2.indexOf('/')));
		int b = Integer.parseInt(jadi2.substring(jadi2.indexOf('/')+1,jadi2.length()));
		int c = Integer.parseInt(ubah2.substring(0, ubah2.indexOf('/')));
		int d = Integer.parseInt(ubah2.substring(ubah2.indexOf('/')+1,ubah2.length()));
		proper p1 = new proper();
		p1.multiply(a, b, c, d);
		String has2 = (p1.has2a + "/" + p1.has2b);
		int e,f,g;
		int h,i,j;
		if (jadi3.equals(jadi2))
		{
			e = 0;
			f = a;
			g = b;
		}
		else
		{
			e = Integer.parseInt(jadi3.substring(0,jadi3.indexOf(' ')));
			f = Integer.parseInt(jadi3.substring(jadi3.indexOf(' ')+1,jadi3.indexOf('/')));
			g = Integer.parseInt(jadi3.substring(jadi3.indexOf('/')+1,jadi3.length()));
			while (e != 0)
			{
				f = f + g;
				e--;
			}
		}
		if(ubah3.equals(ubah2))
		{
			h = 0;
			i = c;
			j = d;
		}
		else
		{
			h = Integer.parseInt(ubah3.substring(0,ubah3.indexOf(' ')));
			i = Integer.parseInt(ubah3.substring(ubah3.indexOf(' ')+1,ubah3.indexOf('/')));
			j = Integer.parseInt(ubah3.substring(jadi3.indexOf('/')+1,ubah3.length()));
			while (h != 0)
			{
				i = i + j;
				h--;
			}
		}
		mixed m1 = new mixed();
		m1.multiply(f, g, i, j);
		String has3 = (m1.has3x + " " + m1.has3a + "/" + m1.has3b);
		hx = (df.format(d1.has1) + "|" + has2 + ";" + has3);
	}
	public void bagi(String ax,String bx) {
		// kode 1 desimal, kode 2 pecahan, kode 3 campuran
		String ubah1 = ax.substring(0,ax.indexOf('|'));
		String ubah2 = ax.substring(ax.indexOf('|')+1, ax.indexOf(';'));
		String ubah3 = ax.substring(ax.indexOf(';')+1,ax.length());
		String jadi1 = bx.substring(0,bx.indexOf('|'));
		String jadi2 = bx.substring(bx.indexOf('|')+1, bx.indexOf(';'));
		String jadi3 = bx.substring(bx.indexOf(';')+1,bx.length());
		double u = Double.parseDouble(ubah1);
		double v = Double.parseDouble(jadi1);
		decimal d1 = new decimal();
		d1.divide(v,u);
		int a = Integer.parseInt(jadi2.substring(0, jadi2.indexOf('/')));
		int b = Integer.parseInt(jadi2.substring(jadi2.indexOf('/')+1,jadi2.length()));
		int c = Integer.parseInt(ubah2.substring(0, ubah2.indexOf('/')));
		int d = Integer.parseInt(ubah2.substring(ubah2.indexOf('/')+1,ubah2.length()));
		proper p1 = new proper();
		p1.divide(a, b, c, d);
		String has2 = (p1.has2a + "/" + p1.has2b);
		int e,f,g;
		int h,i,j;
		if (jadi3.equals(jadi2))
		{
			e = 0;
			f = a;
			g = b;
		}
		else
		{
			e = Integer.parseInt(jadi3.substring(0,jadi3.indexOf(' ')));
			f = Integer.parseInt(jadi3.substring(jadi3.indexOf(' ')+1,jadi3.indexOf('/')));
			g = Integer.parseInt(jadi3.substring(jadi3.indexOf('/')+1,jadi3.length()));
			while (e != 0)
			{
				f = f + g;
				e--;
			}
		}
		if(ubah3.equals(ubah2))
		{
			h = 0;
			i = c;
			j = d;
		}
		else
		{
			h = Integer.parseInt(ubah3.substring(0,ubah3.indexOf(' ')));
			i = Integer.parseInt(ubah3.substring(ubah3.indexOf(' ')+1,ubah3.indexOf('/')));
			j = Integer.parseInt(ubah3.substring(jadi3.indexOf('/')+1,ubah3.length()));
			while (h != 0)
			{
				i = i + j;
				h--;
			}
		}
		mixed m1 = new mixed();
		m1.divide(f, g, i, j);
		String has3 = (m1.has3x + " " + m1.has3a + "/" + m1.has3b);
		hx = (df.format(d1.has1) + "|" + has2 + ";" + has3);
	}
}

class proper extends Fraction {
	double v;
	double aw;
	int has2b = 0;
	int has2a = 0;
	public proper() {
		
	}
	public proper(String angkaa, int m, double x) {
		super();
		aw = x;
		int z = angkaa.indexOf('.');//Determining the normal fraction
		int y = m;
		v = 1;
		while(z != y)
		{
			aw = aw*10; //times 10 method to push the '.' to the end
			v = v*10;
			z++;
		}
		double temp1 = aw; //Highest Common Factor
		double temp2 = v;
		while (v != 0) 
		{
			int r = (int) aw % (int)v;
			aw = v;
			v = r;
		}
		temp1 = temp1/aw;
		temp2 = temp2/aw;
		aw = temp1;
		v = temp2;
	}
	double sa;
	double sb;
	double sc;
	public proper(double e, double f, double g) {
		super();
		sa = e;
		sb = f;
		sc = g;
		while (sa != 0) //Determining normal fraction
		{
			sb = sb + sc;
			sa--;
		}
	}
	public void add(int a, int b, int c, int d) {
		if (b != d)
		{
			has2b = b*d;
			has2a = a*d + c*b;
		}
		else
		{
			has2b = b;
			has2a = a + c;
		}
		int temp1 = has2a; //Highest Common Factor
		int temp2 = has2b;
		while (has2b != 0) 
		{
			int r = (int) has2a % (int) has2b;
			has2a = has2b;
			has2b = r;
		}
		temp1 = temp1/has2a;
		temp2 = temp2/has2a;
		has2a = temp1;
		has2b = temp2;
	}
	public void add(String a, String b) {
		int ta1 = Integer.parseInt(a.substring(0,a.indexOf('/')));
		int ta2 = Integer.parseInt(a.substring(a.indexOf('/')+1,a.length()));
		int yg1 = Integer.parseInt(b.substring(0, b.indexOf('/')));
		int yg2 = Integer.parseInt(b.substring(b.indexOf('/')+1,b.length()));
		if (ta2 != yg2)
		{
			has2b = ta2*yg2;
			has2a = ta1*yg2 + yg1*ta2;
		}
		else
		{
			has2b = ta2;
			has2a = ta1 + yg1;
		}
		int temp1 = has2a; //Highest Common Factor
		int temp2 = has2b;
		while (has2b != 0) 
		{
			int r = (int) has2a % (int) has2b;
			has2a = has2b;
			has2b = r;
		}
		temp1 = temp1/has2a;
		temp2 = temp2/has2a;
		has2a = temp1;
		has2b = temp2;
	}
	public void subtract(int a, int b, int c, int d) {
		if (b != d)
		{
			has2b = b*d;
			has2a = a*d - c*b;
		}
		else
		{
			has2b = b;
			has2a = a - c;
		}
		int temp1 = has2a; //Highest Common Factor
		int temp2 = has2b;
		while (has2b != 0) 
		{
			int r = (int) has2a % (int) has2b;
			has2a = has2b;
			has2b = r;
		}
		temp1 = temp1/has2a;
		temp2 = temp2/has2a;
		has2a = temp1;
		has2b = temp2;
	}
	public void subtract(String a, String b) {
		int ta1 = Integer.parseInt(a.substring(0,a.indexOf('/')));
		int ta2 = Integer.parseInt(a.substring(a.indexOf('/')+1,a.length()));
		int yg1 = Integer.parseInt(b.substring(0, b.indexOf('/')));
		int yg2 = Integer.parseInt(b.substring(b.indexOf('/')+1,b.length()));
		if (ta2 != yg2)
		{
			has2b = ta2*yg2;
			has2a = ta1*yg2 - yg1*ta2;
		}
		else
		{
			has2b = ta2;
			has2a = ta1 - yg1;
		}
		int temp1 = has2a; //Highest Common Factor
		int temp2 = has2b;
		while (has2b != 0) 
		{
			int r = (int) has2a % (int) has2b;
			has2a = has2b;
			has2b = r;
		}
		temp1 = temp1/has2a;
		temp2 = temp2/has2a;
		has2a = temp1;
		has2b = temp2;
	}
	public void multiply(int a, int b, int c, int d) {
		has2b = b*d;
		has2a = a*c;
		int temp1 = has2a; //Highest Common Factor
		int temp2 = has2b;
		while (has2b != 0) 
		{
			int r = (int) has2a % (int) has2b;
			has2a = has2b;
			has2b = r;
		}
		temp1 = temp1/has2a;
		temp2 = temp2/has2a;
		has2a = temp1;
		has2b = temp2;
	}
	public void multiply(String a, String b) {
		int ax = Integer.parseInt(a.substring(0, a.indexOf('/')));
		int ay = Integer.parseInt(a.substring(a.indexOf('/')+1,a.length()));
		int bx = Integer.parseInt(b.substring(0, b.indexOf('/')));
		int by = Integer.parseInt(b.substring(b.indexOf('/')+1,b.length()));
		has2b = ay*by;
		has2a = ax*bx;
		int temp1 = has2a; //Highest Common Factor
		int temp2 = has2b;
		while (has2b != 0) 
		{
			int r = (int) has2a % (int) has2b;
			has2a = has2b;
			has2b = r;
		}
		temp1 = temp1/has2a;
		temp2 = temp2/has2a;
		has2a = temp1;
		has2b = temp2;
	}
	public void divide(int a, int b, int c, int d) {
		has2b = b*c;
		has2a = a*d;
		int temp1 = has2a; //Highest Common Factor
		int temp2 = has2b;
		while (has2b != 0) 
		{
			int r = (int) has2a % (int) has2b;
			has2a = has2b;
			has2b = r;
		}
		temp1 = temp1/has2a;
		temp2 = temp2/has2a;
		has2a = temp1;
		has2b = temp2;
	}
	public void divide(String a, String b) {
		int ax = Integer.parseInt(a.substring(0, a.indexOf('/')));
		int ay = Integer.parseInt(a.substring(a.indexOf('/')+1,a.length()));
		int bx = Integer.parseInt(b.substring(0, b.indexOf('/')));
		int by = Integer.parseInt(b.substring(b.indexOf('/')+1,b.length()));
		has2b = ay*bx;
		has2a = ax*by;
		int temp1 = has2a; //Highest Common Factor
		int temp2 = has2b;
		while (has2b != 0) 
		{
			int r = (int) has2a % (int) has2b;
			has2a = has2b;
			has2b = r;
		}
		temp1 = temp1/has2a;
		temp2 = temp2/has2a;
		has2a = temp1;
		has2b = temp2;
	}
}

class mixed extends Fraction {
	String c;
	double fx;
	double fy;
	double fh;
	int has3b = 0;
	int has3a = 0;
	int has3x = 0;
	public mixed() {
		
	}
	public mixed(String b, double x, double v) {
		super();
		int u = 0; //Determining mixed fraction
		while (x - v > 0) 
		{
			x = x - v;
			u++;
		}
		if (u > 0 && v != 1)
			c = (u + " " + (int)x + "/" + (int)v);
		else
			c = b;
	}
	public mixed(double e, double f, double g) {
		fx = f;
		fy = g;
		fh = e;
		while (fx - fy > 0) //Determining mixed fraction
		{
			fx = fx - fy;
			fh++;
		}
	}
	public void add(int e, int f, int g, int h, int i, int j) {
		if (g != j)
		{
			has3b = g*j;
			has3a = f*j + i*g;
		}
		else
		{
			has3b = g;
			has3a = f + i;
		}
		int temp1 = has3a; //Highest Common Factor
		int temp2 = has3b;
		while (has3b != 0) 
		{
			int r = (int) has3a % (int) has3b;
			has3a = has3b;
			has3b = r;
		}
		temp1 = temp1/has3a;
		temp2 = temp2/has3a;
		has3a = temp1;
		has3b = temp2;
		while (has3a - has3b > 0)
		{
			has3a = has3a - has3b;
			has3x++;
		}
	}
	public void add (String a, String b) {
		int e;
		int h;
		if(a.contains(" "))
			e = Integer.parseInt(a.substring(0,a.indexOf(' ')));
		else
			e = 0;
		int f = Integer.parseInt(a.substring(a.indexOf(' ')+1, a.indexOf('/')));
		int g = Integer.parseInt(a.substring(a.indexOf('/')+1, a.length()));
		if (b.contains(" "))
			h = Integer.parseInt(b.substring(0, b.indexOf(' ')));
		else
			h = 0;
		int i = Integer.parseInt(b.substring(b.indexOf(' ')+1,b.indexOf('/')));
		int j = Integer.parseInt(b.substring(b.indexOf('/')+1, b.length()));
		while (e != 0)
		{
			f = f + g;
			e--;
		}
		while (h != 0)
		{
			i = i + j;
			h--;
		}
		if (g != j)
		{
			has3b = g*j;
			has3a = f*j + i*g;
		}
		else
		{
			has3b = g;
			has3a = f + i;
		}
		int temp1 = has3a; //Highest Common Factor
		int temp2 = has3b;
		while (has3b != 0) 
		{
			int r = (int) has3a % (int) has3b;
			has3a = has3b;
			has3b = r;
		}
		temp1 = temp1/has3a;
		temp2 = temp2/has3a;
		has3a = temp1;
		has3b = temp2;
		while (has3a - has3b > 0)
		{
			has3a = has3a - has3b;
			has3x++;
		}
	}
	public void subtract(String a, String b) {
		int e;
		int h;
		if(a.contains(" "))
			e = Integer.parseInt(a.substring(0,a.indexOf(' ')));
		else
			e = 0;
		int f = Integer.parseInt(a.substring(a.indexOf(' ')+1, a.indexOf('/')));
		int g = Integer.parseInt(a.substring(a.indexOf('/')+1, a.length()));
		if (b.contains(" "))
			h = Integer.parseInt(b.substring(0, b.indexOf(' ')));
		else
			h = 0;
		int i = Integer.parseInt(b.substring(b.indexOf(' ')+1,b.indexOf('/')));
		int j = Integer.parseInt(b.substring(b.indexOf('/')+1, b.length()));
		while (e != 0)
		{
			f = f + g;
			e--;
		}
		while (h != 0)
		{
			i = i - j;
			h--;
		}
		if (g != j)
		{
			has3b = g*j;
			has3a = f*j - i*g;
		}
		else
		{
			has3b = g;
			has3a = f - i;
		}
		int temp1 = has3a; //Highest Common Factor
		int temp2 = has3b;
		while (has3b != 0) 
		{
			int r = (int) has3a % (int) has3b;
			has3a = has3b;
			has3b = r;
		}
		temp1 = temp1/has3a;
		temp2 = temp2/has3a;
		has3a = temp1;
		has3b = temp2;
		while (has3a - has3b > 0)
		{
			has3a = has3a - has3b;
			has3x++;
		}
	}
	public void subtract(int e, int f, int g, int h, int i, int j) {
		if (g != j)
		{
			has3b = g*j;
			has3a = f*j - i*g;
		}
		else
		{
			has3b = g;
			has3a = f - i;
		}
		int temp1 = has3a; //Highest Common Factor
		int temp2 = has3b;
		while (has3b != 0) 
		{
			int r = (int) has3a % (int) has3b;
			has3a = has3b;
			has3b = r;
		}
		temp1 = temp1/has3a;
		temp2 = temp2/has3a;
		has3a = temp1;
		has3b = temp2;
		while (has3a - has3b > 0)
		{
			has3a = has3a - has3b;
			has3x++;
		}
	}
	public void multiply(String a, String b) {
		int e;
		int h;
		if(a.contains(" "))
			e = Integer.parseInt(a.substring(0,a.indexOf(' ')));
		else
			e = 0;
		int f = Integer.parseInt(a.substring(a.indexOf(' ')+1, a.indexOf('/')));
		int g = Integer.parseInt(a.substring(a.indexOf('/')+1, a.length()));
		if (b.contains(" "))
			h = Integer.parseInt(b.substring(0, b.indexOf(' ')));
		else
			h = 0;
		int i = Integer.parseInt(b.substring(b.indexOf(' ')+1,b.indexOf('/')));
		int j = Integer.parseInt(b.substring(b.indexOf('/')+1, b.length()));
		while (e != 0)
		{
			f = f + g;
			e--;
		}
		while (h != 0)
		{
			i = i + j;
			h--;
		}
		has3a = f*i;
		has3b = g*j;
		int temp1 = has3a; //Highest Common Factor
		int temp2 = has3b;
		while (has3b != 0) 
		{
			int r = (int) has3a % (int) has3b;
			has3a = has3b;
			has3b = r;
		}
		temp1 = temp1/has3a;
		temp2 = temp2/has3a;
		has3a = temp1;
		has3b = temp2;
		while (has3a - has3b > 0)
		{
			has3a = has3a - has3b;
			has3x++;
		}
	}
	public void multiply(int f, int g, int i, int j) {
		has3a = f*i;
		has3b = g*j;
		int temp1 = has3a; //Highest Common Factor
		int temp2 = has3b;
		while (has3b != 0) 
		{
			int r = (int) has3a % (int) has3b;
			has3a = has3b;
			has3b = r;
		}
		temp1 = temp1/has3a;
		temp2 = temp2/has3a;
		has3a = temp1;
		has3b = temp2;
		while (has3a - has3b > 0)
		{
			has3a = has3a - has3b;
			has3x++;
		}
	}
	public void divide(int f, int g, int i, int j) {
		has3a = f*j;
		has3b = g*i;
		int temp1 = has3a; //Highest Common Factor
		int temp2 = has3b;
		while (has3b != 0) 
		{
			int r = (int) has3a % (int) has3b;
			has3a = has3b;
			has3b = r;
		}
		temp1 = temp1/has3a;
		temp2 = temp2/has3a;
		has3a = temp1;
		has3b = temp2;
		while (has3a - has3b > 0)
		{
			has3a = has3a - has3b;
			has3x++;
		}
	}
	public void divide(String a, String b) {
		int e;
		int h;
		if(a.contains(" "))
			e = Integer.parseInt(a.substring(0,a.indexOf(' ')));
		else
			e = 0;
		int f = Integer.parseInt(a.substring(a.indexOf(' ')+1, a.indexOf('/')));
		int g = Integer.parseInt(a.substring(a.indexOf('/')+1, a.length()));
		if (b.contains(" "))
			h = Integer.parseInt(b.substring(0, b.indexOf(' ')));
		else
			h = 0;
		int i = Integer.parseInt(b.substring(b.indexOf(' ')+1,b.indexOf('/')));
		int j = Integer.parseInt(b.substring(b.indexOf('/')+1, b.length()));
		while (e != 0)
		{
			f = f + g;
			e--;
		}
		while (h != 0)
		{
			i = i + j;
			h--;
		}
		has3a = f*j;
		has3b = g*i;
		int temp1 = has3a; //Highest Common Factor
		int temp2 = has3b;
		while (has3b != 0) 
		{
			int r = (int) has3a % (int) has3b;
			has3a = has3b;
			has3b = r;
		}
		temp1 = temp1/has3a;
		temp2 = temp2/has3a;
		has3a = temp1;
		has3b = temp2;
		while (has3a - has3b > 0)
		{
			has3a = has3a - has3b;
			has3x++;
		}
	}
}

class decimal extends Fraction {
	double l;
	double has1;
	public decimal() {
		
	}
	public decimal(double j, double k) {
		super();
		l = j/k;
	}
	public void add(double k, double l) {
		has1 = k + l;
	}
	public void add(String a, String b) {
		has1 = Double.parseDouble(a) + Double.parseDouble(b);
	}
	public void subtract(double k, double l) {
		has1 = k - l;
	}
	public void subtract(String a, String b) {
		has1 = Double.parseDouble(a) - Double.parseDouble(b);
	}
	public void multiply(double k, double l) {
		has1 = k * l;
	}
	public void multiply(String a, String b) {
		has1 = Double.parseDouble(a) * Double.parseDouble(b);
	}
	public void divide(double k, double l) {
		has1 = k / l;
	}
	public void divide(String a, String b) {
		has1 = Double.parseDouble(a) / Double.parseDouble(b);
	}
}

class ThreadCooperation {
	private static Account account = new Account();
	public void Thread(String a) {
		double x = Double.parseDouble(a);
		account.setKurang(x);
		account.setTambah(x);
		ExecutorService executor = Executors.newFixedThreadPool(2);
		executor.execute(new DepositTask());
		executor.execute(new WithdrawTask());
		executor.shutdown();
	}

	public static class DepositTask implements Runnable {
		DecimalFormat df = new DecimalFormat("#.##");
		public void run(){
			try {
				while(true) {
					account.addi(Double.parseDouble(df.format(Math.random()*10)));
					Thread.sleep(1000);
				}
			} catch (InterruptedException ie){
				ie.printStackTrace();
			}
		}
	}

	public static class WithdrawTask implements Runnable {
		DecimalFormat df = new DecimalFormat("#.##");
		public void run(){
			try {
				while(true)
				{
					account.subtr(Double.parseDouble(df.format(Math.random()*10)));
					Thread.sleep(1000);
				}
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
	}

	private static class Account{
		DecimalFormat df = new DecimalFormat("#.##");
		private static Lock lock = new ReentrantLock();
		private static Condition newDeposit = lock.newCondition();
		private double kurang = 0;
		private double tambah = 0;
		
		public void setKurang(double kurang) {
			this.kurang = kurang;
		}
		public void setTambah(double tambah) {
			this.tambah = tambah;
		}
		public double getKurang(){
			return kurang;
		}
		public double getTambah() {
			return tambah;
		}
		public void subtr(double amount){
			lock.lock();
			try {
				if(kurang != 0)
					kurang -= amount;
				if(kurang <= 0)
				{
					kurang = 0;
					System.out.println("The result is less than 0");
				}
				else
				{
					System.out.println("Subtract " + amount + " Remaining " + df.format(getKurang()));
					Fraction fr = new Fraction(df.format(getKurang())) {};
					System.out.println("Normal Fraction : " + fr.hl.substring(fr.hl.indexOf("|")+1,fr.hl.indexOf(";")));
					System.out.println("Mixed Fraction : " + fr.hl.substring(fr.hl.indexOf(";")+1));
				}
			} finally {
				lock.unlock();
			}
		}

		public void addi(double amount){
			lock.lock();
			try {
				tambah += amount;
				System.out.println("Add " + amount + " Total " + df.format(getTambah()));
				Fraction fr = new Fraction(df.format(getTambah())) {};
				System.out.println("Normal Fraction : " + fr.hl.substring(fr.hl.indexOf("|")+1,fr.hl.indexOf(";")));
				System.out.println("Mixed Fraction : " + fr.hl.substring(fr.hl.indexOf(";")+1));
				newDeposit.signalAll();
			} finally {
				lock.unlock();
			}
		}
	}
}