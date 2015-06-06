package com.radiance.actors.dummy

import akka.actor.{Props, ActorSystem, Actor}

/**
 * Created by rahul on 05/06/15.
 */

class HeloActor extends Actor {

  def receive = {
    case "hello" => println("Hello back to You.")
    case _ => {
      val a = List(1,2,3,4)
      var num =0
      println(a)
      for(num <- a){
        println(num)
      }
      Thread.sleep(1000)
    }
  }
}

object Main {
  def main(args: Array[String]) {
    print("Hello")

    val system = ActorSystem("HelloSystem")
    val helloActor = system.actorOf(Props(new HeloActor), name="helloactor")
    helloActor ! "hello"
    helloActor ! "dias"
    helloActor ! "hello"
    helloActor ! "hello"

    system.shutdown()
  }
}
