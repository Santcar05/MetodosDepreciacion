package application;

import java.math.BigDecimal;
import java.util.ArrayList;

public class DepreciacionSumaDigitos {

    private BigDecimal valorActivo;       // Cambiar de long a BigDecimal
    private BigDecimal valorResidual;     // Cambiar de long a BigDecimal
    private int vidaUtil;
    private TablaDepreciacionSumaDigitos TDSD;

    public DepreciacionSumaDigitos() {
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

    public TablaDepreciacionSumaDigitos getTDSD() {
        return TDSD;
    }

    public void setTDSD(TablaDepreciacionSumaDigitos tDSD) {
        TDSD = tDSD;
    }



    public ArrayList<TablaDepreciacionSumaDigitos> calcularSumaDigitos() {
        ArrayList<TablaDepreciacionSumaDigitos> resultados = new ArrayList<>();
        BigDecimal factor;
        BigDecimal depreciacionAcumulada = BigDecimal.ZERO; // Inicializar acumulador
        BigDecimal valorNeto;
        BigDecimal cuotaDepreciacion;

        // Calcular para cada año de la vida útil
        for (int i = 0; i < vidaUtil; i++) {
            // Calcular el factor correctamente usando BigDecimal
            factor = BigDecimal.valueOf((double)(vidaUtil - i) / (vidaUtil * (vidaUtil + 1) / 2.0));

            // Calcular la cuota de depreciación y el valor neto
            BigDecimal valorActivoMenosResidual = valorActivo.subtract(valorResidual);
            cuotaDepreciacion = valorActivoMenosResidual.multiply(factor);

            // Acumular la depreciación
            depreciacionAcumulada = depreciacionAcumulada.add(cuotaDepreciacion);
            valorNeto = valorActivo.subtract(depreciacionAcumulada);

            // Calcular el porcentaje (ejemplo de cálculo, ajuste según sea necesario)
            float porcentaje = factor.floatValue() * 100; // Convertir a porcentaje

            // Crear un nuevo objeto y añadirlo a la lista
            TablaDepreciacionSumaDigitos registro = new TablaDepreciacionSumaDigitos(
                    i + 1, factor.doubleValue(), porcentaje, cuotaDepreciacion, depreciacionAcumulada, valorNeto);
            resultados.add(registro);
        }

        return resultados;
    }
}
