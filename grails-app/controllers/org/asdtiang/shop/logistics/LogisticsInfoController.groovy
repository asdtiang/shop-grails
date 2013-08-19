package org.asdtiang.shop.logistics

import org.springframework.dao.DataIntegrityViolationException

class LogisticsInfoController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [logisticsInfoInstanceList: LogisticsInfo.list(params), logisticsInfoInstanceTotal: LogisticsInfo.count()]
    }

    def create() {
        [logisticsInfoInstance: new LogisticsInfo(params)]
    }

    def save() {
        def logisticsInfoInstance = new LogisticsInfo(params)
        if (!logisticsInfoInstance.save(flush: true)) {
            render(view: "create", model: [logisticsInfoInstance: logisticsInfoInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'logisticsInfo.label', default: 'LogisticsInfo'), logisticsInfoInstance.id])
        redirect(action: "show", id: logisticsInfoInstance.id)
    }

    def show(Long id) {
        def logisticsInfoInstance = LogisticsInfo.get(id)
        if (!logisticsInfoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'logisticsInfo.label', default: 'LogisticsInfo'), id])
            redirect(action: "list")
            return
        }

        [logisticsInfoInstance: logisticsInfoInstance]
    }

    def edit(Long id) {
        def logisticsInfoInstance = LogisticsInfo.get(id)
        if (!logisticsInfoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'logisticsInfo.label', default: 'LogisticsInfo'), id])
            redirect(action: "list")
            return
        }

        [logisticsInfoInstance: logisticsInfoInstance]
    }

    def update(Long id, Long version) {
        def logisticsInfoInstance = LogisticsInfo.get(id)
        if (!logisticsInfoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'logisticsInfo.label', default: 'LogisticsInfo'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (logisticsInfoInstance.version > version) {
                logisticsInfoInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'logisticsInfo.label', default: 'LogisticsInfo')] as Object[],
                          "Another user has updated this LogisticsInfo while you were editing")
                render(view: "edit", model: [logisticsInfoInstance: logisticsInfoInstance])
                return
            }
        }

        logisticsInfoInstance.properties = params

        if (!logisticsInfoInstance.save(flush: true)) {
            render(view: "edit", model: [logisticsInfoInstance: logisticsInfoInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'logisticsInfo.label', default: 'LogisticsInfo'), logisticsInfoInstance.id])
        redirect(action: "show", id: logisticsInfoInstance.id)
    }

    def delete(Long id) {
        def logisticsInfoInstance = LogisticsInfo.get(id)
        if (!logisticsInfoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'logisticsInfo.label', default: 'LogisticsInfo'), id])
            redirect(action: "list")
            return
        }

        try {
            logisticsInfoInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'logisticsInfo.label', default: 'LogisticsInfo'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'logisticsInfo.label', default: 'LogisticsInfo'), id])
            redirect(action: "show", id: id)
        }
    }
}
