package sort.heapsort

import scala.collection.mutable.ArrayBuffer

/**
  * n Log n
  * Created by wangqi on 17/2/5.
  */
object HeapSort extends App{

  /**
    * 由当前点调整堆
    * @param data
    * @param idx
    * @param max
    */
  def heapify(data:ArrayBuffer[Int], idx:Int, max:Int): Unit = {
    val left = idx * 2 + 1
    val right = idx *2 + 2
    var largest = idx

    if(left < max && data(left) > data(idx))
      largest = left

    if(right < max && data(right) > data(largest))
      largest = right

    if(largest != idx){
      val temp = data(idx)
      data(idx) = data(largest)
      data(largest) = temp

      heapify(data,largest,max)
    }
  }

  /**
    * 构建最大堆
    * @param data
    */
  def buildHeap(data:ArrayBuffer[Int]) = {
    for (i <- (0 until((data.length-1)/2)).reverse) {
      heapify(data,i,data.length-1)
    }
  }

  /**
    * 排序
    * @param data
    */
  def sort(data:ArrayBuffer[Int]) = {
    buildHeap(data)
    for(i <- (1 until(data.length)).reverse){
      val temp = data(0)
      data(0) = data(i)
      data(i) = temp

      heapify(data,0,i)
    }
  }

  val tobeSort = ArrayBuffer(1,3,4,5,1,3,5,6,3,4,7,8,23,22,11,26)
  println(s"before sort $tobeSort")

  sort(tobeSort)
  println(s"after sort $tobeSort")


}
