interface INotifiablePerson {
  public fun getEmail() : String
}
class Cliente : INotifiablePerson {
    private var nome: String;
    private var email: String;
	
    constructor(_nome: String, _email: String) {
        this.nome = _nome;
        this.email = _email;
    }
    
    public fun getNome(): String {
        return this.nome;
    }

    override fun getEmail(): String {
        return this.email;
    }
}

class CadastroAnonimo : INotifiablePerson {
    private var email: String;
	
    constructor(_email: String) {
        this.email = _email;
    }

    override fun getEmail(): String {
        return this.email;
    }
}

class WelcomeMailerSender {
    public fun execute(receiver: INotifiablePerson): Boolean {
      println("Mandando email para:" + receiver.getEmail());
      return true;
    }
}

fun main() {   
  var maria = Cliente("Maria da Silva", "maria@email.com")
  var anonimo = CadastroAnonimo("bob@email.com")
  WelcomeMailerSender().execute(maria)   
  WelcomeMailerSender().execute(anonimo)   
}
