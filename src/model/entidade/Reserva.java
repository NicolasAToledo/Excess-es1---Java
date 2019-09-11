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
	
	public String atualizacaoHospedagem(Date dataEntrada, Date dataSaida) {
		Date dataAtual = new Date();
		
		if(dataEntrada.before(dataAtual) || dataSaida.before(dataAtual)) {
			return "Erro na atualizacao\nAtualizacao deve ser feita com datas futuras.!!!";
		} 
		if(!dataSaida.after(dataEntrada)) {
			return "Erro na reserva!\nA data de saida tem que ser posterior a data de entrada!";
		}
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
		return null;
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
