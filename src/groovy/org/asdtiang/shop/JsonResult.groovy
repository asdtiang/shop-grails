package org.asdtiang.shop

/**
 * 数据统一返回bean
 * User: asdtiang
 * Date: 13-7-7
 * Time: 上午11:43
 * To change this template use File | Settings | File Templates.
 */
class JsonResult {
    ResultType resultType
    Object result
    String errorInfo
}
enum ResultType{
    SUCCESS,
    ERROR
}
