package org.asdtiang.shop.logistics

import org.asdtiang.grails.annotation.Title

/**
 * Created with IntelliJ IDEA.
 * User: asdtiang
 * Date: 13-7-5
 * Time: 下午12:26
 * To change this template use File | Settings | File Templates.
 */
@Title("物流信息")
class LogisticsInfo {
    /**
     * 物流给的id
     */
    @Title("物流id")
    String infoId
    @Title("物流类型")
    org.asdtiang.shop.logistics.LogisticsType logisticsType
    static mapping = {
        logisticsType lazy: false
    }
}
