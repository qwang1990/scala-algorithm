package sort.select

import scala.collection.mutable.ArrayBuffer

/**
  * N2。。。。几乎没啥用。。。
  * Created by wangqi on 17/2/5.
  */
object SelectSort extends App{

  /**
    * 选择最大值的位置
    * @param data
    * @param left
    * @param right
    */
  def selectMax(data:ArrayBuffer[Int],left:Int, right:Int) = {
    var maxPos = left
    for( i <- 0 until(right+1)){
      if(data(i) > data(maxPos))
        maxPos = i
    }
    maxPos
  }


  def sortPointers(data:ArrayBuffer[Int]) = {
    for( i <- (1 until(data.length)).reverse) {
      val maxPos = selectMax(data,0,i)
      if(maxPos != i) {
        val temp = data(i)
        data(i) = data(maxPos)
        data(maxPos) = temp
      }

    }
  }

  val tobeSort = ArrayBuffer(1,3,4,5,1,3,5,6,3,4,7,8,23,22,11,26)
  println(s"before sort $tobeSort")

  sortPointers(tobeSort)
  println(s"after sort $tobeSort")

}
