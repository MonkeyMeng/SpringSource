package com.monkey.myspring.mylistener;/**
 * @author monkey_meng
 * @create 2020-03-09 17:09
 * @desc
 **/

import org.springframework.context.ApplicationEvent;

/**
 * @author monkey_meng

 * @create 2020-03-09 17:09

 * @desc
 **/
public class MyEvent extends ApplicationEvent {


	public static final long serialVersionUID = 1L;



	/**
	 * Create a new ApplicationEvent.
	 *
	 * @param source the object on which the event initially occurred (never {@code null})
	 */
	public MyEvent(Object source) {
		super(source);
	}
}
