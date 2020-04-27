package PROGRAMACION;

/**
 *
 * @author PC-SOPORTE
 */
public class calculos {

    public static double razones_tim(double tf, double p_cif, double timbre) {

        return timbre = +(tf / p_cif) * 100;
    }

    public static double razon_imp_selec(double isc, double p_cif, double imp) {
        return imp = +(isc / p_cif) * 100;
    }

    public static double razon_dere_aran(double dai, double p_cif, double dere) {
        return dere = +(dai / p_cif) * 100;
    }

    public static double razon_gto_agen(double flete, double p_cif, double gto) {
        return gto = +(flete / p_cif) * 100;
    }

    public double p_cif(double precio, int cantidad, double p_cif) {
        return p_cif = precio * cantidad;
    }

    public double dai(double p_cif, double derecho, double dai) {
        return dai = (p_cif * derecho) / 100;
    }

    public double isc(double p_cif, double selec, double isc) {
        return isc = (p_cif * selec) / 100;
    }

    public double tf(double p_cif, double timbre, double tf) {
        return tf = (p_cif * timbre) / 100;
    }

    public double gto_agen(double p_cif, double gto_agencia, double gto_agen) {
        
        return gto_agen = (p_cif * gto_agencia) / 100;
    }

    public double costo_total(double p_cif, double dai, double isc, double tf, double gastos, double costo) {
        return costo = p_cif + dai + isc + tf + gastos;
    }

    public double costo_unitario(double costo_total, double cantidad, double costo_unita) {
        return costo_unita = costo_total / cantidad;
    }

    public double nose1(double unitario, double nose) {
        return nose = (1 + 0.08) * unitario;
    }

    public double lici(double unitario, double lici) {
        return lici = (1 + 0.10) * unitario;
    }

    public double mayo(double unitario, double mayo) {
        return mayo = (1 + 0.12) * unitario;
    }

    public double pyme(double unitario, double pyme) {
        return pyme = (1 + 0.15) * unitario;
    }

    public double publico(double unitario, double publico) {
        return publico = (1 + 0.17) * unitario;
    }

    public double enemigo(double unitario, double enemigo) {
        return enemigo = (1 + 0.20) * unitario;
    }

    public double malo(double unitario, double malo) {
        return malo = (1 + 0.25) * unitario;
    }
}
