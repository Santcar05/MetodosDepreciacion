package application;

import java.math.BigDecimal;
import java.util.ArrayList;

public class DepreciacionReduccionSaldos {
    private BigDecimal valorActivo;       // Cambiar de long a BigDecimal
    private BigDecimal valorResidual;     // Cambiar de long a BigDecimal
    private int vidaUtil;
    private TablaDepreciacionReduccionSaldos TDRS;

    public DepreciacionReduccionSaldos() {
        // Inicializar valores por defecto si es necesario
        this.valorActivo = BigDecimal.ZERO;
        this.valorResidual = BigDecimal.ZERO;
    }

    public BigDecimal getValorActivo() {
        return valorActivo;
    }

    public void setValorActivo(BigDecimal valorActivo) {
        this.valorActivo = valorActivo;
    }

    public BigDecimal getValorResidual() {
        return valorResidual;
    }

    public void setValorResidual(BigDecimal valorResidual) {
        this.valorResidual = valorResidual;
    }

    public int getVidaUtil() {
        return vidaUtil;
    }

    public void setVidaUtil(int vidaUtil) {
        this.vidaUtil = vidaUtil;
    }
    public TablaDepreciacionReduccionSaldos getTDRS() {
		return TDRS;
	}

	public void setTDRS(TablaDepreciacionReduccionSaldos tDRS) {
		TDRS = tDRS;
	}

	public ArrayList<TablaDepreciacionReduccionSaldos> calcularReduccionSaldos() {
        ArrayList<TablaDepreciacionReduccionSaldos> resultados = new ArrayList<>();
        BigDecimal tasaDepreciacion;
        BigDecimal valorSinDepreciar = valorActivo;
        BigDecimal cuotaDepreciacion =  null;
        BigDecimal depreciacionAcumulada = BigDecimal.ZERO;
        BigDecimal valorNeto;

        // Calcular la tasa de depreciación base
        double base = valorResidual.divide(valorActivo, BigDecimal.ROUND_HALF_UP).doubleValue();
        tasaDepreciacion = BigDecimal.valueOf(1.0).subtract(BigDecimal.valueOf(Math.pow(base, 1.0 / vidaUtil)));

        // Calcular para cada año de la vida útil
        for (int i = 0; i < vidaUtil; i++) {
            // Hallar valor sin depreciar
            valorSinDepreciar = valorSinDepreciar.subtract(cuotaDepreciacion != null ? cuotaDepreciacion : BigDecimal.ZERO);
            
            // Hallar cuota de depreciación
            cuotaDepreciacion = valorSinDepreciar.multiply(tasaDepreciacion);
            
            // Acumular la depreciación
            depreciacionAcumulada = depreciacionAcumulada.add(cuotaDepreciacion);
            
            // Calcular el valor neto
            valorNeto = valorActivo.subtract(depreciacionAcumulada);
            
            // Calcular porcentaje de depreciación
            double porcentaje = tasaDepreciacion.doubleValue() * 100; // Convertir a porcentaje
            
            // Crear un nuevo registro para la tabla de depreciación
            TablaDepreciacionReduccionSaldos registro = new TablaDepreciacionReduccionSaldos(
                    i + 1, tasaDepreciacion.doubleValue(), porcentaje, cuotaDepreciacion, depreciacionAcumulada, valorNeto);
            resultados.add(registro);
        }

        return resultados;
    }
}
