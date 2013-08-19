package org.asdtiang.grails.service

import org.asdtiang.shop.JsonResult
import org.asdtiang.shop.ResultType
import org.asdtiang.shop.auth.AccessKey
import grails.converters.JSON


/**
 * 访问验证
 */
class AccessService {

    def authKey(keyValue) {
        def accessKey =  AccessKey.findByKeyValue(keyValue)
        if(accessKey){
            return true
        }
        else{
            return false
        }
    }
    def genResult(object){
        JsonResult result = new JsonResult()
        result.resultType = ResultType.SUCCESS
        result.result=object
        JSON.use('deep')
        result as JSON
    }
    def genResult(object,errorInfo){
        JsonResult result = new JsonResult()
        result.resultType = ResultType.ERROR
        result.result=object
        JSON.use('deep')
        result as JSON
    }
}
