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
    
    public fun transferirPara(destino: ContaBancaria, valor: Double): Boolean {
        var podeTransferir = (this.getLimiteDeCredito() + this.saldo) - valor > 0
        if (podeTransferir) {
    	    this.saldo -= valor
	        destino.adicionarSaldo(valor)    
   			return true;
        } else {
            return false;
        }
    }
    
    public fun adicionarSaldo(valor: Double) {
        this.saldo += valor
    }

    public fun getSaldo() : Double {
		    return this.saldo;
    }
}

class ContaPoupanca : ContaBancaria {
    constructor(_dona: Cliente, _saldoInicial: Double = 0.0): super(_dona, _saldoInicial) {
    }
}


class ContaCorrente : ContaBancaria {
    
    constructor(_dona: Cliente, _saldoInicial: Double = 0.0): super(_dona, _saldoInicial) {
    }
    
    override fun getLimiteDeCredito(): Double {
      return 100.0
    }
}

fun main() {   
  mainTransferenciaOKSemUsarLimite()   
  mainTransferenciaNaoOK()
  mainTransferenciaUsandoLimite()
}


fun mainTransferenciaOKSemUsarLimite() {
	println("----- Main mainTransferenciaOK -----")
    var lidia = Cliente("Lidia Lourane")
    var vanessa = Cliente("Vanessa")
    var contaLidia = ContaCorrente(lidia, 0.0)
    var contaVanessa = ContaPoupanca(vanessa, 100.0)
    
    println("Saldo Inicial Lidia:" + contaLidia.getSaldo())
    println("Saldo Inicial Vanessa:" + contaVanessa.getSaldo())
    println("Transferencia com sucesso?: " + contaVanessa.transferirPara(contaLidia, 30.0))
    println("Saldo Final Lidia:" + contaLidia.getSaldo())
    println("Saldo Final Vanessa:" + contaVanessa.getSaldo())

    println("==============================\n\n")
}

fun mainTransferenciaNaoOK() {
	println("----- Main mainTransferenciaNaoOK -----")
    var lidia = Cliente("Lidia Lourane")
    var vanessa = Cliente("Vanessa")
    var contaLidia = ContaCorrente(lidia, 0.0)
    var contaVanessa = ContaPoupanca(vanessa, 100.0)
    
    println("Saldo Inicial Lidia:" + contaLidia.getSaldo())
    println("Saldo Inicial Vanessa:" + contaVanessa.getSaldo())
    println("Transferencia com sucesso?: " + contaVanessa.transferirPara(contaLidia, 230.0))
    println("Saldo Final Lidia:" + contaLidia.getSaldo())
    println("Saldo Final Vanessa:" + contaVanessa.getSaldo())

    println("==============================\n\n")
}



fun mainTransferenciaUsandoLimite() {
	println("----- Main mainTransferenciaUsandoLimite -----")
    var lidia = Cliente("Lidia Lourane")
    var vanessa = Cliente("Vanessa")
    var contaLidia = ContaCorrente(lidia, 0.0)
    var contaVanessa = ContaPoupanca(vanessa, 0.0)
    
    println("Saldo Inicial Lidia:" + contaLidia.getSaldo())
    println("Saldo Inicial Vanessa:" + contaVanessa.getSaldo())
    println("Transferencia com sucesso?: " + contaLidia.transferirPara(contaVanessa, 30.0))
    println("Saldo Final Lidia:" + contaLidia.getSaldo())
    println("Saldo Final Vanessa:" + contaVanessa.getSaldo())

    println("==============================\n\n")
}