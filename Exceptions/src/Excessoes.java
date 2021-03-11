public class Excessoes {
    public static void main(String[] args) {
        Conta conta1 = new Conta("Adalberto", (float) 500.00); //inicializaçao de conta
        Conta conta2 = new Conta("Mandela", (float) 3000.00); //inicializaçao de conta

	/* testes de exceçoes*/
        try {
            conta1.sacar(2000.00f);
        } catch (SaqueNegativoException negative) {
            System.out.println(negative);
        } catch (SaldoInsuficienteException saldo) {
            System.out.println(saldo);
        }

        try {
            conta2.sacar(-2000.00f);
        } catch (SaqueNegativoException negative) {
            System.out.println(negative);
        } catch (SaldoInsuficienteException saldo) {
            System.out.println(saldo);
        }

        try {
            conta2.sacar(2000.00f);
        } catch (SaqueNegativoException negative) {
            System.out.println(negative);
        } catch (SaldoInsuficienteException saldo) {
            System.out.println(saldo);
        }
    }

}
