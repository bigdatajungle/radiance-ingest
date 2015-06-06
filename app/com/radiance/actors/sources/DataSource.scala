package com.radiance.actors.sources

import akka.actor.{Props, Actor}
import com.radiance.param.sources.DataSourceRow

/**
 * Created by rahul on 05/06/15.
 */

object DataSource {

  def props = Props[DataSource]
  case class addCurrentDataSource(currentRow: DataSourceRow)
  case class editCurrentDataSource(id: Long)
  case class deleteCurrentDataSource(id: Long)
  case class listDataSources(userID: Long)
}

class DataSource extends Actor{
  import DataSource._

  def receive = {
    case addCurrentDataSource(currentRow) => {

      println("fddfdf ",currentRow)
      //save in to DB

      sender() ! "Data Source Added !!"
    }
    case editCurrentDataSource(id: Long) => {
      sender() ! "current data source edited !!"
    }
    case deleteCurrentDataSource(id: Long) => {
      sender() ! "current data source deleted !!"
    }
    case listDataSources(userID: Long) => {
      sender() ! "Current User's datasources !!"
    }
    case _ =>{
      sender() ! "wrong data entry !!"
    }
  }
}
