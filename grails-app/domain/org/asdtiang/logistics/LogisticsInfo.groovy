package org.asdtiang.logistics

import org.asdtiang.grails.annotation.Title

/**
 * Created with IntelliJ IDEA.
 * User: asdtiang
 * Date: 13-7-5
 * Time: 下午12:26
 * To change this template use File | Settings | File Templates.
 */
class LogisticsInfo {
    /**
     * 物流给的id
     */
    @Title("物流id")
    String infoType
    static hasOne = [logisticsType:LogisticsType]
    static mapping = {
        logisticsType fetch: 'join'
    }
}
