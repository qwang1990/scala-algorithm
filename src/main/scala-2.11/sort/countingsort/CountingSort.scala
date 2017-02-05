package sort.countingsort

import scala.collection.mutable.ArrayBuffer

/**
  * Created by wangqi on 17/2/5.
  */
object CountingSort extends App{

  def countingSort(data:ArrayBuffer[Int], k:Int): Unit = {
    val B = Array.fill[Int](k)(0)

    for (i <- 0 until(data.length)) {
      B(data(i)) += 1
    }

    var idx = 0

    for( i <- 0 until(k)){
      while (B(i) >0){
        data(idx) = i
        idx += 1
        B(i) -= 1
      }
    }
  }

  val tobeSort = ArrayBuffer(1,3,4,5,1,3,5,6,3,4,7,8,23,22,11,26)
  println(s"before sort $tobeSort")

  countingSort(tobeSort,27)
  println(s"after sort $tobeSort")

}
