public class Testes {
    
    public static void main(String[] args) {
        double Imposto = 1000.00,ValoraPagar,ValorMulta,ValorJurosDia;
        int DiasdeAtraso = 10;
        double PercentagemMultaAtraso = 2.0,PercentagemJurosDia=0.1;
        ValoraPagar = Imposto;
        
        if(DiasdeAtraso > 0){
            ValorMulta = ValoraPagar *(PercentagemMultaAtraso)/100;
            ValoraPagar += ValorMulta;
            ValorJurosDia = Imposto *(PercentagemJurosDia) / 100;
            ValoraPagar += ValorJurosDia * DiasdeAtraso;
            System.out.println("Valor para Pagar hoje: " + ValoraPagar); 
            for(int i = 1;i<5;i++){
                ValoraPagar += ValorJurosDia;
                System.out.println("Valor para pagar hoje+" +i+": "+ ValoraPagar);
            }
        }
    }
    
    
}
