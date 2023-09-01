package desafio1;

public class DesafioJava1 {

	public static void main(String[] args) {

	}

	static boolean esBisiesto(int anio) {
		boolean esBisiesto = false;
		if ((anio % 100 != 0) && (anio % 4 == 0)) {
			esBisiesto = true;
		} else if ((anio % 4 == 0) && (anio % 400 == 0)) {
			esBisiesto = true;
		}
		return esBisiesto;
	}

}
