package com.HACL.x00238219;

public final class CalculadoraImpuestos {
    private static double totalRenta;
    private static double totalISSS;
    private static double totalAFP;

    private CalculadoraImpuestos(){}

    public static double calcularPago(Empleado emp){
        double pago=0;
        double renta=0;

        if(emp instanceof ServivicioProfesional){
            renta = 0.1*emp.getSalario();
            pago=emp.getSalario()-renta;
            totalRenta=totalRenta+renta;
        }

        else if(emp instanceof PlazaFija){
            double AFP = 0.0625*emp.getSalario();
            double ISSS = 0.03*emp.getSalario();
            double restante = emp.getSalario() - AFP - ISSS;

            if(restante>=0.01 && restante<=472.0)
                renta =0;
            else if(restante>=472.1 && restante<=895.24)
                renta = 0.1*(restante-472)+17.67;
            else if(restante>=895.24 && restante<=2038.10)
                renta = 0.2*(restante-895.24)+60;
            else if(restante>=2038-11)
                renta =0.3*(restante-2038.10)+288.57;

            totalISSS=totalISSS+ISSS;
            totalRenta=totalRenta+renta;
            totalAFP=totalAFP+AFP;

            pago=emp.getSalario()-renta;
        }
        return pago;
    }

    public static String mostrarTotal(){
        return "Renta: "+totalRenta+"\nISSS: "+totalISSS+"\nAFP: "+totalAFP;
    }
}
