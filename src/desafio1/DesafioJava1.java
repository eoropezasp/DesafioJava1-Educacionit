package desafio1;

import java.util.Scanner;

public class DesafioJava1 {
	static Scanner input = new Scanner(System.in);
	static final int FEBRERO = 2;
	static final int DIA_MAX_NO_BISIESTO = 28;
	static final int DIA_MAX_F_BISIESTO = 29;

	public static void main(String[] args) {

		final int DIA_MIN = 1, DIA_MAX = 31;
		final int MES_MIN = 1, MES_MAX = 12;
		final int ANIO_MIN = 1900, ANIO_MAX = 2099;

		int dia, mes, anio = 0;

		dia = pedirIngreso("dia", DIA_MIN, DIA_MAX);
		mes = pedirIngreso("mes", MES_MIN, MES_MAX);

		
		/* valida que febrero no tenga mas de 29 dias */
		do {
			if (mes == FEBRERO && dia > DIA_MAX_F_BISIESTO) {
				System.out.println("febrero no puede tener mas de 29 dias");
				dia = pedirIngreso("dia", DIA_MIN, DIA_MAX_F_BISIESTO);
			}
		} while (mes == FEBRERO && dia > DIA_MAX_F_BISIESTO);

		
		
		
		
		/* Si febrero tiene 29 dias verifica que sea un Año bisiesto */
		if (mes == FEBRERO && dia == DIA_MAX_F_BISIESTO) {
			System.out.println("febrero solo puede tener 29 dias si el año es bisiesto");
			anio = pedirIngreso("año", ANIO_MIN, ANIO_MAX);
			if (!esBisiesto(anio)) {
				System.out.println("el año NO es bisiesto por lo tanto febrero tiene 28 dias");
				dia = pedirIngreso("dia", DIA_MIN, DIA_MAX_NO_BISIESTO);
			}
		}

		
		
		/* Si hasta el aqui no ingreso un año valido, lo pide */
		if (anio == 0) {
			anio = pedirIngreso("año", ANIO_MIN, ANIO_MAX);
		}

		/* Mensaje si el año es bisiesto */
		if (esBisiesto(anio)) {
			System.out.println("El año es Bisiesto");
		}
		
		
		System.out.println("la fecha es: " + dia + "/" + mes + "/" + anio);

		input.close();
	}
//
//	
//	
//	
//	
//	
//	
//	

	static int pedirIngreso(String tipo, int min, int max) {
		System.out.println("ingrese el " + tipo + " entre " + min + " y " + max);
		int ingreso = Integer.parseInt(input.nextLine());
		ingreso = validarIngreso(ingreso, tipo, min, max);
		return ingreso;
	}

	static int validarIngreso(int ingreso, String tipo, int min, int max) {
		boolean esValido = ((ingreso >= min) && (ingreso <= max));
		while (!esValido) {
			System.out.println(
					"Error, el " + tipo + " debe estar en rango de: " + min + " y " + max + " , Ingrese nuevamente");
			ingreso = Integer.parseInt(input.nextLine());
			esValido = ((ingreso >= min) && (ingreso <= max));
		}

		return ingreso;
	}

	static boolean esBisiesto(int anio) {
		boolean bisiesto = false;
		if ((anio % 100 != 0) && (anio % 4 == 0)) {
			bisiesto = true;
		} else if ((anio % 4 == 0) && (anio % 400 == 0)) {
			bisiesto = true;
		}
		return bisiesto;
	}

}
