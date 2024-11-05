package application;

import java.math.BigDecimal;

public class TablaDepreciacionLineaRecta {
    private int anio;
    private BigDecimal cuotaDepreciacion;      // Cambiar de long a BigDecimal
    private BigDecimal depreciacionAcumulada;  // Cambiar de long a BigDecimal
    private BigDecimal valorNeto;               // Cambiar de long a BigDecimal

    public TablaDepreciacionLineaRecta(int anio, BigDecimal cuotaDepreciacion, BigDecimal depreciacionAcumulada, BigDecimal valorNeto) {
        this.anio = anio;
        this.cuotaDepreciacion = cuotaDepreciacion;
        this.depreciacionAcumulada = depreciacionAcumulada;
        this.valorNeto = valorNeto;
    }

    public int getAnio() {
        return anio;
    }

    public BigDecimal getCuotaDepreciacion() {
        return cuotaDepreciacion;
    }

    public BigDecimal getDepreciacionAcumulada() {
        return depreciacionAcumulada;
    }

    public BigDecimal getValorNeto() {
        return valorNeto;
    }
}
