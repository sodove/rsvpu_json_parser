package com.sodove.model

class ScheduleLessonContent {
    var disciplina: String? = null
    var type_disciplina: String? = null
    var gru: String? = null
    var aud: String? = null
    var lecturer: String? = null
    var note: String? = null
    var subgroupname: String? = null
    override fun toString(): String {
        return """
               disciplina=$disciplina
               type_disciplina=$type_disciplina
               gru=$gru
               aud=$aud
               lecturer=$lecturer
               note=$note
               subgroupname=$subgroupname
               """.trimIndent()
    }
}
