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
    
    public fun getSaldo() : Double {
		    return this.saldo;
    }

    public fun transferirPara(destino: ContaBancaria, valor: Double): Boolean {
        var podeTransferir = this.saldo - valor > 0
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

}

fun main() {

  var lidia = Cliente("Lidia Lourane")
  var vanessa = Cliente("Vanessa")
  var contaLidia = ContaBancaria(lidia, 1000.0)
  var contaVanessa = ContaBancaria(vanessa, 0.0)
  
  println("Saldo Inicial Lidia:" + contaLidia.getSaldo())
  println("Saldo Inicial Vanessa:" + contaVanessa.getSaldo())
  println("Transferencia com sucesso?: " + contaLidia.transferirPara(contaVanessa, 30.0))
  println("Saldo Final Lidia:" + contaLidia.getSaldo())
  println("Saldo Final Vanessa:" + contaVanessa.getSaldo())

}

