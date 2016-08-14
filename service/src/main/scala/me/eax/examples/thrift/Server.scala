package me.eax.examples.thrift

import com.twitter.util.Future
import me.eax.examples.thrift.game.MyServ
import me.eax.examples.thrift.game._

import collection.mutable.HashMap
import scala.collection.mutable
import scala.runtime.Nothing$


/**
  * Created by evgeniy on 13.08.16.
  */
class Server extends MyServ[Future]{
  var mylist = game.Other()._1
  val tag = game.Other()._2
  val testrec = game.Rt(
    id = "dsad",
    name = "Dsda"
    )

  val rec = Seq(testrec) ++ Seq(testrec)
  val rew = game.Rt
  override def add(idR: String, idT: String): Future[Unit] = {
    var check = false
    val fst = functions.find(idR,rec)
    val snd = functions.find(idT,rec)
    (fst,snd) match {
      case (Some(f),Some(s)) => {
        mylist = mylist.map(w => w._1._1 match {
          case idR => {
            check = true
            println(w._1->(w._2 ++ Seq(s)))
            w._1->(w._2 ++ Seq(s))
          }
          case _ => {
            w
          }
        })
        check match {
          case false => {
            mylist ++= Map(f->Seq(s))
          }
        }
      }
      case (_,_) => error("dsads")
    }
    Future.Unit
  }

  override def listT(idR: String): Future[Unit] = {
    var msg = "Список тэгов:"
    mylist.find(x => x._1._1 == idR) match {
      case Some(v) => v._2.foreach(x => msg += " " + x._2 + ",")
      case None => error("Not found!")
    }
    println(msg.substring(0,msg.length()-1))
    Future.Unit
  }

  override def delete(idR: String, idT: String): Future[Unit] = {
    var check = false
    mylist.map(x => x._1._1 match {
      case idR => {
        val hlp = x._2.filter(x => x._1 == idT)
        (hlp.isEmpty,x._2.isEmpty) match {
          case (false,false) => hlp
          case (_,false) => {
            check = true
            hlp
          }
          case (_,_) => error("Not found")
        }
      }
    })
    check match {
      case true => mylist = mylist.filter(x => x._2.nonEmpty)
      case _ =>
    }
    Future.Unit
  }

  override def listR(lstT: Seq[String]): Future[Unit] = {
    var msg = ""
    val hlst = mylist.filter(w => w._2.map(x => x._1) == lstT).foreach(x => msg += x._1._2)
    msg match {
      case "" => error("Not found")
      case _ =>
    }
    println(msg)
    Future.Unit
  }

  override def put(where: Short): Future[Unit] = {
    Future.Unit
  }
}
