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

package org.springframework.core.type.classreading;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.asm.ClassReader;
import org.springframework.core.NestedIOException;
import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.lang.Nullable;

/**
 * {@link MetadataReader} implementation based on an ASM
 * {@link org.springframework.asm.ClassReader}.
 *
 * <p>Package-visible in order to allow for repackaging the ASM library
 * without effect on users of the {@code core.type} package.
 *
 * @author Juergen Hoeller
 * @author Costin Leau
 * @since 2.5
 */
final class SimpleMetadataReader implements MetadataReader {

	private final Resource resource;

	private final ClassMetadata classMetadata;

	private final AnnotationMetadata annotationMetadata;


	SimpleMetadataReader(Resource resource, @Nullable ClassLoader classLoader) throws IOException {
		InputStream is = new BufferedInputStream(resource.getInputStream());
		ClassReader classReader;
		try {
			classReader = new ClassReader(is);
		}
		catch (IllegalArgumentException ex) {
			throw new NestedIOException("ASM ClassReader failed to parse class file - " +
					"probably due to a new Java class file version that isn't supported yet: " + resource, ex);
		}
		finally {
			is.close();
		}

		//这是一个访问者设计模式
		//访问者设计模式主要用在对象结构相对稳定 操作经常扩展的情况下 实际上是将结构和操作分离开
		//这里的情况下ClassReader 的对象结构固定 但是针对这个对象的访问可能会经常扩展
		//https://www.jianshu.com/p/1f1049d0a0f4
		AnnotationMetadataReadingVisitor visitor = new AnnotationMetadataReadingVisitor(classLoader);
		classReader.accept(visitor, ClassReader.SKIP_DEBUG);

		this.annotationMetadata = visitor;
		// (since AnnotationMetadataReadingVisitor extends ClassMetadataReadingVisitor)
		this.classMetadata = visitor;
		this.resource = resource;
	}


	@Override
	public Resource getResource() {
		return this.resource;
	}

	@Override
	public ClassMetadata getClassMetadata() {
		return this.classMetadata;
	}

	@Override
	public AnnotationMetadata getAnnotationMetadata() {
		return this.annotationMetadata;
	}

}
