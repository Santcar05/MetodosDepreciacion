package application;

import java.math.BigDecimal;

public class TablaDepreciacionUnidadesProducidas {
    private int anio;
    private BigDecimal unidadesProducidas;
    private BigDecimal DepreciacionPorUnidad;        // Cambiar de long a BigDecimal
    private BigDecimal depreciacionAcumulada;    // Cambiar de long a BigDecimal
    private BigDecimal valorNeto;
    
    
	

	public TablaDepreciacionUnidadesProducidas(int anio, BigDecimal unidadesProducidas,
			BigDecimal depreciacionPorUnidad, BigDecimal depreciacionAcumulada, BigDecimal valorNeto) {
		super();
		this.anio = anio;
		this.unidadesProducidas = unidadesProducidas;
		DepreciacionPorUnidad = depreciacionPorUnidad;
		this.depreciacionAcumulada = depreciacionAcumulada;
		this.valorNeto = valorNeto;
	}
	public int getAnio() {
		return anio;
	}
	public void setAnio(int anio) {
		this.anio = anio;
	}
	public BigDecimal getUnidadesProducidas() {
		return unidadesProducidas;
	}
	public void setUnidadesProducidas(BigDecimal unidadesProducidas) {
		this.unidadesProducidas = unidadesProducidas;
	}

	public BigDecimal getDepreciacionPorUnidad() {
		return DepreciacionPorUnidad;
	}
	public void setDepreciacionPorUnidad(BigDecimal depreciacionPorUnidad) {
		DepreciacionPorUnidad = depreciacionPorUnidad;
	}
	public BigDecimal getDepreciacionAcumulada() {
		return depreciacionAcumulada;
	}
	public void setDepreciacionAcumulada(BigDecimal depreciacionAcumulada) {
		this.depreciacionAcumulada = depreciacionAcumulada;
	}
	public BigDecimal getValorNeto() {
		return valorNeto;
	}
	public void setValorNeto(BigDecimal valorNeto) {
		this.valorNeto = valorNeto;
	}
    
    
    
}
