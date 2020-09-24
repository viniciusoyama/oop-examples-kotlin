
class User {
    private var nome: String;
    private var email: String;
	
    constructor(_nome: String, _email: String) {
        this.nome = _nome;
        this.email = _email;
    }
    
    public fun getNome(): String {
        return this.nome;
    }

    public fun getEmail(): String {
        return this.email;
    }
}

abstract class PartyInviteSender() {
   fun execute() : Boolean {
      val list: MutableList<User> = ArrayList()
      list.add(User("Jose", "jose@email.com"))
      list.add(User("Maria", "maria@email.com"))
      list.add(User("Joana", "Joana@email.com"))

      for (user in list) { 
        // Crio uma lógica para transformar conteúdo do CSV em um objeto user 
        notify(user)
      }
      
      return true;
   }
    
   abstract fun notify(user: User) : Boolean
}

class MailSender() : PartyInviteSender() {
  override fun notify(user: User) : Boolean {
    println("Enviando Email para " + user.getNome());
    return true;
  }
}

class SMSSender() : PartyInviteSender() {
  override fun notify(user: User) : Boolean {
    println("Enviando SMS para " + user.getNome());
    return true;
  }
}


fun main() {   
  MailSender().execute()   
  SMSSender().execute()   
}

