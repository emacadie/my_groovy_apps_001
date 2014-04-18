/*
 * Copyright 2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package info.shelfunit

// import org.junit.Rule
// import org.junit.rules.TestName
import spock.lang.Specification

import java.lang.reflect.Method

class MoreTest extends Specification {
  // @Rule 
  // TestName name = new TestName()

  def "retrieve test name at runtime"() {
    println "entering methodName"
    expect: 1 + 1 == 2
    Method[] methodList = this.getClass().getMethods()
    println("methodList.size(): " + methodList.size( ) )
    // methodList.eachWithIndex() {  obj, i -> println( " ${ i}: ${ obj}") } 
    println("---------------- HEY LADIES ---------------------------")
    methodList.each { obj -> print(obj.getName() + ", " ) }
    println( " ")
    println("---------------- HEY LADIES ---------------------------")
    println "leaving methodName"
    
  }
}
