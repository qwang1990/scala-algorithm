package sort.median

import scala.collection.mutable.ArrayBuffer

/**
  * 最好 O(n Log n)
  * 最差 O(n2)
  * 平均 O(n Log n)
  * Created by wangqi on 17/2/5.
  */
object MedianSort extends App{

  /**
    * 在线性时间，由给定的中枢值分割序列
    */
  def partition(data:ArrayBuffer[Int],left:Int, right:Int, pivotIndex:Int): Int = {
    val pivot = data(pivotIndex)
    //交换中枢值和最右值得位置
    val temp = data(right)
    data(right) = data(pivotIndex)
    data(pivotIndex) = temp

    var store = left
    for(i <- left until(right)) {
      if(data(i) <= pivot){
        val tmp = data(i)
        data(i) = data(store)
        data(store) = tmp
        store += 1
      }
    }

    val t = data(right)
    data(right) = data(store)
    data(store) = t

    store
  }

  /**
    * 选出第k大的元素
    * @param data
    * @param left
    * @param right
    * @param k
    */
  def selectKth(data:ArrayBuffer[Int],left:Int, right:Int, k:Int):Int = {
    val pivotIndex = partition(data,left,right,left)

    if(left+k == pivotIndex+1) {
      pivotIndex
    } else if(left+k < pivotIndex+1) {
      selectKth(data,left,pivotIndex-1,k)
    } else {
      selectKth(data,pivotIndex+1,right,k-(pivotIndex-left+1))
    }
  }

  /**
    *排序
    * @param data
    * @param left
    * @param right
    * @return
    */
  def medianSort(data:ArrayBuffer[Int],left:Int, right:Int) :Unit = {
    if(right > left) {
      val mid = (right - left + 1)/2
      val me = selectKth(data,left,right,mid+1)

      medianSort(data,left,left+mid-1)
      medianSort(data,left+mid+1,right)

    }
  }

  val tobeSort = ArrayBuffer(1,3,4,5,1,3,5,6,3,4,7,8,23,22,11,26)
  println(s"before sort $tobeSort")

  medianSort(tobeSort,0,tobeSort.length-1)
  println(s"after sort $tobeSort")


}
