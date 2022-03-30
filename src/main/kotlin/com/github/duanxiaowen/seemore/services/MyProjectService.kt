package com.github.duanxiaowen.seemore.services

import com.intellij.openapi.project.Project
import com.github.duanxiaowen.seemore.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
