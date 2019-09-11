package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entidade.Reserva;

public class Programa {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc =new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Digite o numero do quarto: ");
		int numeroQuarto = sc.nextInt();
		
		System.out.println("Digite a data de entrada(dd/mm/aaaa): ");
		Date dataEntrada = sdf.parse(sc.next());
				
		System.out.println("Digite a data de saida(dd/mm/aaaa): ");
		Date dataSaida = sdf.parse(sc.next());
		
		if(!dataSaida.after(dataEntrada)) {
			System.out.println("Erro na reserva!\nA data de saida tem que ser posterior a data de entrada!");
		}else {
			Reserva reserva = new Reserva(numeroQuarto, dataEntrada, dataSaida);
			System.out.println("Reserva: "+reserva.toString());
			
			System.out.println();
			System.out.println("Entre com as datas para utualizar reserva: ");
			
			System.out.println("Digite a data de entrada(dd/mm/aaaa): ");
			dataEntrada = sdf.parse(sc.next());
					
			System.out.println("Digite a data de saida(dd/mm/aaaa): ");
			dataSaida = sdf.parse(sc.next());
			
			String erro = reserva.atualizacaoHospedagem(dataEntrada, dataSaida);
			if(erro != null) {
				System.out.println("Erro na reserva: "+ erro);
			}else {
				System.out.println("Reserva: "+reserva.toString());
			}		
		}
		sc.close();
	}

}
