package application;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Random;

public class DepreciacionUnidadesProducidas {
    private BigDecimal valorActivo;       // Cambiar de long a BigDecimal
    private BigDecimal valorResidual;     // Cambiar de long a BigDecimal
    private int vidaUtil;
    private int capacidad;
    private TablaDepreciacionUnidadesProducidas TDUP;
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
	public TablaDepreciacionUnidadesProducidas getTDUP() {
		return TDUP;
	}
	public void setTDUP(TablaDepreciacionUnidadesProducidas tDUP) {
		TDUP = tDUP;
	}
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}


	public ArrayList<TablaDepreciacionUnidadesProducidas> calcularUnidadesProducidas() {
        ArrayList<TablaDepreciacionUnidadesProducidas> resultados = new ArrayList<>();
        Random random = new Random();
        int sumaTemporal = 0;

        // Generar unidades aleatorias por cada a�o y calcular el total
        ArrayList<Integer> unidadesPorAnio = new ArrayList<>();
        for (int i = 0; i < vidaUtil - 1; i++) { // Generar para todos menos el �ltimo a�o
            int unidadesProducidas = random.nextInt(capacidad / vidaUtil) + 1; // Generar un n�mero entre 1 y la capacidad promedio
            unidadesPorAnio.add(unidadesProducidas);
            sumaTemporal += unidadesProducidas;
        }

        // Ajustar el �ltimo a�o para que la suma total sea igual a la capacidad
        int unidadesUltimoAnio = capacidad - sumaTemporal;
        unidadesPorAnio.add(unidadesUltimoAnio);

        // Calcular la depreciaci�n por unidad
        BigDecimal depreciacionPorUnidad = valorActivo.subtract(valorResidual)
            .divide(BigDecimal.valueOf(capacidad), 2, RoundingMode.HALF_UP);
        System.out.println("Depreciaci�n por unidad: " + depreciacionPorUnidad);

        BigDecimal depreciacionAcumulada = BigDecimal.ZERO;
        BigDecimal cuotaDepreciacion;
        BigDecimal valorNeto;

        // Calcular para cada a�o de la vida �til
        for (int i = 0; i < vidaUtil; i++) {
            int unidadesProducidas = unidadesPorAnio.get(i);

            // Calcular cuota de depreciaci�n y acumulado
            cuotaDepreciacion = depreciacionPorUnidad.multiply(BigDecimal.valueOf(unidadesProducidas));
            depreciacionAcumulada = depreciacionAcumulada.add(cuotaDepreciacion);
            valorNeto = valorActivo.subtract(depreciacionAcumulada);

            // Crear un nuevo registro para la tabla de depreciaci�n
            TablaDepreciacionUnidadesProducidas registro = new TablaDepreciacionUnidadesProducidas(
                i + 1, 
                BigDecimal.valueOf(unidadesProducidas),
                depreciacionPorUnidad,
                depreciacionAcumulada,
                valorNeto
            );
            resultados.add(registro);
        }

        return resultados;
    }

}
