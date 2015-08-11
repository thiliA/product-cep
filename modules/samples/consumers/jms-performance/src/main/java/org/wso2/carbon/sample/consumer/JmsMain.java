/*
 * Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  WSO2 Inc. licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */

package org.wso2.carbon.sample.consumer;

import javax.naming.NamingException;

public class JmsMain {


    public static void main(String[] args) throws NamingException, InterruptedException {

        int consumers = 50;
        int warmUpCount = 50000;
        if (args.length > 0) {
            consumers = Integer.parseInt(args[0].trim());
        }
        if (args.length > 1) {
            warmUpCount = Integer.parseInt(args[1].trim());
        }

        for (int i = 0;i < consumers; i++) {
            new JMSQueueMessageConsumer("myQueue", consumers, warmUpCount/consumers).listen("" + i);
        }
    }
}
