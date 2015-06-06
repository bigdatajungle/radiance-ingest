package com.radiance.actors.dummy

/**
 * Created by rahul on 04/06/15.
 */
import akka.actor._

object HelloActor {
  def props = Props[HelloActor]

  case class SayHello(name: String)
}

class HelloActor extends Actor {
  import HelloActor._

  def receive = {
    case SayHello =>
      sender() ! "Hello, " + "Rahul"
  }
}