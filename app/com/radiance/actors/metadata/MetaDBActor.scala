package com.radiance.actors.metadata

import akka.actor.Actor

/**
 * Created by rahul on 05/06/15.
 */
object MetaDBActor {
  case class addCurrentRowToTable(nrd: NewRowData)
}

class MetaDBActor extends Actor {
import MetaDBActor._
  def receive ={

    case addCurrentRowToTable(nrd: NewRowData) =>{

      println("new Data added to database !!"+nrd)
    }

  }

}