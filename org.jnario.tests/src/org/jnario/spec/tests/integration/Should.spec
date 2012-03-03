/*******************************************************************************
 * Copyright (c) 2012 BMW Car IT and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.jnario.spec.tests.integration


import static extension org.jnario.jnario.test.util.Helpers.*
import static org.hamcrest.CoreMatchers.*
import static org.hamcrest.Matchers.*

/*
 * You can use the `should` statement to express the expected behavior of objects.
 */
describe "Using Should"{

	/*
	 * `should` and `must` pass if the result of the left expression is 
	 * equal to the result of the right expression. You can use `not` to 
	 * assert that the expressions have different results. There is also 
	 * a short cut available: `=>` which has the same effect as `should be`.
	 */	
	- "To pass.."{
		true should be true
		"hello" must be "hello"
		1 + 1 should not be 1 
		"hello".toUpperCase must not be "Hello"
		"something" should not be null 
		1 + 1 => 2 
		"a string" => typeof(String)
	}     
	    
	/*     
	 * `should` and `must` throw an AssertionError if the result of the left 
	 * expression does not equal the result of the right expression.
	 */
	- "...or not to pass"{
			expect(typeof(AssertionError))[
			  1 + 1 should be 1
			]
			expect(typeof(AssertionError))[
			  1 + 1 should not be 1
			]
			expect(typeof(AssertionError))[
			  1 + 1 => 1
			]			
		}   
 
		/*
	 * When failing, `should` and `=>` try to give you as much context information as possible. 
	 * The error message will print the values of all expressions and their subexpressions.
	 *  
	 */
	- "Why did it fail?"{
		errorMessage[1 + 1 => 1].is('''
		  Expected 1 + 1 => 1 but:
		       1 + 1 is 2''')	
		
		val x = "hello"        
		errorMessage[x.toUpperCase should not be "HELLO"].is('''
		  Expected x.toUpperCase should not be "HELLO" but:
		       x.toUpperCase is "HELLO"
		       x is "hello"''')	  
		       
		val y = "world"        
		errorMessage[x => y].is('''
		  Expected x => y but:
		       x is "hello"
		       y is "world"''')	  
	}  
		
    
	/*
	 * You can also the `should`and `=>` together with [Hamcrest](http://code.google.com/p/hamcrest/) 
	 * matchers. You need to add the following static import statements to run the following examples.
	 *  
	 *     import static org.hamcrest.CoreMatchers.startsWith
	 *     import static org.hamcrest.Matchers.hasItem
	 * 
	 * In this example we use these matchers together with `=>` statement.
	 */ 
	- "Combining hamcrest and should"{
		"hello" => startsWith("h")
		newArrayList("red", "green") => hasItem("red")
	}
		
}