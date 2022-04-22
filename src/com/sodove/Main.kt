package com.sodove

import kotlin.jvm.JvmStatic
import com.sodove.model.ScheduleLesson
import java.util.*

var afterread : Long = 0
object Main {
    @JvmStatic
    fun main(args: Array<String>) {

        val starttime = Date().time

        val parser = JsonParser()
        val scheduleLessons = parser.parse("v_aud=1") // v_gru, v_aud, v_prep
        val scheduleDateTable: MutableList<List<ScheduleLesson>> = ArrayList()

        val parse = Date().time

        if (!scheduleLessons.isEmpty()) {
            var scheduleDate = scheduleLessons[0].date
            var scheduleContent: MutableList<ScheduleLesson> = ArrayList()
            
            for (lesson in scheduleLessons) {
                val scheduleDateCycle = lesson.date
                
                if (scheduleDate != scheduleDateCycle) {
                    scheduleDateTable.add(scheduleContent)
                    scheduleContent = ArrayList()
                    scheduleDate = scheduleDateCycle
                }
                
                scheduleContent.add(lesson)
                if (lesson === scheduleLessons[scheduleLessons.size - 1])
                    scheduleDateTable.add(scheduleContent)
            }
        }

        val separate = Date().time
        println("size: ${scheduleLessons.size}")
//        println(scheduleDateTable)                        //final table
        println("get: ${afterread-starttime}ms")
        println("parse: ${parse - afterread}ms")
        println("separate by days: ${separate - parse}ms")
        println("total: ${separate - starttime}ms")

    }
}