package application;

import java.util.ArrayList;

public class DepreciacionSumaDigitos {
	
	private long valorActivo;
	private long valorResidual;
	private int vidaUtil;
	private TablaDepreciacionSumaDigitos TDSD;
	
	public DepreciacionSumaDigitos() {
		
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

	public TablaDepreciacionSumaDigitos getTDSD() {
		return TDSD;
	}

	public void setTDSD(TablaDepreciacionSumaDigitos tDSD) {
		TDSD = tDSD;
	}
	
	public ArrayList<TablaDepreciacionSumaDigitos> calcularSumaDigitos() {
        ArrayList<TablaDepreciacionSumaDigitos> resultados = new ArrayList<>();
        double factor;
        long depreciacionAcumulada = 0; // Inicializar acumulador
        long valorNeto;
        long cuotaDepreciacion;

        // Calcular para cada año de la vida útil
        for (int i = 0; i < vidaUtil; i++) {
            factor = (double) (vidaUtil - i) / (vidaUtil * (vidaUtil + 1) / 2.0);
            System.out.println(factor);
            long valorActivoMenosResidual = valorActivo - valorResidual;
            cuotaDepreciacion = (long) (valorActivoMenosResidual * factor);
            depreciacionAcumulada += cuotaDepreciacion;
            
            valorNeto = valorActivo - depreciacionAcumulada;

            // Crear un nuevo objeto y añadirlo a la lista
            TablaDepreciacionSumaDigitos registro = new TablaDepreciacionSumaDigitos(
                    i + 1,(double) factor, valorActivoMenosResidual, cuotaDepreciacion, depreciacionAcumulada, valorNeto);
            resultados.add(registro);
        }
        
        return resultados;
    }
	
}
