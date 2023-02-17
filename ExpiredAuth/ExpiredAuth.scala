import scala.collection.mutable.ArrayBuffer

case class Day(val year : Int, val month : Int, val day : Int ) {

    def +( expireMonth : Int) : Day = {
        val plusYear = (expireMonth / 12);
        val plusMonth = (expireMonth % 12);
        val preconvertedMonth = month + plusMonth
        if( preconvertedMonth > 12 ) {
            Day(year + plusYear + 1, preconvertedMonth - 12, day )
        } else {
            Day(year + plusYear, preconvertedMonth, day )
        }
    }
    def isLaterThen( target : Day ) : Boolean = (this.getValue > target.getValue)
    def getValue : Int  = (year * 365 + month * 28 + day)
}

object Solution {

    def solution(today: String, terms: Vector[String], privacies: Vector[String]): Vector[Int] = {
        val todayInfo = today.split("\\.")
        val todayObj = Day( todayInfo(0).toInt,  todayInfo(1).toInt,  todayInfo(2).toInt )
        val termsMap : Map[String, Int] = terms.map { _.split(" ") }.map { data => (data(0), data(1).toInt) }.toMap

        
        var index = 0;
        val result = ArrayBuffer.empty[Int]
        privacies
            .map{ preProcessingRawData _ }
            .map{ plusMonthByType _ }
            .foreach {
                if(_ isLaterThen todayObj)
                    result += index
                index += 1;
            }
        return result;
    }
    
    // return ( 약관, 가입 기간 )
    def preProcessingRawData( rawData : String ) : (Type, Day) = {
            val privacy = data.split(" ")
            val expireType = privacy(1);
            val preConvertedDay = privacy(0).split("\\.")
            val dayData = Day(preConvertedDay(0).toInt, preConvertedDay(1).toInt, preConvertedDay(2).toInt)
    }
    // ( 약관, 가입 기간 ) => ( 약관, 만료 기간 기간 )
    def plusMonthByType( tupleTypeAndDay : (Type, Day) ) : (Type, Day) = {
            dayData(0) + termsMap(tupleTypeAndDay(0))
    }
}
