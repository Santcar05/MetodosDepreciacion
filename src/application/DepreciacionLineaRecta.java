package application;

import java.util.ArrayList;

public class DepreciacionLineaRecta {
	
	private long valorActivo;
	private long valorResidual;
	private int vidaUtil;
	private TablaDepreciacionLineaRecta TDLR;
	
	
	public DepreciacionLineaRecta() {
		super();
	}
	public DepreciacionLineaRecta(long valorActivo, long valorResidual, int vidaUtil) {
		super();
		this.valorActivo = valorActivo;
		this.valorResidual = valorResidual;
		this.vidaUtil = vidaUtil;
	}
	public long getValorActivo() {
		return valorActivo;
	}
	public void setValorActivo(long valorActivo) {
		this.valorActivo = valorActivo;
	}
	public long getValorResidual() {
		return valorResidual;
	}
	public void setValorResidual(long valorResidual) {
		this.valorResidual = valorResidual;
	}
	public int getVidaUtil() {
		return vidaUtil;
	}
	public void setVidaUtil(int vidaUtil) {
		this.vidaUtil = vidaUtil;
	}

	public ArrayList<TablaDepreciacionLineaRecta> calcularLineaRecta() throws Exception{
        ArrayList<TablaDepreciacionLineaRecta> listaDepreciacion = new ArrayList<>();
        long cuotaDepreciacion = (valorActivo - valorResidual) / vidaUtil;
        long depreciacionAcumulada = 0;
        long valorNeto = valorActivo;

        for (int i = 0; i < vidaUtil; i++) {
        	System.out.println(i);
            depreciacionAcumulada += cuotaDepreciacion;
            valorNeto = valorActivo - depreciacionAcumulada;
            listaDepreciacion.add(new TablaDepreciacionLineaRecta(i + 1, cuotaDepreciacion, depreciacionAcumulada, valorNeto));
        }
        for(TablaDepreciacionLineaRecta r: listaDepreciacion)
        	System.out.println(r.getDepreciacionAcumulada());
        return listaDepreciacion;
    }
	

}
