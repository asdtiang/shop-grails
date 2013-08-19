package org.asdtiang.site.config

import org.asdtiang.StaticMethod
import org.springframework.dao.DataIntegrityViolationException

class ConfigDomainController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [configDomainInstanceList: ConfigDomain.list(params), configDomainInstanceTotal: ConfigDomain.count()]
    }

    def create() {
        [configDomainInstance: new ConfigDomain(params)]
    }

    def save() {
        def configDomainInstance = new ConfigDomain(params)
        if (!configDomainInstance.save(flush: true)) {
            render(view: "create", model: [configDomainInstance: configDomainInstance])
            return
        }
		updateConfig(configDomainInstance)
		flash.message = message(code: 'default.created.message', args: [message(code: 'configDomain.label', default: 'ConfigDomain'), configDomainInstance.id])
        redirect(action: "show", id: configDomainInstance.id)
    }

    def show() {
        def configDomainInstance = ConfigDomain.get(params.id)
        if (!configDomainInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'configDomain.label', default: 'ConfigDomain'), params.id])
            redirect(action: "list")
            return
        }

        [configDomainInstance: configDomainInstance]
    }

    def edit() {
        def configDomainInstance = ConfigDomain.get(params.id)
        if (!configDomainInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'configDomain.label', default: 'ConfigDomain'), params.id])
            redirect(action: "list")
            return
        }
		updateConfig(configDomainInstance)
        [configDomainInstance: configDomainInstance]
    }

    def update() {
        def configDomainInstance = ConfigDomain.get(params.id)
        if (!configDomainInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'configDomain.label', default: 'ConfigDomain'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (configDomainInstance.version > version) {
                configDomainInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'configDomain.label', default: 'ConfigDomain')] as Object[],
                          "Another user has updated this ConfigDomain while you were editing")
                render(view: "edit", model: [configDomainInstance: configDomainInstance])
                return
            }
        }

        configDomainInstance.properties = params

        if (!configDomainInstance.save(flush: true)) {
            render(view: "edit", model: [configDomainInstance: configDomainInstance])
            return
        }
		updateConfig(configDomainInstance)
		flash.message = message(code: 'default.updated.message', args: [message(code: 'configDomain.label', default: 'ConfigDomain'), configDomainInstance.id])
        redirect(action: "show", id: configDomainInstance.id)
    }

    def delete() {
        def configDomainInstance = ConfigDomain.get(params.id)
        if (!configDomainInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'configDomain.label', default: 'ConfigDomain'), params.id])
            redirect(action: "list")
            return
        }

        try {
            configDomainInstance.delete(flush: true)
            servletContext.configMap.remove(configDomainInstance.mapName)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'configDomain.label', default: 'ConfigDomain'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'configDomain.label', default: 'ConfigDomain'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
	private updateConfig(configInstance){
        StaticMethod.addToConfigMap(servletContext.configMap,configInstance)
    }
}
