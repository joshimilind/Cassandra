package pkg.cassandra

import com.datastax.driver.core.Cluster

object cas extends App {

  val cluster = Cluster.builder
    .withClusterName("myCluster")
    .addContactPoint("localhost")
    .build
  val session = cluster.connect("test")

  /*session.execute(
    "CREATE KEYSPACE test WITH replication = {'class': 'SimpleStrategy', 'replication_factor': 2};")*/
  session.execute("DROP TABLE IF EXISTS base_pos_data;")

  session.execute(
    "CREATE TABLE IF NOT EXISTS base_pos_data (year int PRIMARY KEY ,month int,day int,age int,frequency int,income int,value_segment int,brand text,category text,class text,style text,color_type text,choice_code int,color_family text,tier text,region text,location text,tx_time int,tx_id int,unit int,Basket_value int);")

  session.execute(
    "insert into base_pos_data (year, month, day, age, frequency , income, value_segment , brand, category, class, style, color_type, choice_code, color_family, tier, region, location, tx_time, tx_id, unit, Basket_value) values (2000,5,21,19,18,15000,10,'xyzBrand','CatogoricalVariable','Aclass','style','redcolor',1234,'warmcolor','threetier','southwestregion','India',12,01,5,1221)")

  println("#...100%")

  cluster.close();
}
