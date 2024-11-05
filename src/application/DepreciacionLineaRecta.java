package application;

import java.math.BigDecimal;
import java.util.ArrayList;

public class DepreciacionLineaRecta {

    private BigDecimal valorActivo;       // Cambiar de long a BigDecimal
    private BigDecimal valorResidual;     // Cambiar de long a BigDecimal
    private int vidaUtil;
    private TablaDepreciacionLineaRecta TDLR;

    public DepreciacionLineaRecta() {
        super();
        this.valorActivo = BigDecimal.ZERO; // Inicializar a cero
        this.valorResidual = BigDecimal.ZERO; // Inicializar a cero
    }

    public DepreciacionLineaRecta(BigDecimal valorActivo, BigDecimal valorResidual, int vidaUtil) {
        super();
        this.valorActivo = valorActivo;
        this.valorResidual = valorResidual;
        this.vidaUtil = vidaUtil;
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

    public ArrayList<TablaDepreciacionLineaRecta> calcularLineaRecta() throws Exception {
        ArrayList<TablaDepreciacionLineaRecta> listaDepreciacion = new ArrayList<>();
        
        // Calcular cuota de depreciación
        BigDecimal cuotaDepreciacion = valorActivo.subtract(valorResidual).divide(BigDecimal.valueOf(vidaUtil), BigDecimal.ROUND_HALF_UP);
        BigDecimal depreciacionAcumulada = BigDecimal.ZERO;
        BigDecimal valorNeto = valorActivo;

        for (int i = 0; i < vidaUtil; i++) {
            System.out.println(i);
            depreciacionAcumulada = depreciacionAcumulada.add(cuotaDepreciacion);
            valorNeto = valorActivo.subtract(depreciacionAcumulada);
            listaDepreciacion.add(new TablaDepreciacionLineaRecta(i + 1, cuotaDepreciacion, depreciacionAcumulada, valorNeto));
        }

        for (TablaDepreciacionLineaRecta r : listaDepreciacion) {
            System.out.println(r.getDepreciacionAcumulada());
        }
        
        return listaDepreciacion;
    }
}
