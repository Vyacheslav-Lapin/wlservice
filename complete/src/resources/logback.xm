<?xml version="1.0" encoding="UTF-8"?>
<configuration>
    <appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
        <layout class="ch.qos.logback.classic.PatternLayout">
            <Pattern>%d [%15.15t] %-5p %30.30c - %m%n</Pattern>
        </layout>
    </appender>
    <root level="TRACE">
    <!--<root level="ERROR">-->
        <appender-ref ref="STDOUT"/>
    </root>
</configuration>