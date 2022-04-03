package com.github.duanxiaowen.seemore

import com.github.duanxiaowen.seemore.services.SeeMoreToolWindowProjectService
import com.intellij.openapi.components.ServiceManager
import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.ToolWindow
import com.intellij.openapi.wm.ToolWindowFactory
import com.intellij.ui.content.ContentFactory

class SeeMoreToolWindowFactory:ToolWindowFactory{
    override fun createToolWindowContent(project: Project, toolWindow: ToolWindow) {
        val callGraphToolWindow = SeeMoreToolWindow()

        // register the call graph tool window as a project service, so it can be accessed by editor menu actions.
        val callGraphToolWindowProjectService =
            ServiceManager.getService(project, SeeMoreToolWindowProjectService::class.java)
        callGraphToolWindowProjectService.seeMoreToolWindow = callGraphToolWindow

        // register the tool window content
        val content = ContentFactory.SERVICE.getInstance().createContent(callGraphToolWindow.getContent(), "", false)
        toolWindow.contentManager.addContent(content)
    }

}