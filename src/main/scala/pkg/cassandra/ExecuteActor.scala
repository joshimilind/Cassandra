package pkg.cassandra

import akka.actor._
import com.datastax.driver.core.Session
case class ExecuteQuery(query: String) {}
//class ExecuteActor(session: Session) extends Actor {
class ExecuteActor(query: String,session:Session) extends Actor {

  def receive = {
    case ExecuteQuery(query) => {
      session.execute(query)

    }
  }
}
