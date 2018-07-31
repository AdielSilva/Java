package principal;

import java.util.Scanner;

public class Data {
	private int dia;
	private int mes;
	private int ano;
	
	public Data(){
		this.entraAno();
		this.entraMes();
		this.entraDia();
	}
	
	public Data(int d, int m, int a) {
		try {
			this.entraAno(a);
			this.entraMes(m);
			this.entraDia(d);			
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		} 
	}
	
	public void entraDia(int d) throws Exception{
		if(this.mes == 0) throw new Exception("Digite primeiro o mês.");
		int max = 0;
		switch(this.mes) {
			case 4: case 6: case 9: case 11: max = 30; break;
			case 1: case 3: case 5: case 7: case 8: case 10: case 12: max = 31; break;
			case 2: if(this.bissexto()) max = 29; else max = 28; break;
		}
		if(d > max || d < 1)
			throw new Exception("O dia está fora do limite. Tente algo entre 1 e "+ max +".");
		this.dia = d;
		
	}
	
	public void entraMes(int m) throws Exception {
		if(this.ano == 0) throw new Exception("Digite primeiro o ano.");
		if(m > 12 || m < 1)
			throw new Exception("O mês está fora do limite. Tente algo entre 1 e 12.");
		this.mes = m;
	}
	
	public void entraAno(int a) throws Exception {
		if(a < 0)
			throw new Exception("O ano está fora do limite. Tente algo maior que 0.");
		this.ano = a;
	}
	
	public void entraDia() {
		Scanner scan;
		boolean exec = true;
		do {
			try {
				System.out.print("Digite o dia: ");
				scan = new Scanner(System.in);
				entraDia(scan.nextInt());
				exec = !exec;
			}
			catch(Exception e) {
				System.out.println("Erro: " + e.getMessage());
			}
		}while(exec);
	}
	
	public void entraMes() {
		Scanner scan;
		boolean exec = true;
		do {
			try {
				System.out.print("Digite o mês: ");
				scan = new Scanner(System.in);
				entraMes(scan.nextInt());
				exec = !exec;
			}
			catch(Exception e) {
				System.out.println("Erro: " + e.getMessage());
			}
		}while(exec);
		
	}
	
	public void entraAno() {
		Scanner scan;
		boolean exec = true;
		do {
			try {
				System.out.print("Digite o ano: ");
				scan = new Scanner(System.in);
				entraAno(scan.nextInt());
				exec = !exec;
			}
			catch(Exception e) {
				System.out.println("Erro: " + e.getMessage());
			}
		}while(exec);
	}
	
	public int retDia() {
		return this.dia;
	}
	
	public int retMes() {
		return this.mes;
	}
	
	public int retAno() {
		return this.ano;
	}
	
	public String mostra1() {
		return String.format("%02d/%02d/%04d", this.dia, this.mes, this.ano);
	}
	
	public String mostra2() {
		String mesExt = "";
		switch(this.mes) {
			case 1: mesExt = "janeiro"; break;
			case 2: mesExt = "fevereiro"; break;
			case 3: mesExt = "março"; break;
			case 4: mesExt = "abril"; break;
			case 5: mesExt = "maio"; break;
			case 6: mesExt = "junho"; break;
			case 7: mesExt = "julho"; break;
			case 8: mesExt = "agosto"; break;
			case 9: mesExt = "semtembro"; break;
			case 10: mesExt = "outubro"; break;
			case 11: mesExt = "novembro"; break;
			case 12: mesExt = "dezembro"; break;
		}
		return String.format("%02d/%s/%04d", this.dia, mesExt, this.ano);
	}
	
	public boolean bissexto() {
		if ((this.ano % 100 != 0 && this.ano % 4 == 0) || this.ano % 400 == 0)
			return true;
		return false;
	}
	
	public int diaTranscorridos() {
		int dias = 0;
		for(int i = mes-1; i > 0; i--) {
			switch(i) {
				case 4: case 6: case 9: case 11: dias += 30; break;
				case 1: case 3: case 5: case 7: case 8: case 10: case 12: dias += 31; break;
				case 2: if(this.bissexto()) dias += 29; else dias += 28; break;
			}
		}
		dias += this.dia;
		return dias;
	}
}
