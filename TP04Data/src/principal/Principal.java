package principal;

public class Principal {

	public static void main(String[] args) {
		System.out.println("Criando primeira data:");
		Data data2 = new Data(1,1,1);
		try {
			data2.entraDia(17);
			System.out.println(data2.retDia());
			data2.entraMes(10);
			System.out.println(data2.retMes());
			data2.entraAno(1);
			System.out.println(data2.retAno());
		}catch(Exception e) {
			System.out.println("Erro: "+e.getMessage());
		}

		System.out.println("Método mostra1(): " + data2.mostra1());
		System.out.println("Método mostra2(): "+ data2.mostra2());
		System.out.println("Dias transcorridos: "+data2.diaTranscorridos());
		
		System.out.println("\nCriando segunda data:");
		Data data1 = new Data();
		System.out.println("Método mostra1(): " + data1.mostra1());
		System.out.println("Método mostra2(): "+ data1.mostra2());
		System.out.println("Dias transcorridos: "+data1.diaTranscorridos());
	}
}
