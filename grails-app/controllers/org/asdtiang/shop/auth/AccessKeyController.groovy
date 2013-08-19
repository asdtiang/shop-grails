package org.asdtiang.shop.auth

import org.springframework.dao.DataIntegrityViolationException
import static java.util.UUID.randomUUID

class AccessKeyController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [accessKeyInstanceList: AccessKey.list(params), accessKeyInstanceTotal: AccessKey.count()]
    }

    def create() {
        [accessKeyInstance: new AccessKey(params)]
    }

    def save() {
        params.keyValue = randomUUID() as String
        def accessKeyInstance = new AccessKey(params)
        if (!accessKeyInstance.save(flush: true)) {
            render(view: "create", model: [accessKeyInstance: accessKeyInstance])
            return
        }
        servletContext.accessKeyMap.put(accessKeyInstance.keyValue,accessKeyInstance.id)
        flash.message = message(code: 'default.created.message', args: [message(code: 'accessKey.label', default: 'AccessKey'), accessKeyInstance.id])
        redirect(action: "show", id: accessKeyInstance.id)
    }

    def show(Long id) {
        def accessKeyInstance = AccessKey.get(id)
        if (!accessKeyInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'accessKey.label', default: 'AccessKey'), id])
            redirect(action: "list")
            return
        }

        [accessKeyInstance: accessKeyInstance]
    }

    def edit(Long id) {
        def accessKeyInstance = AccessKey.get(id)
        if (!accessKeyInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'accessKey.label', default: 'AccessKey'), id])
            redirect(action: "list")
            return
        }

        [accessKeyInstance: accessKeyInstance]
    }

    def update(Long id, Long version) {
        def accessKeyInstance = AccessKey.get(id)
        if (!accessKeyInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'accessKey.label', default: 'AccessKey'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (accessKeyInstance.version > version) {
                accessKeyInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'accessKey.label', default: 'AccessKey')] as Object[],
                          "Another user has updated this AccessKey while you were editing")
                render(view: "edit", model: [accessKeyInstance: accessKeyInstance])
                return
            }
        }

        accessKeyInstance.properties = params

        if (!accessKeyInstance.save(flush: true)) {
            render(view: "edit", model: [accessKeyInstance: accessKeyInstance])
            return
        }
        servletContext.accessKeyMap.put(accessKeyInstance.keyValue,accessKeyInstance.id)
        flash.message = message(code: 'default.updated.message', args: [message(code: 'accessKey.label', default: 'AccessKey'), accessKeyInstance.id])
        redirect(action: "show", id: accessKeyInstance.id)
    }

    def delete(Long id) {
        def accessKeyInstance = AccessKey.get(id)
        if (!accessKeyInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'accessKey.label', default: 'AccessKey'), id])
            redirect(action: "list")
            return
        }

        try {
            accessKeyInstance.delete(flush: true)
            servletContext.accessKeyMap.remove(accessKeyInstance.keyValue)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'accessKey.label', default: 'AccessKey'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'accessKey.label', default: 'AccessKey'), id])
            redirect(action: "show", id: id)
        }
    }
}
