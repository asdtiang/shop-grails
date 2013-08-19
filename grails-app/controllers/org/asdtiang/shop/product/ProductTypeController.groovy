package org.asdtiang.shop.product

import org.springframework.dao.DataIntegrityViolationException

class ProductTypeController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [productTypeInstanceList: ProductType.list(params), productTypeInstanceTotal: ProductType.count()]
    }

    def create() {
        [productTypeInstance: new ProductType(params)]
    }

    def save() {
        def productTypeInstance = new ProductType(params)
        if (!productTypeInstance.save(flush: true)) {
            render(view: "create", model: [productTypeInstance: productTypeInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'productType.label', default: 'ProductType'), productTypeInstance.id])
        redirect(action: "show", id: productTypeInstance.id)
    }

    def show(Long id) {
        def productTypeInstance = ProductType.get(id)
        if (!productTypeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'productType.label', default: 'ProductType'), id])
            redirect(action: "list")
            return
        }

        [productTypeInstance: productTypeInstance]
    }

    def edit(Long id) {
        def productTypeInstance = ProductType.get(id)
        if (!productTypeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'productType.label', default: 'ProductType'), id])
            redirect(action: "list")
            return
        }

        [productTypeInstance: productTypeInstance]
    }

    def update(Long id, Long version) {
        def productTypeInstance = ProductType.get(id)
        if (!productTypeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'productType.label', default: 'ProductType'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (productTypeInstance.version > version) {
                productTypeInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'productType.label', default: 'ProductType')] as Object[],
                          "Another user has updated this ProductType while you were editing")
                render(view: "edit", model: [productTypeInstance: productTypeInstance])
                return
            }
        }

        productTypeInstance.properties = params

        if (!productTypeInstance.save(flush: true)) {
            render(view: "edit", model: [productTypeInstance: productTypeInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'productType.label', default: 'ProductType'), productTypeInstance.id])
        redirect(action: "show", id: productTypeInstance.id)
    }

    def delete(Long id) {
        def productTypeInstance = ProductType.get(id)
        if (!productTypeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'productType.label', default: 'ProductType'), id])
            redirect(action: "list")
            return
        }

        try {
            productTypeInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'productType.label', default: 'ProductType'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'productType.label', default: 'ProductType'), id])
            redirect(action: "show", id: id)
        }
    }
}
