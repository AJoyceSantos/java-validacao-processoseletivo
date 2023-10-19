 package candidatura;
 import java.util.Random;
 import java.util.concurrent.ThreadLocalRandom;
 public class ProcessoSeletivo {
    public static void main(String[] args) {
        String [] candidatos = {"FELIPE", "MARCIO", "JULIA", "MARCOS", "PAULA"};
        for(String candidato: candidatos){
            entrandoEmContato(candidato);

        }

    }
    static void entrandoEmContato(String candidato){
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;
        do{
            atendeu = atender();
            continuarTentando = !atendeu;
            if (continuarTentando)
                tentativasRealizadas++;
            else
                System.out.println("CONTATO REALIZADO COM SUCESSO");

        }while (continuarTentando && tentativasRealizadas <3);
        if (atendeu)
            System.out.println("CONSEGUIMOS CONTATO COM " + candidato + " NA " + tentativasRealizadas);
        else
            System.out.println("NAO CONSEGUIMOS CONTATO COM " + candidato + " NUMERO MAXIMO DE TENTATIVAS" + tentativasRealizadas);

    }
    static boolean atender(){
        return new Random().nextInt(3) == 1;
    }
    static void imprimirSelecionador(){
        String [] candidatos = {"FELIPE", "MARCIO", "JULIA", "MARCOS", "PAULA"};
        System.out.println("Lista de candidatos informando o indice");
        for (int indice=0;indice < candidatos.length; indice++){
            System.out.println("O candidato de nº " + (indice+1) + "é" + candidatos[indice]);
        }
        System.out.println("Forma abraviada de interaçao dor each");
        for (String candidato: candidatos){
            System.out.println("O candidato selecionado foi " + candidato );
        }

    }
    static void selecaoCandidatos(){
        String [] candidatos = {"FELIPE", "MARCIO", "JULIA", "MARCOS", "PAULA", "FABRICIO", "MILENA","ROBERTA","SARA","AMANDA","JORGE"};
        int candidatosSelecionados =0;
        int candidatoAtual =0;
        double salarioBase  = 2000.0;
        while(candidatosSelecionados < 5 && candidatoAtual < candidatos.length){
            String candidato = candidatos[candidatoAtual];
            double salarioPretendito = valorPretendido();
            System.out.println("O candidato " + candidato + " solicitou este valor de salario " + salarioPretendito);

            if (salarioBase >= salarioPretendito){
                System.out.println("O candidato " + candidato + " foi selecionado");
                candidatosSelecionados++;
            }
            candidatoAtual++;
        }
    }
    static double valorPretendido(){
        return ThreadLocalRandom.current().nextDouble(1800,2200);
    }
    static void analisarCandidato(double salarioPretendido) {
        double salarioBase = 2000.0;
        if (salarioBase > salarioPretendido) {
            System.out.println("LIGAR PARA O CANDIDATO");
        } else if (salarioBase == salarioPretendido)
            System.out.println("LIGAR PARA O CANDIDATO COM CONTRA PROPOSTA");
        else {
            System.out.println("AGUARDANDO O RESULTADO DOS DEMAIS CANDIDATOS");
        }
    }
}
