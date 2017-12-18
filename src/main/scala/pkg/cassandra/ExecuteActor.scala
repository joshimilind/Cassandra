package pkg.cassandra

import akka.actor._
import com.datastax.driver.core._

//class ExecuteActor(session: Session) extends Actor {
case class submitQuery(query: String) {}
class ExecuteActor(session: Session, query: String) extends Actor {

  def receive = {
    case submitQuery(query) => {

      session.execute(query)

    }

  }

}
