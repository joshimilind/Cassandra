/*
package pkg.cassandra

import akka.actor.Props
import com.datastax.driver.core.Session

import scala.concurrent.ExecutionContext
//class cassandraQuery {



case class cassandraQuery(session: Session)(implicit ec: ExecutionContext) {

  private val table = "base_pos_data" //using
  var commands = Set.empty[String]

  def createTable(): Unit = {
    val query =
      s"CREATE TABLE IF NOT EXISTS $table (year int PRIMARY KEY ,month int,day int,age int,frequency int,income int,value_segment int,brand text,category text,class text,style text,color_type text,choice_code int,color_family text,tier text,region text,location text,tx_time int,tx_id int,unit int,Basket_value int);"

//       val query =
//      s"create table if not exist $table (year int,month int,day int,age int,frequency int,income int,value_segment int,brand text,category text,class text,style text,color_type text,choice_code int,color_family text,tier text,region text,location text,tx_time int,tx_id int,unit int,Basket_value int"


    if (!commands(query))
      children += context.actorOf(
        Props[GetterActor](new GetterActor(url, depth - 1)))



    session.execute(query)

  }

  /*def creatTable: Unit = {
      val query = S"create table if not exists $table ($year ,
      month int,
        day int,
        age int,
        frequency int,
        income int,
        valuesegment int,
        brand text,
        category text,
        class_class text,
        style text,
        color_type text,
        choice_code int,
        color_family text,
        tier text,
        region text,
        location text,
        tx_time text,
        tx_id int,
        unit int,
        Basket_value int )"

    }*/

}
*/
