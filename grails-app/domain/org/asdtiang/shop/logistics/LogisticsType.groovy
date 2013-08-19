package org.asdtiang.shop.logistics

import org.asdtiang.grails.annotation.Title

/**
 * Created with IntelliJ IDEA.
 * User: asdtiang
 * Date: 13-7-5
 * Time: 下午12:00
 * To change this template use File | Settings | File Templates.
 */
@Title("物流类型")
class LogisticsType {
    @Title("物流名称")
    String name
    @Title("电话")
    String tel
    @Title("查询地址")
    String  searchUrl
    /**
     * 以后可以根据标识符和searchUrl获取物流信息
     * 用户可以直接在我们的网站上查看物流信息
     */
    @Title("标识符")
    String tagCode
    static constraints = {
        searchUrl url: true
    }
}
