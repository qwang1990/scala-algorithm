package sort.insertion

import scala.collection.mutable.ArrayBuffer

/**
  * 插入排序
  * 最好 O(n)
  * 最差 O(n2)
  * 平均 O(n2)
  * Created by wangqi on 17/2/5.
  */
object InsertSort extends App{

  def insertSort(data:ArrayBuffer[Int]) = {
    for(i<-0 until(data.length)) {
      insert(data,i,data(i))
    }
  }

  def insert(data:ArrayBuffer[Int],pos:Int,value:Int) = {
    var i:Int = pos - 1
    while(i>=0 && data(i) > value) {
      data(i+1) = data(i)
      i = i-1
    }
    data(i+1) = value
  }


  val tobeSort = ArrayBuffer(1,3,4,5,1,3,5,6,3,4,7,8,23,22,11,26)
  println(s"before sort $tobeSort")

  insertSort(tobeSort)
  println(s"after sort $tobeSort")

}
