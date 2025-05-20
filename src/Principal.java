import com.google.gson.JsonObject;

import java.io.IOException;
import java.util.Scanner;

import static Modulos.ExchangeAPI.buscarTaxas;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        JsonObject taxasUSD = buscarTaxas("USD");
        JsonObject taxasARS = buscarTaxas("ARS");
        JsonObject taxasBRL = buscarTaxas("BRL");
        JsonObject taxasCOP = buscarTaxas("COP");

        //Colombiano para Dolar
        double usdCOP = taxasCOP.get("USD").getAsDouble();
        // Real para dolar
        double usdBR = taxasBRL.get("USD").getAsDouble();
        //Peso argentino para dolar
        double usdARS = taxasARS.get("USD").getAsDouble();


        //Dolar para moeda selecionada
        double brl = taxasUSD.get("BRL").getAsDouble();
        double cop = taxasUSD.get("COP").getAsDouble();
        double ars = taxasUSD.get("ARS").getAsDouble();

        Scanner scanner = new Scanner(System.in);

        int opcao = 0;

        while (opcao != 7) {
            System.out.println("""
                    ╔════════════════════════════════════════════╗
                    ║         CONVERSOR DE MOEDAS – CLI          ║
                    ╠════════════════════════════════════════════╣
                    ║ Escolha uma opção:                         ║
                    ║                                            ║
                    ║  1. Dólar            =>> Peso Argentino    ║
                    ║  2. Peso Argentino   =>> Dólar             ║
                    ║  3. Dólar            =>> Real Brasileiro   ║
                    ║  4. Real Brasileiro  =>> Dólar             ║
                    ║  5. Dólar            =>> Peso Colombiano   ║
                    ║  6. Peso Colombiano  =>> Dólar             ║
                    ║  7. Sair                                   ║
                    ║                                            ║
                    ╚════════════════════════════════════════════╝
                    """);
            System.out.println("Digite a opção desejada: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("""
                            ╔════════════════════════════════════════════╗
                            ║         CONVERSOR DE MOEDAS – CLI          ║
                            ╠════════════════════════════════════════════╣
                             7. Sair
                             Digite o valor da conversão:
                            """);
                    double valor = scanner.nextDouble();

                    double resposta = valor * ars;

                    String tela = String.format("""
                            ╔════════════════════════════════════════════╗
                            ║         CONVERSOR DE MOEDAS – CLI          ║
                            ╠════════════════════════════════════════════╣
                            ║ Escolha uma opção:                         ║
                            ║                                            ║
                            ║  Você escolheu: Dólar => Peso Argentino    ║
                            ║   Resultado:  %.2f ARS                     ║
                            ║   7. Sair                                  ║
                            ╚════════════════════════════════════════════╝
                            """, resposta);

                    System.out.println(tela);
                    break;
                case 2:
                    System.out.println("""
                            ╔════════════════════════════════════════════╗
                            ║         CONVERSOR DE MOEDAS – CLI          ║
                            ╠════════════════════════════════════════════╣
                             7. Sair
                             Digite o valor da conversão:
                            """);
                    double valorARSUSD = scanner.nextDouble();

                    double respostaARSUSD = valorARSUSD * usdARS;

                    String telaARSUSD = String.format("""
                            ╔════════════════════════════════════════════╗
                            ║         CONVERSOR DE MOEDAS – CLI          ║
                            ╠════════════════════════════════════════════╣
                            ║ Escolha uma opção:                         ║
                            ║                                            ║
                            ║  Você escolheu: Peso Argentino =>   Dólar  ║
                            ║   Resultado:  %f USD                       ║
                            ║   7. Sair                                  ║
                            ╚════════════════════════════════════════════╝
                            """, respostaARSUSD);

                    System.out.println(telaARSUSD);
                    break;

                case 3:
                    System.out.println("""
                            ╔════════════════════════════════════════════╗
                            ║         CONVERSOR DE MOEDAS – CLI          ║
                            ╠════════════════════════════════════════════╣
                             7. Sair
                             Digite o valor da conversão:
                            """);

                    double valorUSDBRL = scanner.nextDouble();
                    double respostaUSDBRL = valorUSDBRL * brl;

                    String telaUSDBRL = String.format("""
                            ╔════════════════════════════════════════════╗
                            ║         CONVERSOR DE MOEDAS – CLI          ║
                            ╠════════════════════════════════════════════╣
                            ║ Escolha uma opção:                         ║
                            ║                                            ║
                            ║  Você escolheu: Dolar =>   Real            ║
                            ║   Resultado:  %.2f BRL                     ║
                            ║   7. Sair                                  ║
                            ╚════════════════════════════════════════════╝
                            """, respostaUSDBRL);

                    System.out.println(telaUSDBRL);
                    break;
                case 4:
                    System.out.println("""
                            ╔════════════════════════════════════════════╗
                            ║         CONVERSOR DE MOEDAS – CLI          ║
                            ╠════════════════════════════════════════════╣
                             7. Sair
                             Digite o valor da conversão:
                            """);

                    double valorBRLUSD = scanner.nextDouble();
                    double respostaBRLUSD = valorBRLUSD * usdBR;

                    String telaBRLUSD = String.format("""
                            ╔════════════════════════════════════════════╗
                            ║         CONVERSOR DE MOEDAS – CLI          ║
                            ╠════════════════════════════════════════════╣
                            ║ Escolha uma opção:                         ║
                            ║                                            ║
                            ║  Você escolheu:  Real =>     Dolar         ║
                            ║   Resultado:  %.2f USD                     ║
                            ║   7. Sair                                  ║
                            ╚════════════════════════════════════════════╝
                            """, respostaBRLUSD);

                    System.out.println(telaBRLUSD);
                    break;
                case 5:
                    System.out.println("""
                            ╔════════════════════════════════════════════╗
                            ║         CONVERSOR DE MOEDAS – CLI          ║
                            ╠════════════════════════════════════════════╣
                             7. Sair
                             Digite o valor da conversão:
                            """);

                    double valorUSDCOP = scanner.nextDouble();
                    double respostaUSDCOP = valorUSDCOP * cop;

                    String telaUSDCOP = String.format("""
                            ╔════════════════════════════════════════════╗
                            ║         CONVERSOR DE MOEDAS – CLI          ║
                            ╠════════════════════════════════════════════╣
                            ║ Escolha uma opção:                         ║
                            ║                                            ║
                            ║  Você escolheu:  Dolar =>  Peso Colombiano ║
                            ║   Resultado:  %.2f COP                     ║
                            ║   7. Sair                                  ║
                            ╚════════════════════════════════════════════╝
                            """, respostaUSDCOP);

                    System.out.println(telaUSDCOP);
                    break;
                case 6:
                    System.out.println("""
                            ╔════════════════════════════════════════════╗
                            ║         CONVERSOR DE MOEDAS – CLI          ║
                            ╠════════════════════════════════════════════╣
                             7. Sair
                             Digite o valor da conversão:
                            """);

                    double valorCOPUSD = scanner.nextDouble();
                    double respostaCOPUSD = valorCOPUSD * usdCOP;

                    String telaCOPUSD = String.format("""
                            ╔════════════════════════════════════════════╗
                            ║         CONVERSOR DE MOEDAS – CLI          ║
                            ╠════════════════════════════════════════════╣
                            ║ Escolha uma opção:                         ║
                            ║                                            ║
                            ║  Você escolheu:  Peso Colombiano => Dolar  ║
                            ║   Resultado:  %f USD                       ║
                            ║   7. Sair                                  ║
                            ╚════════════════════════════════════════════╝
                            """, respostaCOPUSD);

                    System.out.println(telaCOPUSD);
                    break;
                case 7:
                    System.out.println
                            ("╔══════════════════════════════════════════════════╗\n" +
                             "║ OBRIGADO POR UTILIZAR NOSSO CONVERSOR DE MOEDAS! ║\n" +
                             "╠══════════════════════════════════════════════════╣");
                    break;
                default:
                    System.out.println
                            ("╔════════════════════════════════════════════╗\n" +
                            "║       OPÇÃO INVÁLIDA. TENTE NOVAMENTE!     ║\n" +
                            "╠════════════════════════════════════════════╣");
            }
        }
    }
}
