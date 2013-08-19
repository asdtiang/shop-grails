package org.asdtiang.shop

import org.asdtiang.grails.annotation.Title
import org.asdtiang.shop.logistics.LogisticsInfo

/**
 * Created with IntelliJ IDEA.
 * User: asdtiang
 * Date: 13-7-1
 * Time: 上午11:24
 * To change this template use File | Settings | File Templates.
 */
@Title("用户信息")
class OrderInfo {
    @Title("姓名")
    String name
    @Title("电话")
    String tel
    @Title("地址")
    String address
    @Title("邮箱")
    String email
    @Title("邮政编码")
    String postcode
    @Title("备注")
    String remark
    @Title("订单状态")
    OrderStatus orderStatus
    /**
     * 数据结构为list,list内数据为
     *  ProductChildType  type //订单产品类型
     *  int number             //所订的数量
     *  这个类型会在controller中定义
     */
    @Title("订单数据")
    String orderJson
    @Title("物流信息")
    LogisticsInfo  logisticsInfo

    static constraints = {
        email email: true
        name require:true
    }
    static mapping = {
        logisticsInfo lazy: false
        orderJson type:'text'
    }
    static enum  OrderStatus{
        SUBMIT(0,"提交"),
        PROCESSING(1,"正在处理"),
        SEND(2,"已经发贷"),
        FINISH(3,"完成") ,
        ERROR(4,"出错")
    }

}


