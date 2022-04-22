package com.sodove.model

class ScheduleLesson {
    var date: String? = null
    var time: String? = null
    var lesson: Long = 0
    var timetable: String? = null
    var scheduleContent: ScheduleLessonContent? = null
    override fun toString(): String {
        return "\n\ndate=$date\ntime=$time\ntimetable=$timetable\n$scheduleContent\n".trimIndent()
    }
}
