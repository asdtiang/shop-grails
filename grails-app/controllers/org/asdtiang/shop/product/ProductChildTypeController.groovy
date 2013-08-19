package org.asdtiang.shop.product

import org.springframework.dao.DataIntegrityViolationException

class ProductChildTypeController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [productChildTypeInstanceList: ProductChildType.list(params), productChildTypeInstanceTotal: ProductChildType.count()]
    }

    def create() {
        [productChildTypeInstance: new ProductChildType(params)]
    }

    def save() {
        def productChildTypeInstance = new ProductChildType(params)
        if (!productChildTypeInstance.save(flush: true)) {
            render(view: "create", model: [productChildTypeInstance: productChildTypeInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'productChildType.label', default: 'ProductChildType'), productChildTypeInstance.id])
        redirect(action: "show", id: productChildTypeInstance.id)
    }

    def show(Long id) {
        def productChildTypeInstance = ProductChildType.get(id)
        if (!productChildTypeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'productChildType.label', default: 'ProductChildType'), id])
            redirect(action: "list")
            return
        }

        [productChildTypeInstance: productChildTypeInstance]
    }

    def edit(Long id) {
        def productChildTypeInstance = ProductChildType.get(id)
        if (!productChildTypeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'productChildType.label', default: 'ProductChildType'), id])
            redirect(action: "list")
            return
        }

        [productChildTypeInstance: productChildTypeInstance]
    }

    def update(Long id, Long version) {
        def productChildTypeInstance = ProductChildType.get(id)
        if (!productChildTypeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'productChildType.label', default: 'ProductChildType'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (productChildTypeInstance.version > version) {
                productChildTypeInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'productChildType.label', default: 'ProductChildType')] as Object[],
                          "Another user has updated this ProductChildType while you were editing")
                render(view: "edit", model: [productChildTypeInstance: productChildTypeInstance])
                return
            }
        }

        productChildTypeInstance.properties = params

        if (!productChildTypeInstance.save(flush: true)) {
            render(view: "edit", model: [productChildTypeInstance: productChildTypeInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'productChildType.label', default: 'ProductChildType'), productChildTypeInstance.id])
        redirect(action: "show", id: productChildTypeInstance.id)
    }

    def delete(Long id) {
        def productChildTypeInstance = ProductChildType.get(id)
        if (!productChildTypeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'productChildType.label', default: 'ProductChildType'), id])
            redirect(action: "list")
            return
        }

        try {
            productChildTypeInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'productChildType.label', default: 'ProductChildType'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'productChildType.label', default: 'ProductChildType'), id])
            redirect(action: "show", id: id)
        }
    }
}
