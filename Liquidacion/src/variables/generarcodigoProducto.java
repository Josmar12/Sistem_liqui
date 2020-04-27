
package variables;

public class generarcodigoProducto {

    //generar codigo 
    private int dato;
    private int cont = 1;
    private String num = "";

    public void generar(int dato) {

        this.dato = dato;
        if ((this.dato >= 9999) && (this.dato < 99999)) {
            int can = cont + this.dato;
            num = "" + can;
        }

        if ((this.dato >= 999) && (this.dato < 9999)) {
            int can = cont + this.dato;
            num = "0" + can;
        }
        if ((this.dato >= 99) && (this.dato < 999)) {
            int can = cont + this.dato;
            num = "00" + can;
        }
        if ((this.dato >= 9) && (this.dato < 99)) {
            int can = cont + this.dato;
            num = "000" + can;
        }
        if (this.dato < 9) {
            int can = cont + this.dato;
            num = "0000" + can;
        }

    }

    public String serie() {
        return this.num;
    }
}
