package demo

import com.github.tototoshi.csv.*

import java.io.File
import scala.io.Source

object Demo {
  def main(args: Array[String]): Unit = {

    trait person {
      val name: String
    }

    class Producer(val name: String) extends person
    class Writer(val name: String) extends person


    class Artist(val name: String) extends person


    class Song(val title: String, val description: String, val appear: String, val artist: String, val writer: String, val producer: String, val releaseDate: String, val streak: String, val position: String) {
      val songTitle = title
      val songDescription = description
      val songAlbum = appear
      val songArtist = new Artist(artist)
      val songWriter = new Writer(writer)
      val songProducer = new Producer(producer)
      val releasedDate = releaseDate
      val songStreak = streak
      val songMaxPosition = position
    }

    //Get absolute path from csv file
    val csvFilename = "CSV/01-Top500Songs.csv"

    //Retrieve data from csv file
    val data = Source.fromFile(csvFilename).getLines.toList

    val allSong=new java.util.ArrayList[Song]

    //Print all lines of data
    for (i <- data) {
      println(i)
      val cols = i.split(";")
      if(cols.length > 8) {
        //      val mySong = new Song(cols(0),cols(1),cols(2),cols(3),cols(4),cols(5),cols(6),cols(7).toInt,cols(8).toInt)
        val mySong = new Song(cols(0), cols(1), cols(2), cols(3), cols(4), cols(5), cols(6), cols(7), cols(8))
        allSong.add(mySong)
      }
    }

    print(allSong.size() + " number of song")
//
//    allSong.forEach(song =>{
//      print(song.title + " | ")
//      print(song.description + " | ")
//
//      println(song.artist)
//    })


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


//
//    for (i <- titles) {
//      println(i)
//    }





    //Using CSV reader
    //      val reader = CSVReader.open(new File(csvFilename))
    //      reader.foreach(fields => println(fields))
    //      reader.foreach(fields => println(fields))
    //      reader.close()


  }
}