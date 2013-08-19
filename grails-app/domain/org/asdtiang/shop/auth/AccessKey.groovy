package org.asdtiang.shop.auth

import org.asdtiang.grails.annotation.Title

/**
 * Created with IntelliJ IDEA.
 * User: asdtiang
 * Date: 13-7-7
 * Time: 上午10:31
 * To change this template use File | Settings | File Templates.
 */
@Title("访问api key")
class AccessKey {
    @Title("名称")
    String name
    @Title("keyValue")
    String keyValue

}
