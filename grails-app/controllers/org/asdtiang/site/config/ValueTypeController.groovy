package org.asdtiang.site.config

import org.springframework.dao.DataIntegrityViolationException

class ValueTypeController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [valueTypeInstanceList: ValueType.list(params), valueTypeInstanceTotal: ValueType.count()]
    }

    def create() {
        [valueTypeInstance: new ValueType(params)]
    }

    def save() {
        def valueTypeInstance = new ValueType(params)
        if (!valueTypeInstance.save(flush: true)) {
            render(view: "create", model: [valueTypeInstance: valueTypeInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'valueType.label', default: 'ValueType'), valueTypeInstance.id])
        redirect(action: "show", id: valueTypeInstance.id)
    }

    def show(Long id) {
        def valueTypeInstance = ValueType.get(id)
        if (!valueTypeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'valueType.label', default: 'ValueType'), id])
            redirect(action: "list")
            return
        }

        [valueTypeInstance: valueTypeInstance]
    }

    def edit(Long id) {
        def valueTypeInstance = ValueType.get(id)
        if (!valueTypeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'valueType.label', default: 'ValueType'), id])
            redirect(action: "list")
            return
        }

        [valueTypeInstance: valueTypeInstance]
    }

    def update(Long id, Long version) {
        def valueTypeInstance = ValueType.get(id)
        if (!valueTypeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'valueType.label', default: 'ValueType'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (valueTypeInstance.version > version) {
                valueTypeInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'valueType.label', default: 'ValueType')] as Object[],
                          "Another user has updated this ValueType while you were editing")
                render(view: "edit", model: [valueTypeInstance: valueTypeInstance])
                return
            }
        }

        valueTypeInstance.properties = params

        if (!valueTypeInstance.save(flush: true)) {
            render(view: "edit", model: [valueTypeInstance: valueTypeInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'valueType.label', default: 'ValueType'), valueTypeInstance.id])
        redirect(action: "show", id: valueTypeInstance.id)
    }

    def delete(Long id) {
        def valueTypeInstance = ValueType.get(id)
        if (!valueTypeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'valueType.label', default: 'ValueType'), id])
            redirect(action: "list")
            return
        }

        try {
            valueTypeInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'valueType.label', default: 'ValueType'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'valueType.label', default: 'ValueType'), id])
            redirect(action: "show", id: id)
        }
    }
}
