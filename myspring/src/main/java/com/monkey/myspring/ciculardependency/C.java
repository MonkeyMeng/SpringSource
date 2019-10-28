package com.monkey.myspring.ciculardependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class C {

	@Autowired
	private A a;

}
