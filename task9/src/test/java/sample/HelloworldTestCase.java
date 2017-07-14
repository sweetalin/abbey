/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.    
 
package sample;

import org.junit.Assert;
import org.junit.Test;
import org.oasisopen.sca.NoSuchServiceException;
import org.apache.tuscany.sca.TuscanyRuntime;
import org.apache.tuscany.sca.node.Node;  
import org.apache.tuscany.sca.node.NodeFactory;  

public class HelloworldTestCase {

    @Test
    public void testSayHello() throws NoSuchServiceException {

        // Run the SCA composite in a Tuscany runtime
//    	System.getproperty(¡°java.classpath¡±);
//    	Node node = TuscanyRuntime.runComposite("helloworld.composite", "target/classes");
//    	SCADomain domain = SCADomain.newInstance("helloworld.composite"); 
    	Node node = NodeFactory.newInstance().createNode("helloworld.composite");  
        node.start();  
        try {
            
            // Get the Helloworld service proxy
        	System.out.println("service Æô¶¯");  
            Helloworld helloworld = node.getService(HelloworldImpl.class, "HelloworldComponent");
            System.out.println(helloworld.sayHello("Amelia"));
            // test that it works as expected
            Assert.assertEquals("Hello Amelia", helloworld.sayHello("Amelia"));
            
            
        } catch (Exception e) {
			// TODO: handle exception
        	e.printStackTrace();
		}finally {
            // Stop the Tuscany runtime Node
            node.stop();    
            System.out.println("service ¹Ø±Õ");
        }
    }
}
*/