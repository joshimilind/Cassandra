package pkg.cassandra

import akka.actor.{Actor, ActorRef, ActorSystem, Props}
import com.datastax.driver.core.Session
import com.sun.security.ntlm.Client

//class ClientActor(session: Session) extends Actor {
class ClientActor extends Actor {
  private val table = "base_pos_data" //using
  var executedCommands = Set.empty[String]
  var executedquries = Set.empty[ActorRef]

  def createTable(): Unit = {
    val query =
      s"CREATE TABLE IF NOT EXISTS $table (year int PRIMARY KEY ,month int,day int,age int,frequency int,income int,value_segment int,brand text,category text,class text,style text,color_type text,choice_code int,color_family text,tier text,region text,location text,tx_time int,tx_id int,unit int,Basket_value int);"

    //       val query =
    //      s"create table if not exist $table (year int,month int,day int,age int,frequency int,income int,value_segment int,brand text,category text,class text,style text,color_type text,choice_code int,color_family text,tier text,region text,location text,tx_time int,tx_id int,unit int,Basket_value int"
    /*

    if (!executedCommands(query))
      executedquries += context.actorOf(
        Props[ExecuteActor](new ExecuteActor(query)))
    else
      executedCommands += query

  }*/

  }

}
object Client extends App {
  println("...")
  val _system = ActorSystem("cassandra")
  val StartPoint = _system.actorOf(Props[ClientActor], "cassandra")
    val executor = _system.actorOf(
      Props[ExecuteActor](new ExecuteActor(StartPoint)))
  StartPoint ! ExecuteQuery


}
