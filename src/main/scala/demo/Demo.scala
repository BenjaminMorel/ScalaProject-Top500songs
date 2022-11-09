package demo

import com.github.tototoshi.csv.*

import java.io.File
import scala.io.Source

object Demo {
  def main(args: Array[String]): Unit = {
    //Get absolute path from csv file
    val csvFilename = "CSV/01-Top500Songs.csv"

    //Retrieve data from csv file
    val data = Source.fromFile(csvFilename).getLines.toList

    //Print all lines of data
    for (i <- data) {
      val cols = i.split(";")
//        println(cols(cols.size-1))
//      println(i)
    }

    val titles = data.filter({ i => i.charAt(0) == 'L' })
//    val titles2 = data.filter({ i => new Song {
//      override val title: String = cols(0)
//      override val description: String = cols(1)
//      override val appear: String = cols(2)
//      override val artist: String = cols(3)
//      override val writer: String = cols(4)
//      override val producer: String = cols(5)
//      override val released: String = cols(6)
//            override val streak: Int = cols(7)
//            override val position: Int = cols(8)



    for (i <- titles) {
      println(i)
    }

    trait person {
        val name: String
    }

    class Producer(val name: String) extends  person
    class Writer(val name: String) extends person


    class Artist(val name: String) extends person


    class Song(val title:String,val description: String, val appear: String, val artist:String,val writer:String,val producer:String,val releaseDate:String,val streak:Int, val position:Int) {
      val songTitle = title
      val songDescription = description
      val songAlbum = appear

      val songArtist = new Artist(artist)
      val songWriter = new Writer(writer)
      val songProducer = new Producer(producer)
      val releasedDate =  releaseDate
      val songStreak = streak
      val songMaxPosition = position
    }



    //Using CSV reader
    //      val reader = CSVReader.open(new File(csvFilename))
    //      reader.foreach(fields => println(fields))
    //      reader.foreach(fields => println(fields))
    //      reader.close()


  }
}