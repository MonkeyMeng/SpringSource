package com.monkey.myspring.ciculardependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;


@Service
@Lazy
public class B {

	@Autowired
	private C c;



}
