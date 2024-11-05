package application;

public class TablaDepreciacionSumaDigitos {
	private int anio;
	private double factor;
	private float porcentaje;
    private long cuotaDepreciacion;
    private long depreciacionAcumulada;
    private long valorNeto;
    
    public TablaDepreciacionSumaDigitos() {
    	
    }
	
	public TablaDepreciacionSumaDigitos(int anio, double factor, float porcentaje, long cuotaDepreciacion,
			long depreciacionAcumulada, long valorNeto) {
		super();
		this.anio = anio;
		this.factor = factor;
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
	public double getFactor() {
		return factor;
	}
	public void setFactor(double factor) {
		this.factor = factor;
	}
	public float getPorcentaje() {
		return porcentaje;
	}
	public void setPorcentaje(float porcentaje) {
		this.porcentaje = porcentaje;
	}
	public long getCuotaDepreciacion() {
		return cuotaDepreciacion;
	}
	public void setCuotaDepreciacion(long cuotaDepreciacion) {
		this.cuotaDepreciacion = cuotaDepreciacion;
	}
	public long getDepreciacionAcumulada() {
		return depreciacionAcumulada;
	}
	public void setDepreciacionAcumulada(long depreciacionAcumulada) {
		this.depreciacionAcumulada = depreciacionAcumulada;
	}
	public long getValorNeto() {
		return valorNeto;
	}
	public void setValorNeto(long valorNeto) {
		this.valorNeto = valorNeto;
	}
    
    
    
}
