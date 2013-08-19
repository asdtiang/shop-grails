package org.asdtiang.shop

import org.springframework.dao.DataIntegrityViolationException

class OrderInfoController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [orderInfoInstanceList: OrderInfo.list(params), orderInfoInstanceTotal: OrderInfo.count()]
    }

    def create() {
        [orderInfoInstance: new OrderInfo(params)]
    }

    def save() {
        def orderInfoInstance = new OrderInfo(params)
        if (!orderInfoInstance.save(flush: true)) {
            render(view: "create", model: [orderInfoInstance: orderInfoInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'orderInfo.label', default: 'OrderInfo'), orderInfoInstance.id])
        redirect(action: "show", id: orderInfoInstance.id)
    }

    def show(Long id) {
        def orderInfoInstance = OrderInfo.get(id)
        if (!orderInfoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'orderInfo.label', default: 'OrderInfo'), id])
            redirect(action: "list")
            return
        }

        [orderInfoInstance: orderInfoInstance]
    }

    def edit(Long id) {
        def orderInfoInstance = OrderInfo.get(id)
        if (!orderInfoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'orderInfo.label', default: 'OrderInfo'), id])
            redirect(action: "list")
            return
        }

        [orderInfoInstance: orderInfoInstance]
    }

    def update(Long id, Long version) {
        def orderInfoInstance = OrderInfo.get(id)
        if (!orderInfoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'orderInfo.label', default: 'OrderInfo'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (orderInfoInstance.version > version) {
                orderInfoInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'orderInfo.label', default: 'OrderInfo')] as Object[],
                          "Another user has updated this OrderInfo while you were editing")
                render(view: "edit", model: [orderInfoInstance: orderInfoInstance])
                return
            }
        }

        orderInfoInstance.properties = params

        if (!orderInfoInstance.save(flush: true)) {
            render(view: "edit", model: [orderInfoInstance: orderInfoInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'orderInfo.label', default: 'OrderInfo'), orderInfoInstance.id])
        redirect(action: "show", id: orderInfoInstance.id)
    }

    def delete(Long id) {
        def orderInfoInstance = OrderInfo.get(id)
        if (!orderInfoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'orderInfo.label', default: 'OrderInfo'), id])
            redirect(action: "list")
            return
        }

        try {
            orderInfoInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'orderInfo.label', default: 'OrderInfo'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'orderInfo.label', default: 'OrderInfo'), id])
            redirect(action: "show", id: id)
        }
    }
}
