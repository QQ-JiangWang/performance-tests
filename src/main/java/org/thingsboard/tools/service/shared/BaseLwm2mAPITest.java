/**
 * Copyright © 2016-2018 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.tools.service.shared;

import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.thingsboard.mqtt.MqttClient;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public abstract class BaseLwm2mAPITest extends AbstractAPITest {

    private static final int CONNECT_TIMEOUT = 5;
    private EventLoopGroup EVENT_LOOP_GROUP;

    @Value("${lwm2m.noSec.server.host:localhost}")
    private String lwm2mHost;
    @Value("${lwm2m.noSec.server.port:5685}")
    private int lwm2mPort;

    @PostConstruct
    protected void init() {
        super.init();
        EVENT_LOOP_GROUP = new NioEventLoopGroup();
    }

    @PreDestroy
    public void destroy() {
        super.destroy();
        if (!EVENT_LOOP_GROUP.isShutdown()) {
            EVENT_LOOP_GROUP.shutdownGracefully(0, 5, TimeUnit.SECONDS);
        }
    }


    protected void runApiTestIteration(int iteration,
                                       AtomicInteger totalSuccessPublishedCount,
                                       AtomicInteger totalFailedPublishedCount,
                                       CountDownLatch testDurationLatch) {
    }

}
