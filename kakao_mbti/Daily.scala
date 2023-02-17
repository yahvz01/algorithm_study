import scala.collection.mutable.{Map => MutableMap}

sealed class Score
case class Left( score : Int ) extends Score
case class Right( score : Int ) extends Score
object Middle extends Score

object Solution {
    val scoreBox = ('R' :: 'T' :: 'C' :: 'F' :: 'J' :: 'M' :: 'A' :: 'N' :: Nil).map{ (_, 0) }.to(MutableMap) withDefaultValue 0
    
    def solution(survey: Vector[String], choices: Vector[Int]): String = {
        val tupleData = survey.zip(choices);
        
        scoreBox('R')
        tupleData.map { data =>
                questionResult( data._1, data._2 )
            }.foreach{ data =>
                scoreBox += (data._1 -> data._2)
            }

            return evaluate(scoreBox)
        }
    
}

def invertOneToThree( data : Int ) : Int = {
    require(data >= 1 && data <= 3)
    data match {
        case 3 => 1
        case 2 => 2
        case 1 => 3
    }
}
def convertScore( data : Int ) : Score = {
    require(data >= 1 && data <= 7)
    if(data <= 3)
        Left( invertOneToThree(data) )
    else if(data == 4)
        Middle
    else
        Right( invertOneToThree(data) )
}
def questionResult( personalType : String, score : Int) : (Char, Int) = {
    convertScore(score) match {
        case Left(data)  => (personalType(0), data)
        case Right(data) => (personalType(1), data)
        case _ => (' ', -1)
    }
}
def evaluate( data : MutableMap[Char, Int]) : String = {
    val result = new StringBuilder()
    if(data('R') >= data('T'))
        result.append('R')
    else result.append('T')
    if(data('C') >= data('F'))
        result.append('C')
    else result.append('F')
    if(data('J') >= data('M'))
        result.append('J')
    else result.append('M')
    if(data('A') >= data('N'))
        result.append('A')
    else result.append('N')
    return result.toString()
}   