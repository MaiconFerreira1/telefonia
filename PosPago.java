import java.util.Date;

class PosPago extends Assinante {
    private float assinatura;

    public PosPago(long cpf, String nome, int numero, float assinatura) {
        super(cpf, nome, numero);
        this.assinatura = assinatura;
    }

    public void fazerChamada(Date data, int duracao) {
        if (numChamadas < 100) {
            chamadas.add(new Chamada(data, duracao));
            numChamadas++;
        } else {
            System.out.println("Limite de chamadas excedido.");
        }
    }

    public void imprimirFatura(int mes) {
        System.out.println("Fatura Pós-Pago - " + nome);
        System.out.println("CPF: " + cpf + ", Número: " + numero);
        System.out.println("Chamadas:");
        float totalChamadas = 0;
        for (Chamada chamada : chamadas) {
            if (chamada.getData().getMonth() + 1 == mes) {
                System.out.println(chamada);
                totalChamadas += chamada.getDuracao() * 1.04f;
            }
        }
        System.out.println("Total Chamadas: R$ " + totalChamadas);
        System.out.println("Valor Assinatura: R$ " + assinatura);
        System.out.println("Total Fatura: R$ " + (totalChamadas + assinatura));
    }
}