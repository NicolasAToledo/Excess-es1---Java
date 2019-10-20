package model.entidade;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import model.excessoes.DominioExcessao;

public class Reserva {
	
	private Integer numeroQuarto;
	private Date dataEntrada;
	private Date dataSaida;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reserva(Integer numeroQuarto, Date dataEntrada, Date dataSaida)  {
		if(!dataSaida.after(dataEntrada)) {
			throw new DominioExcessao("Erro na reserva! A data de saida tem que ser posterior a data de entrada!");
		}
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
	
	public void  atualizacaoHospedagem(Date dataEntrada, Date dataSaida){
		Date dataAtual = new Date();
		
		if(dataEntrada.before(dataAtual) || dataSaida.before(dataAtual)) {
			throw new DominioExcessao("Erro de atualizacao! Atualizacao deve ser feita com datas futuras.!!!");
		} 
		
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
