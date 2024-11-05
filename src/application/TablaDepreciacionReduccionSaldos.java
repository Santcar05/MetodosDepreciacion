package application;

import java.math.BigDecimal;

public class TablaDepreciacionReduccionSaldos {
	private int anio;                   // Año de la depreciación
    private double tasaDepreciacion;    // Tasa de depreciación
    private double porcentaje;           // Porcentaje de depreciación
    private BigDecimal cuotaDepreciacion;  // Cuota de depreciación
    private BigDecimal depreciacionAcumulada; // Depreciación acumulada
    private BigDecimal valorNeto;       // Valor neto después de la depreciación
    
    
	
    public TablaDepreciacionReduccionSaldos(int anio, double tasaDepreciacion, double porcentaje,
			BigDecimal cuotaDepreciacion, BigDecimal depreciacionAcumulada, BigDecimal valorNeto) {
		super();
		this.anio = anio;
		this.tasaDepreciacion = tasaDepreciacion;
		this.porcentaje = porcentaje;
		this.cuotaDepreciacion = cuotaDepreciacion;
		this.depreciacionAcumulada = depreciacionAcumulada;
		this.valorNeto = valorNeto;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public double getTasaDepreciacion() {
		return tasaDepreciacion;
	}

	public void setTasaDepreciacion(double tasaDepreciacion) {
		this.tasaDepreciacion = tasaDepreciacion;
	}

	public double getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(double porcentaje) {
		this.porcentaje = porcentaje;
	}

	public BigDecimal getCuotaDepreciacion() {
		return cuotaDepreciacion;
	}

	public void setCuotaDepreciacion(BigDecimal cuotaDepreciacion) {
		this.cuotaDepreciacion = cuotaDepreciacion;
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
