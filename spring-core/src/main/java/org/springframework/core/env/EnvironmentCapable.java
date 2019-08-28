/*
 * Copyright 2002-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.core.env;

/**
 * 实现这个接口的类需要包含一个Environment类型的引用并把它暴露出去
 * Interface indicating a component that contains and exposes an {@link Environment} reference.
 *
 * 所有的Spring容器都实现了这个接口
 * <p>All Spring application contexts are EnvironmentCapable,
 * 这个接口主要用来进行框架方法的检查
 * and the interface is used primarily for performing {@code instanceof} checks in framework methods
 * 检查哪些方法呢？ 这些方法接收 BeanFactory的实例 这些实例有可能不是ApplicationContext 的实例
 * that accept BeanFactory instances that may or may not actually be ApplicationContext instances
 * 当确实需要这些变量的时候 spring可以通过这个方法去取
 * in order to interact with the environment if indeed it is available.
 *
 * 直白的理解一下 Capable表示一种能力 EnvironmentCapable就说明这个接口有提供Environment的能力 这个时候如果用户自己定义了一些BeanFactory
 * 想要用spring框架的方法 那么就需要实现这个接口 来保证spring框架中的方法可以通过 getEnvironment取到 该beanbfactory依赖的Environment 至于
 * 这个Environment里有什么东西 那就自己定义吧
 *
 * <p>As mentioned, {@link org.springframework.context.ApplicationContext ApplicationContext}
 * extends EnvironmentCapable, and thus exposes a {@link #getEnvironment()} method; however,
 * {@link org.springframework.context.ConfigurableApplicationContext ConfigurableApplicationContext}
 * redefines {@link org.springframework.context.ConfigurableApplicationContext#getEnvironment
 * getEnvironment()} and narrows the signature to return a {@link ConfigurableEnvironment}.
 * The effect is that an Environment object is 'read-only' until it is being accessed from
 * a ConfigurableApplicationContext, at which point it too may be configured.
 *
 * @author Chris Beams
 * @since 3.1
 * @see Environment
 * @see ConfigurableEnvironment
 * @see org.springframework.context.ConfigurableApplicationContext#getEnvironment()
 */
public interface EnvironmentCapable {

	/**
	 * Return the {@link Environment} associated with this component.
	 */
	Environment getEnvironment();

}
