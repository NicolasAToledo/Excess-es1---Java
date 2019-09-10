package model.entidade;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {
	
	private Integer numeroQuarto;
	private Date dataEntrada;
	private Date dataSaida;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reserva(Integer numeroQuarto, Date dataEntrada, Date dataSaida) {
		this.numeroQuarto = numeroQuarto;
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
	}

	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public Date getDataEntrada() {
		return dataEntrada;
	}

	public Date getDataSaida() {
		return dataSaida;
	}

	
	public long duracaoHospedagem() {
		
		long diferenca = dataSaida.getTime() - dataEntrada.getTime();
		return TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS);
		//return diferenca;
	}
	
	public void atualizacaoHospedagem(Date dataEntrada, Date dataSaida) {
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
	}

	@Override
	public String toString() {
		return "Quarto"
				+numeroQuarto
				+", Entrada: "
				+sdf.format(dataEntrada)
				+", Saida: "
				+sdf.format(dataSaida)
				+", Total de " + duracaoHospedagem() + " dia(s)";
				 
	}	
}