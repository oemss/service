package me.eax.examples.thrift

import com.twitter.finagle.Thrift
import com.twitter.util.{Await, Future}
import me.eax.examples.thrift.game.MyServ

/**
  * Created by evgeniy on 13.08.16.
  */
object MyClient {
  def startclient(): MyServ[Future] = {
    val client = Thrift.client.newIface[MyServ[Future]]("127.0.0.1:6666")
    Await.ready(client.add("dsad","dsad"))
    Await.ready(client.add("dsad","dsad"))
    client.listT("dsad")
    client.listR(Seq("dsad","dsad"))
    client.delete("dsad","dsad")
    client.listT("dsad")
    client
  }
}
