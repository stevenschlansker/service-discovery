package com.nesscomputing.service.discovery.dns;

import org.skife.config.Config;
import org.skife.config.Default;
import org.skife.config.DefaultNull;
import org.skife.config.TimeSpan;

interface DiscoveryDnsUpdateConfig
{
    @Config("ness.discovery.dns.zone")
    String getUpdateZone();

    @Config("ness.discovery.dns.server")
    @DefaultNull
    String getUpdateServer();

    @Config("ness.discovery.dns.tsig.name")
    String getTSIGKeyName();

    @Config("ness.discovery.dns.tsig.secret")
    String getTSIGKeySecret();

    @Config("ness.discovery.dns.publish-srv")
    @Default("true")
    boolean isPublishSrv();

    @Config("ness.discovery.dns.publish-a")
    @Default("true")
    boolean isPublishA();

    @Config("ness.discovery.dns.update-interval")
    @Default("10s")
    TimeSpan getUpdateInterval();

    @Config("ness.discovery.dns.tcp")
    @Default("true")
    boolean isTCP();
}
