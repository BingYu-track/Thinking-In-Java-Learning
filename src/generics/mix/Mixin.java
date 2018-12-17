/**
 * Project: MyTest
 * <p>
 * File Created at 2018/12/17
 * <p>
 * Copyright 2018 e-dewin.com Corporation Limited.
 * All rights reserved.
 * <p>
 * This software is the confidential and proprietary information of
 * dewin Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with e-dewin.com.
 */
package generics.mix;

/**
 * @Description: 使用接口代理达到混型效果，但不足的一点是需要每个混入类型都需要一个域
 * @author: hxw
 * @version 1.0
 * @date: 2018/12/17 12:34
 */
class Mixin extends BasicImp implements TimeStamped, SerialNumbered{

    private TimeStamped timeStamp = new TimeStampedImp();
    private SerialNumbered serialNumber = new SerialNumberedImp();

    public long getStamp() {
        return timeStamp.getStamp();
    }
    public long getSerialNumber() {
        return serialNumber.getSerialNumber();
    }
}
