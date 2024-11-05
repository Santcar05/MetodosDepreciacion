package application;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
	    BigDecimal valorSinDepreciar = valorActivo;
	    BigDecimal cuotaDepreciacion = BigDecimal.ZERO;
	    BigDecimal depreciacionAcumulada = BigDecimal.ZERO;
	    BigDecimal valorNeto;

	    // Calcular la tasa de depreciación usando BigDecimal en todas las operaciones
	    BigDecimal base = valorResidual.divide(valorActivo, 10, RoundingMode.HALF_UP); // precisión de 10 decimales
	    BigDecimal exponent = BigDecimal.valueOf(1.0 / vidaUtil);
	    BigDecimal tasaDepreciacion = BigDecimal.ONE.subtract(
	            BigDecimal.valueOf(Math.pow(base.doubleValue(), exponent.doubleValue()))
	    );

	    // Calcular para cada año de la vida útil
	    for (int i = 0; i < vidaUtil; i++) {
	        // Hallar valor sin depreciar
	        valorSinDepreciar = valorSinDepreciar.subtract(cuotaDepreciacion);

	        // Hallar cuota de depreciación
	        cuotaDepreciacion = valorSinDepreciar.multiply(tasaDepreciacion).setScale(2, RoundingMode.HALF_UP);

	        // Acumular la depreciación
	        depreciacionAcumulada = depreciacionAcumulada.add(cuotaDepreciacion);

	        // Calcular el valor neto
	        valorNeto = valorActivo.subtract(depreciacionAcumulada).setScale(2, RoundingMode.HALF_UP);

	        // Calcular porcentaje de depreciación
	        double porcentaje = tasaDepreciacion.multiply(BigDecimal.valueOf(100)).doubleValue();

	        // Crear un nuevo registro para la tabla de depreciación
	        TablaDepreciacionReduccionSaldos registro = new TablaDepreciacionReduccionSaldos(
	                i + 1, tasaDepreciacion.doubleValue(), porcentaje, cuotaDepreciacion, depreciacionAcumulada, valorNeto);
	        resultados.add(registro);
	    }

	    return resultados;
	}

}
