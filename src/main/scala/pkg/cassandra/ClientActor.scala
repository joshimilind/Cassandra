package pkg.cassandra

import akka.actor.{Actor, ActorRef, ActorSystem, Props}
import scala.concurrent.duration._
import com.datastax.driver.core._
import com.sun.security.ntlm.Client

//class ClientActor(session: Session) extends Actor {
class ClientActor(StartPoint: ActorRef) extends Actor {
  private val table = "base_pos_data" //using
  var executedCommands = Set.empty[String]
  var executedquries = Set.empty[ActorRef]
  val query: String =
    s"CREATE TABLE IF NOT EXISTS $table (year int PRIMARY KEY ,month int,day int,age int,frequency int,income int,value_segment int,brand text,category text,class text,style text,color_type text,choice_code int,color_family text,tier text,region text,location text,tx_time int,tx_id int,unit int,Basket_value int);"

  if (!executedCommands(query)) {
    executedquries += context.actorOf(Props[ExecuteActor](new ExecuteActor))

    executedCommands += query
  } else {
    executedCommands += query
    StartPoint ! submitQuery(query)
  }
}

object Client extends App {
  println("...")
  val _system = ActorSystem("cassandra")
  val StartPoint = _system.actorOf(Props[ExecuteActor], "cassandra")
  val executor =
    _system.actorOf(Props[ClientActor](new ClientActor(StartPoint)))
//  StartPoint ! ExecuteQuery
}
/*


//       val query =
//      s"create table if not exist $table (year int,month int,day int,age int,frequency int,income int,value_segment int,brand text,category text,class text,style text,color_type text,choice_code int,color_family text,tier text,region text,location text,tx_time int,tx_id int,unit int,Basket_value int"
/*

  if (!executedCommands(query))
    executedquries += context.actorOf(
      Props[ExecuteActor](new ExecuteActor(query)))
  else
    executedCommands += query

}*/
//  }

//  def receive = {
//    Done =>
//      println("done")
//  }


 */
