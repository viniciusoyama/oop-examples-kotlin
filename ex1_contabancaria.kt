/**
 * Conta corrente SCD
 */

class Cliente {
    private var nome: String;
	
    constructor(_nome: String) {
        this.nome = _nome;
    }
    
    public fun getNome(): String {
        return this.nome;
    }
}


open class ContaBancaria {
    private var dona: Cliente;
    private var saldo: Double;
	
    constructor(_dona: Cliente, _saldoInicial: Double = 0.0) {
        this.dona = _dona;
        this.saldo = _saldoInicial;
    }
    
    
    public fun getDona(): Cliente {
        return this.dona;
    }
    
    public open fun getLimiteDeCredito(): Double {
        return 0.0;
    }

    public fun getSaldo() : Double {
		return this.saldo;
    }
}

fun main() {
	mainCliente()
  mainContaBancaria()

}

fun mainCliente() {
    println("----- Main Cliente -----")
    var lidia = Cliente("Lidia Lourane")
    var vitoria = Cliente("Vitória da Vinci")
    
    println(lidia.getNome())
    println(vitoria.getNome())
    println("==============================\n\n")

}


fun mainContaBancaria() {
    println("----- Main Poupanca -----")
    var lidia = Cliente("Lidia Lourane")
    var vanessa = Cliente("Vitória da Vinci")

    var contaLidia = ContaBancaria(lidia, 100.0)
    var contaVanessa = ContaBancaria(vanessa)
    
    println("Saldo Lidia:" + contaLidia.getSaldo())
    println("Saldo Vanessa:" + contaVanessa.getSaldo())
    println("==============================\n\n")
}

