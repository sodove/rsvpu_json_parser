package com.sodove
import com.sodove.model.ScheduleLesson
import com.sodove.model.ScheduleLessonContent
import org.json.simple.JSONArray
import org.json.simple.JSONObject
import org.json.simple.parser.JSONParser
import java.io.BufferedReader
import java.io.FileReader
import java.io.InputStreamReader
import java.net.URL
import java.util.*
import kotlin.collections.ArrayList

class JsonParser {
    fun parse(url: String): List<ScheduleLesson> {
        val parser = JSONParser()
        val scheduleLessons: MutableList<ScheduleLesson> = ArrayList()
        try {
            val link = URL("http://rsvpu.ru/contents/api/rasp.php?$url") // URL to Parse
            val url_connection = link.openConnection()
            val inp_stream = BufferedReader(InputStreamReader(url_connection.getInputStream()))
//            val inp_stream = FileReader("aud1.json") // filereader
            afterread = Date().time
            val rootJsonObject = parser.parse(inp_stream) as JSONArray
            for (o in rootJsonObject) {
                val scheduleLesson = ScheduleLesson()
                val e = o as JSONObject
                scheduleLesson.date = e["date"] as String?
                scheduleLesson.time = e["time"] as String?
                scheduleLesson.timetable = e["timetable"] as String?
                scheduleLesson.lesson = (e["lesson"] as Long?)!!

                val contents = e["content"] as JSONObject

                val scheduleLessonContent = ScheduleLessonContent()
                scheduleLessonContent.disciplina = contents["disciplina"].toString() + ""
                scheduleLessonContent.aud = contents["aud"].toString() + ""
                scheduleLessonContent.gru = contents["gru"].toString() + ""
                scheduleLessonContent.lecturer = contents["lecturer"].toString() + ""
                scheduleLessonContent.type_disciplina = contents["type_disciplina"].toString() + ""
                scheduleLessonContent.note = contents["note"].toString() + ""
                scheduleLessonContent.subgroupname = contents["subgroupname"].toString() + ""
                scheduleLesson.scheduleContent = scheduleLessonContent
                scheduleLessons.add(scheduleLesson)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return scheduleLessons
    }
}
