package application;

import java.math.BigDecimal;

public class TablaDepreciacionSumaDigitos {
    private int anio;
    private double factor;
    private float porcentaje;
    private BigDecimal cuotaDepreciacion;        // Cambiar de long a BigDecimal
    private BigDecimal depreciacionAcumulada;    // Cambiar de long a BigDecimal
    private BigDecimal valorNeto;                 // Cambiar de long a BigDecimal

    public TablaDepreciacionSumaDigitos() {
    }

    public TablaDepreciacionSumaDigitos(int anio, double factor, float porcentaje, BigDecimal cuotaDepreciacion,
            BigDecimal depreciacionAcumulada, BigDecimal valorNeto) {
        super();
        this.anio = anio;
        this.factor = factor;
        this.porcentaje = porcentaje;
        this.cuotaDepreciacion = cuotaDepreciacion;
        this.depreciacionAcumulada = depreciacionAcumulada;
        this.valorNeto = valorNeto;
    }

    public TablaDepreciacionSumaDigitos(int i, double doubleValue, BigDecimal valorActivoMenosResidual,
			BigDecimal cuotaDepreciacion2, BigDecimal depreciacionAcumulada2, BigDecimal valorNeto2) {
		// TODO Auto-generated constructor stub
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
