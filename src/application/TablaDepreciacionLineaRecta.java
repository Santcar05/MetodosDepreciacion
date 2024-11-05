package application;

public class TablaDepreciacionLineaRecta {
	private int anio;
    private long cuotaDepreciacion;
    private long depreciacionAcumulada;
    private long valorNeto;

    public TablaDepreciacionLineaRecta(int anio, long cuotaDepreciacion, long depreciacionAcumulada, long valorNeto) {
        this.anio = anio;
        this.cuotaDepreciacion = cuotaDepreciacion;
        this.depreciacionAcumulada = depreciacionAcumulada;
        this.valorNeto = valorNeto;
    }

    public int getAnio() { return anio; }
    public long getCuotaDepreciacion() { return cuotaDepreciacion; }
    public long getDepreciacionAcumulada() { return depreciacionAcumulada; }
    public long getValorNeto() { return valorNeto; }
}
