package org.asdtiang.shop.logistics

import org.springframework.dao.DataIntegrityViolationException

class LogisticsTypeController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [logisticsTypeInstanceList: LogisticsType.list(params), logisticsTypeInstanceTotal: LogisticsType.count()]
    }

    def create() {
        [logisticsTypeInstance: new LogisticsType(params)]
    }

    def save() {
        def logisticsTypeInstance = new LogisticsType(params)
        if (!logisticsTypeInstance.save(flush: true)) {
            render(view: "create", model: [logisticsTypeInstance: logisticsTypeInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'logisticsType.label', default: 'LogisticsType'), logisticsTypeInstance.id])
        redirect(action: "show", id: logisticsTypeInstance.id)
    }

    def show(Long id) {
        def logisticsTypeInstance = LogisticsType.get(id)
        if (!logisticsTypeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'logisticsType.label', default: 'LogisticsType'), id])
            redirect(action: "list")
            return
        }

        [logisticsTypeInstance: logisticsTypeInstance]
    }

    def edit(Long id) {
        def logisticsTypeInstance = LogisticsType.get(id)
        if (!logisticsTypeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'logisticsType.label', default: 'LogisticsType'), id])
            redirect(action: "list")
            return
        }

        [logisticsTypeInstance: logisticsTypeInstance]
    }

    def update(Long id, Long version) {
        def logisticsTypeInstance = LogisticsType.get(id)
        if (!logisticsTypeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'logisticsType.label', default: 'LogisticsType'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (logisticsTypeInstance.version > version) {
                logisticsTypeInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'logisticsType.label', default: 'LogisticsType')] as Object[],
                          "Another user has updated this LogisticsType while you were editing")
                render(view: "edit", model: [logisticsTypeInstance: logisticsTypeInstance])
                return
            }
        }

        logisticsTypeInstance.properties = params

        if (!logisticsTypeInstance.save(flush: true)) {
            render(view: "edit", model: [logisticsTypeInstance: logisticsTypeInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'logisticsType.label', default: 'LogisticsType'), logisticsTypeInstance.id])
        redirect(action: "show", id: logisticsTypeInstance.id)
    }

    def delete(Long id) {
        def logisticsTypeInstance = LogisticsType.get(id)
        if (!logisticsTypeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'logisticsType.label', default: 'LogisticsType'), id])
            redirect(action: "list")
            return
        }

        try {
            logisticsTypeInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'logisticsType.label', default: 'LogisticsType'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'logisticsType.label', default: 'LogisticsType'), id])
            redirect(action: "show", id: id)
        }
    }
}
