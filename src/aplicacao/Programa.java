package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entidade.Reserva;
import model.excessoes.DominioExcessao;

public class Programa {

	public static void main(String[] args){
		
		try {
			Scanner sc =new Scanner(System.in);
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			
			System.out.println("Digite o numero do quarto: ");
			int numeroQuarto = sc.nextInt();
			
			System.out.println("Digite a data de entrada(dd/mm/aaaa): ");
			Date dataEntrada = sdf.parse(sc.next());
					
			System.out.println("Digite a data de saida(dd/mm/aaaa): ");
			Date dataSaida = sdf.parse(sc.next());
			
			
			Reserva reserva = new Reserva(numeroQuarto, dataEntrada, dataSaida);
			System.out.println("Reserva: "+reserva.toString());
			
			System.out.println();
			System.out.println("Entre com as datas para utualizar reserva: ");
			
			System.out.println("Digite a data de entrada(dd/mm/aaaa): ");
			dataEntrada = sdf.parse(sc.next());
					
			System.out.println("Digite a data de saida(dd/mm/aaaa): ");
			dataSaida = sdf.parse(sc.next());
			
			reserva.atualizacaoHospedagem(dataEntrada, dataSaida);
			
			System.out.println("Reserva: "+reserva.toString());
					
			sc.close();
		}catch (ParseException e) {
			System.out.println("Data em formato invalido!!!");
		}
		catch (DominioExcessao e) {
			System.out.println("Erro na reserva: "+ e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Erro inesperado !!!");
		}
	}
}
